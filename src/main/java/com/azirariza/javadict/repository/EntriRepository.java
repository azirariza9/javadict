package com.azirariza.javadict.repository;

import com.azirariza.javadict.entity.Entri;
import com.azirariza.javadict.entity.dto.EntriDTOInsert;
import com.azirariza.javadict.entity.dto.EntriDTOUpdate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EntriRepository {
    private final JdbcTemplate jdbcTemplate;

    public EntriRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class EntriRowMapper implements RowMapper<Entri> {
        @Override
        public Entri mapRow(ResultSet rs, int rowNum) throws SQLException {
            Entri entri = new Entri();
            entri.setIdEntri(rs.getInt("id_entri"));
            entri.setIdKata(rs.getString("id_kata"));
            entri.setNama(rs.getString("nama"));
            entri.setNomor(rs.getInt("nomor"));
            entri.setPelafalan(rs.getString("pelafalan"));
            return entri;
        }
    }

    public List<Entri> findAll() {
        String sql = "SELECT id_entri,id_kata,nama,nomor,pelafalan FROM entri";
        return jdbcTemplate.query(sql, new EntriRowMapper());
    }

    public Optional<Entri> findById(String id) {
        String sql = "SELECT id_entri,id_kata,nama,nomor,pelafalan  FROM entri WHERE id_entri = ?";
        return jdbcTemplate.query(sql, new EntriRowMapper(), id)
                .stream()
                .findFirst();
    }

    public Entri insert(EntriDTOInsert entriDTO) {
        String sql = "INSERT INTO entri (id_kata,nama,nomor,pelafalan) VALUES (?,?,?,?) RETURNING id_entri";
        Entri entri = new Entri();
        int idEntri = jdbcTemplate.queryForObject(sql, int.class,
                entri.getIdKata(),
                entri.getNama(),
                entri.getNomor(),
                entri.getPelafalan());
        entri.setIdEntri(idEntri);
        return entri;
    }

    public Entri update(int idEntri, EntriDTOUpdate entriDTO) {
        String sql = "UPDATE entri SET nama = ?,SET nomor = ?,SET pelafalan = ?  WHERE id_entri = ?";
        Entri updatedEntri = new Entri();
        updatedEntri.setIdEntri(idEntri);
        ;
        updatedEntri.setNama(entriDTO.getNama());
        updatedEntri.setNomor(entriDTO.getNomor());
        updatedEntri.setPelafalan(entriDTO.getPelafalan());

        String idKata = jdbcTemplate.queryForObject(sql, String.class,
                entriDTO.getNama(),
                entriDTO.getNomor(),
                entriDTO.getPelafalan(),
                idEntri);
        updatedEntri.setIdKata(idKata);

        return updatedEntri;
    }

    public void deleteById(int idEntri) {
        String sql = "DELETE FROM entri WHERE id_entri = ?";
        jdbcTemplate.update(sql, idEntri);
    }

}
