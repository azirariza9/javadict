package com.azirariza.javadict.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.azirariza.javadict.entity.Makna;
import com.azirariza.javadict.entity.dto.MaknaDTOInsert;
import com.azirariza.javadict.entity.dto.MaknaDTOUpdate;

@Repository
public class MaknaRepository {
    private final JdbcTemplate jdbcTemplate;

    public MaknaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class MaknaRowMapper implements RowMapper<Makna> {
        @Override
        public Makna mapRow(ResultSet rs, int rowNum) throws SQLException {
            Makna makna = new Makna();
            makna.setIdMakna(rs.getInt("id_makna"));
            makna.setIdEntri(rs.getInt("id_entri"));
            makna.setInfo(rs.getString("info"));
            return makna;
        }
    }

    public List<Makna> findAll() {
        String sql = "SELECT id_makna,id_entri,info FROM makna";
        return jdbcTemplate.query(sql, new MaknaRowMapper());
    }

    public Optional<Makna> findById(int id) {
        String sql = "SELECT id_makna,id_entri,info FROM makna WHERE id_makna = ?";
        return jdbcTemplate.query(sql, new MaknaRowMapper(), id)
                .stream()
                .findFirst();
    }

    public Makna insert(MaknaDTOInsert maknaDTO) {
        String sql = "INSERT INTO makna (id_entri,info) VALUES (?,?) RETURNING id_makna";
        Makna makna = new Makna();
        int idMakna = jdbcTemplate.queryForObject(sql, int.class,
                maknaDTO.getIdEntri(),
                maknaDTO.getInfo());
        makna.setIdMakna(idMakna);
        makna.setIdEntri(maknaDTO.getIdEntri());
        makna.setInfo(maknaDTO.getInfo());
        return makna;
    }

    public Makna update(int idMakna, MaknaDTOUpdate maknaDTO) {
        String sql = "UPDATE makna SET info = ?  WHERE id_makna = ? RETURNING id_entri";
        Makna updatedMakna = new Makna();
        updatedMakna.setIdMakna(idMakna);
        ;
        updatedMakna.setInfo(maknaDTO.getInfo());

        int idEntri = jdbcTemplate.queryForObject(sql, int.class,
                maknaDTO.getInfo(),
                idMakna);
        updatedMakna.setIdEntri(idEntri);

        return updatedMakna;
    }

    public void deleteById(int idMakna) {
        String sql = "DELETE FROM makna WHERE id_makna = ?";
        jdbcTemplate.update(sql, idMakna);
    }

}
