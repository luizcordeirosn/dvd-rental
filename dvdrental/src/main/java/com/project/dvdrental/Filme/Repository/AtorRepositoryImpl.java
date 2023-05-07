package com.project.dvdrental.Filme.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.project.dvdrental.Filme.Model.Ator;

@Repository
public class AtorRepositoryImpl implements AtorRepository {

    private static String SELECT_ONE = " select * from actor where actor_id = ?";
    private static String SELECT_ALL_FILM = " select * from actor a"
            + " inner join film_actor fa on fa.actor_id = a.actor_id"
            + " where fa.film_id = ?";
    private static String INSERT = " insert into actor (actor_id, first_name, last_name) "
            + " values (nextval('actor_actor_id_seq'),?,?) ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Ator obterPorIdAtor(Integer id) {

        return jdbcTemplate.queryForObject(SELECT_ONE, new Object[] { id }, new RowMapper<Ator>() {
            @Override
            public Ator mapRow(ResultSet rs, int rownumber) throws SQLException {

                Ator ator = new Ator();

                ator.setAtorId(rs.getInt("actor_id"));
                ator.setPrimeiroNome(rs.getString("first_name"));
                ator.setUltimoNome(rs.getString("last_name"));
                ator.setUltimaAtualizacao(rs.getString("last_update"));

                return ator;
            }
        });

    }

    public List<Ator> obterTodosAtoresPorFilme(Integer filme) {
        
        return jdbcTemplate.query(SELECT_ALL_FILM, new RowMapper<Ator>() {
            @Override
            public Ator mapRow(ResultSet rs, int rownumber) throws SQLException {

                Ator ator = new Ator();

                ator.setAtorId(rs.getInt("actor_id"));
                ator.setPrimeiroNome(rs.getString("first_name"));
                ator.setUltimoNome(rs.getString("last_name"));
                ator.setUltimaAtualizacao(rs.getString("last_update"));

                return ator;
            }
        }, filme);

    }

    public Ator salvarAtor(Ator ator) {

        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, ator.getPrimeiroNome());
                ps.setString(2, ator.getUltimoNome());
                return ps;
            }
        }, holder);

        Integer id = (Integer) holder.getKeys().get("actor_id");
        ator.setAtorId(id);

        return ator;

    }
}

