package com.project.dvdrental.Filme.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.project.dvdrental.Filme.Model.Filme;
import com.project.dvdrental.Filme.Model.Idioma;

@Repository
public class FilmeRepositoryImpl implements FilmeRepository {

    private static String SELECT_ONE = " select * from film where film_id = ?";
    private static String INSERT = " insert into film (film_id, title, description, release_year,"
            + " language_id, rental_duration, rental_rate, length, replacement_cost, special_features) "
            + " values (nextval('film_film_id_seq'),?,?,?,?,?,?,?,?,?::text[]) ";
    private static String UPDATE_NAME = "update film set title = ? where film_id = ?";
    private static String UPDATE_CATEGORY = "update film_category set category_id = ? where film_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IdiomaRepository idiomaRepo;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Filme obterPorIdFilme(Integer id) {

        return jdbcTemplate.queryForObject(SELECT_ONE, new Object[] { id }, new RowMapper<Filme>() {
            @Override
            public Filme mapRow(ResultSet rs, int rownumber) throws SQLException {

                Filme filme = new Filme();

                filme.setFilmeId(rs.getInt("film_id"));
                filme.setTitulo(rs.getString("title"));
                filme.setDescricao(rs.getString("description"));
                filme.setAnoLancamento(rs.getInt("release_year"));

                Integer idiomaId = rs.getInt("language_id");
                Idioma idioma = idiomaRepo.obterPorIdIdioma(idiomaId);
                filme.setIdioma(idioma);

                filme.setTempoAluguel(rs.getInt("rental_duration"));
                filme.setAvaliacaoAluguel(rs.getDouble("rental_rate"));
                filme.setComprimento(rs.getInt("length"));
                filme.setCustoSubstituicao(rs.getDouble("replacement_cost"));
                filme.setAvaliacao(rs.getString("rating"));
                filme.setUltimaAtualizacao(rs.getString("last_update"));
                filme.setFuncionalidadesEspeciais(rs.getString("special_features"));
                filme.setTextoCompleto(rs.getString("fulltext"));

                return filme;
            }
        });

    }

    public Filme salvarFilme(Filme filme) {

        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, filme.getTitulo());
                ps.setString(2, filme.getDescricao());
                ps.setInt(3, filme.getAnoLancamento());
                ps.setInt(4, filme.getIdioma().getId());
                ps.setInt(5, filme.getTempoAluguel());
                ps.setDouble(6, filme.getAvaliacaoAluguel());
                ps.setInt(7, filme.getComprimento());
                ps.setDouble(8, filme.getCustoSubstituicao());
                ps.setString(9, filme.getFuncionalidadesEspeciais().toString());
                return ps;
            }
        }, holder);

        Integer id = (Integer) holder.getKeys().get("film_id");
        filme.setFilmeId(id);

        return filme;

    }

    public Filme atualizarNomeFilme(Filme filme, String nome) {
       
        jdbcTemplate.update(UPDATE_NAME, new Object[] {nome, filme.getFilmeId()});

        return obterPorIdFilme(filme.getFilmeId());

    }

    public Filme atualizarCategoriaFilme(Filme filme, Integer categoria) {
       
        jdbcTemplate.update(UPDATE_CATEGORY, new Object[] {categoria, filme.getFilmeId()});

        return obterPorIdFilme(filme.getFilmeId());

    }
}
