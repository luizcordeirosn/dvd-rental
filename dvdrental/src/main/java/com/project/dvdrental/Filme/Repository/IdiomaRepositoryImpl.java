package com.project.dvdrental.Filme.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.dvdrental.Filme.Model.Idioma;

@Repository
public class IdiomaRepositoryImpl implements IdiomaRepository{

    private static String SELECT_ONE = " select * from language where language_id = ?";
    private static String SELECT_ONE_FILM = " select l.* from language l"
            + " inner join film f on f.language_id = l.language_id"
            + " where f.film_id = ?";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Idioma obterPorIdIdioma(Integer id) {

        return jdbcTemplate.queryForObject(SELECT_ONE, new Object[] {id}, new RowMapper<Idioma>() {
            @Override
            public Idioma mapRow(ResultSet rs, int rownumber) throws SQLException {
                
                Idioma idioma = new Idioma();

                idioma.setId(rs.getInt("language_id"));
                idioma.setNome(rs.getString("name"));

                return idioma;
            }
        });

    }

    public Idioma obterPorFilmeIdioma(Integer filme) {

        return jdbcTemplate.queryForObject(SELECT_ONE_FILM, new Object[] {filme}, new RowMapper<Idioma>() {
            @Override
            public Idioma mapRow(ResultSet rs, int rownumber) throws SQLException {
                
                Idioma idioma = new Idioma();

                idioma.setId(rs.getInt("language_id"));
                idioma.setNome(rs.getString("name"));

                return idioma;
            }
        });

    }
    
}
