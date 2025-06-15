package com.azirariza.javadict.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.azirariza.javadict.entity.KelasMakna;
import com.azirariza.javadict.entity.dto.KelasMaknaDTOInsert;
import com.azirariza.javadict.entity.dto.KelasMaknaDTOUpdate;

@Repository
public class KelasMaknaRepository {
    private final JdbcTemplate jdbcTemplate;

    public KelasMaknaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class KelasMaknaRowMapper implements RowMapper<KelasMakna> {
        @Override
        public KelasMakna mapRow(ResultSet rs, int rowNum) throws SQLException {
            KelasMakna kelasMakna = new KelasMakna();
            kelasMakna.setIdKelasMakna(rs.getInt("id_kelas_makna"));
            kelasMakna.setIdMakna(rs.getInt("id_makna"));
            kelasMakna.setKode(rs.getString("kode"));
            kelasMakna.setNama(rs.getString("nama"));
            kelasMakna.setDeskripsi(rs.getString("deskripsi"));
            return kelasMakna;
        }
    }

    public List<KelasMakna> findAll() {
        String sql = "SELECT id_kelas_makna,id_makna,kode,nama,deskripsi FROM kelas_makna";
        return jdbcTemplate.query(sql, new KelasMaknaRowMapper());
    }

    public Optional<KelasMakna> findById(int id) {
        String sql = "SELECT id_makna,kode,nama,deskripsi  FROM kelasMakna WHERE id_kelas_makna = ?";
        return jdbcTemplate.query(sql, new KelasMaknaRowMapper(), id)
                .stream()
                .findFirst();
    }

    public KelasMakna insert(KelasMaknaDTOInsert kelasMaknaDTO) {
        String sql = "INSERT INTO kelas_makna (id_makna,kode,nama,deskripsi) VALUES (?,?,?,?) RETURNING id_kelas_makna";
        KelasMakna kelasMakna = new KelasMakna();
        int idKelasMakna = jdbcTemplate.queryForObject(sql, int.class,
                kelasMaknaDTO.getIdMakna(),
                kelasMaknaDTO.getKode(),
                kelasMaknaDTO.getNama(),
                kelasMaknaDTO.getDeskripsi());
        kelasMakna.setIdKelasMakna(idKelasMakna);
        kelasMakna.setIdMakna(kelasMaknaDTO.getIdMakna());
        kelasMakna.setKode(kelasMaknaDTO.getKode());
        kelasMakna.setNama(kelasMaknaDTO.getNama());
        kelasMakna.setDeskripsi(kelasMaknaDTO.getDeskripsi());
        return kelasMakna;
    }

    public KelasMakna update(int idKelasMakna, KelasMaknaDTOUpdate kelasMaknaDTO) {
        String sql = "UPDATE kelas_makna SET kode = ?,nama = ?,deskripsi = ?  WHERE id_kelas_makna = ? RETURNING id_makna";
        KelasMakna updatedKelasMakna = new KelasMakna();
        updatedKelasMakna.setIdKelasMakna(idKelasMakna);
        ;
        updatedKelasMakna.setKode(kelasMaknaDTO.getKode());
        updatedKelasMakna.setNama(kelasMaknaDTO.getNama());
        updatedKelasMakna.setDeskripsi(kelasMaknaDTO.getDeskripsi());

        int idMakna = jdbcTemplate.queryForObject(sql, int.class,
                kelasMaknaDTO.getKode(),
                kelasMaknaDTO.getNama(),
                kelasMaknaDTO.getDeskripsi(),
                idKelasMakna);
        updatedKelasMakna.setIdMakna(idMakna);

        return updatedKelasMakna;
    }

    public void deleteById(int idKelasMakna) {
        String sql = "DELETE FROM kelas_makna WHERE id_kelas_makna = ?";
        jdbcTemplate.update(sql, idKelasMakna);
    }

}
