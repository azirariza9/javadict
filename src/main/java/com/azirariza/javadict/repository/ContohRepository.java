package com.azirariza.javadict.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.azirariza.javadict.entity.Contoh;
import com.azirariza.javadict.entity.dto.ContohDTOInsert;
import com.azirariza.javadict.entity.dto.ContohDTOUpdate;

@Repository
public class ContohRepository {
    private final JdbcTemplate jdbcTemplate;

    public ContohRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class ContohRowMapper implements RowMapper<Contoh> {
        @Override
        public Contoh mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contoh contoh = new Contoh();
            contoh.setIdContoh(rs.getInt("id_contoh"));
            contoh.setIdMakna(rs.getInt("id_makna"));
            contoh.setTeks(rs.getString("teks"));
            return contoh;
        }
    }

    public List<Contoh> findAll() {
        String sql = "SELECT id_contoh,id_makna,teks FROM contoh";
        return jdbcTemplate.query(sql, new ContohRowMapper());
    }

    public Optional<Contoh> findById(int id) {
        String sql = "SELECT id_makna,teks FROM contoh WHERE id_contoh = ?";
        return jdbcTemplate.query(sql, new ContohRowMapper(), id)
                .stream()
                .findFirst();
    }

    public Contoh insert(ContohDTOInsert contohDTO) {
        String sql = "INSERT INTO contoh (id_makna,teks) VALUES (?,?) RETURNING id_contoh";
        Contoh contoh = new Contoh();
        int idContoh = jdbcTemplate.queryForObject(sql, int.class,
                contohDTO.getIdMakna(),
                contohDTO.getTeks());
        contoh.setIdContoh(idContoh);
        contoh.setIdMakna(contohDTO.getIdMakna());
        contoh.setTeks(contohDTO.getTeks());
        return contoh;
    }

    public Contoh update(int idContoh, ContohDTOUpdate contohDTO) {
        String sql = "UPDATE contoh SET teks = ? WHERE id_contoh = ? RETURNING id_makna";
        Contoh updatedContoh = new Contoh();
        updatedContoh.setIdContoh(idContoh);
        ;
        updatedContoh.setTeks(contohDTO.getTeks());

        int idMakna = jdbcTemplate.queryForObject(sql, int.class,
                contohDTO.getTeks(),
                idContoh);
        updatedContoh.setIdMakna(idMakna);

        return updatedContoh;
    }

    public void deleteById(int idContoh) {
        String sql = "DELETE FROM contoh WHERE id_contoh = ?";
        jdbcTemplate.update(sql, idContoh);
    }

}
