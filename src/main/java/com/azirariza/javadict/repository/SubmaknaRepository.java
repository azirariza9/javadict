package com.azirariza.javadict.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.azirariza.javadict.entity.Submakna;
import com.azirariza.javadict.entity.dto.SubmaknaDTOInsert;
import com.azirariza.javadict.entity.dto.SubmaknaDTOUpdate;

@Repository
public class SubmaknaRepository {
    private final JdbcTemplate jdbcTemplate;

    public SubmaknaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class SubmaknaRowMapper implements RowMapper<Submakna> {
        @Override
        public Submakna mapRow(ResultSet rs, int rowNum) throws SQLException {
            Submakna submakna = new Submakna();
            submakna.setIdSubmakna(rs.getInt("id_submakna"));
            submakna.setIdMakna(rs.getInt("id_makna"));
            submakna.setTeks(rs.getString("teks"));
            return submakna;
        }
    }

    public List<Submakna> findAll() {
        String sql = "SELECT id_submakna,id_makna,teks FROM submakna";
        return jdbcTemplate.query(sql, new SubmaknaRowMapper());
    }

    public Optional<Submakna> findById(int id) {
        String sql = "SELECT id_submakna,id_makna,teks FROM submakna WHERE id_submakna = ?";
        return jdbcTemplate.query(sql, new SubmaknaRowMapper(), id)
                .stream()
                .findFirst();
    }

    public Submakna insert(SubmaknaDTOInsert submaknaDTO) {
        String sql = "INSERT INTO submakna (id_makna,teks) VALUES (?,?) RETURNING id_submakna";
        Submakna submakna = new Submakna();
        int idSubmakna = jdbcTemplate.queryForObject(sql, int.class,
                submaknaDTO.getIdMakna(),
                submaknaDTO.getTeks());
        submakna.setIdSubmakna(idSubmakna);
        submakna.setIdMakna(submaknaDTO.getIdMakna());
        submakna.setTeks(submaknaDTO.getTeks());
        return submakna;
    }

    public Submakna update(int idSubmakna, SubmaknaDTOUpdate submaknaDTO) {
        String sql = "UPDATE submakna SET teks = ? WHERE id_submakna = ? RETURNING id_makna";
        Submakna updatedSubmakna = new Submakna();
        updatedSubmakna.setIdSubmakna(idSubmakna);
        ;
        updatedSubmakna.setTeks(submaknaDTO.getTeks());

        int idMakna = jdbcTemplate.queryForObject(sql, int.class,
                submaknaDTO.getTeks(),
                idSubmakna);
        updatedSubmakna.setIdMakna(idMakna);

        return updatedSubmakna;
    }

    public void deleteById(int idSubmakna) {
        String sql = "DELETE FROM submakna WHERE id_submakna = ?";
        jdbcTemplate.update(sql, idSubmakna);
    }

}
