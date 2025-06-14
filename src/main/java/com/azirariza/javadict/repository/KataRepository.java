package com.azirariza.javadict.repository;

import com.azirariza.javadict.entity.Kata;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class KataRepository {
    private final JdbcTemplate jdbcTemplate;

    public KataRepository(JdbcTemplate jdbcTemplate) {
        System.out.println("KataRepository initialized!");
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class KataRowMapper implements RowMapper<Kata> {
        @Override
        public Kata mapRow(ResultSet rs, int rowNum) throws SQLException {
            Kata kata = new Kata();
            kata.setIdKata(rs.getString("id_kata"));
            kata.setPranala(rs.getString("pranala"));
            return kata;
        }
    }

    public List<Kata> findAll() {
        String sql = "SELECT id_kata,pranala FROM kata";
        return jdbcTemplate.query(sql, new KataRowMapper());
    }

    public Optional<Kata> findById(String id) {
        String sql = "SELECT id_kata,pranala FROM kata WHERE id_kata = ?";
        return jdbcTemplate.query(sql, new KataRowMapper(), id)
                .stream()
                .findFirst();
    }

    public Kata insert(Kata kata) {
        String sql = "INSERT INTO kata (id_kata,pranala) VALUES (?,?)";
        int rowsAffected = jdbcTemplate.update(sql, kata.getIdKata(), kata.getPranala());
        if (rowsAffected != 1) {
            throw new DataAccessException("Insert failed: " + kata) {
            };
        }
        return kata;
    }

    public Kata update(Kata kata) {
        String sql = "UPDATE kata SET pranala = ?  WHERE id_kata = ?";
        int rowsAffected = jdbcTemplate.update(sql, kata.getPranala(),kata.getIdKata() );
                if (rowsAffected != 1) {
            throw new DataAccessException("Insert failed: " + kata) {
            };
        }
  
        return kata;
    }

    public void deleteById(String id) {
        String sql = "DELETE FROM kata WHERE id_kata = ?";
        jdbcTemplate.update(sql, id);
    }
}
