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
import com.project.dvdrental.Filme.Model.Categoria;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private static String SELECT_ONE = " select * from category where category_id = ?";
    private static String INSERT = " insert into category (category_id, name) "
            + " values (nextval('category_category_id_seq'),?) ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Categoria obterPorIdCategoria(Integer id) {

        return jdbcTemplate.queryForObject(SELECT_ONE, new Object[] { id }, new RowMapper<Categoria>() {
            @Override
            public Categoria mapRow(ResultSet rs, int rownumber) throws SQLException {

                Categoria ator = new Categoria();

                ator.setCategoriaId(rs.getInt("category_id"));
                ator.setNome(rs.getString("name"));
                ator.setUltimaAtualizacao(rs.getTimestamp("last_update"));

                return ator;
            }
        });

    }

    public Categoria salvarCategoria(Categoria ator) {

        KeyHolder holder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, ator.getNome());
                return ps;
            }
        }, holder);

        Integer id = (Integer) holder.getKeys().get("category_id");
        ator.setCategoriaId(id);

        return ator;

    }
}


