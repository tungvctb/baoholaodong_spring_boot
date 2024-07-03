package group1.baoholaodong.dao;

import group1.baoholaodong.models.Manufacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ManufactureDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int create(Manufacture manufacture) {
        String sql = "INSERT INTO manufacturer (name, description, created_at, updated_at, status, prevStatus) VALUES (?, ?, ?, ?, ?, ?)";

        // Sử dụng LocalDateTime.now() để đặt giá trị mặc định cho created_at và updated_at
        LocalDateTime now = LocalDateTime.now();
        manufacture.setCreateAt(now);
        manufacture.setUpdateAt(now);
        manufacture.setStatus((byte) 2);
        manufacture.setPrevStatus((byte) 0);

        return jdbcTemplate.update(sql,
                manufacture.getName(),
                manufacture.getDescription(),
                manufacture.getCreateAt(),
                manufacture.getUpdateAt(),
                manufacture.getStatus(),
                manufacture.getPrevStatus()
        );
    }

    public List<Manufacture> findAll(){
        String sql = "SELECT * FROM manufacturer WHERE status = 2";
        return jdbcTemplate.query(sql, new ManuFactureRowMapper());
    }

    public Manufacture findById(int id) {
        String sql = "SELECT * FROM manufacturer WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new ManuFactureRowMapper(), id);
    }

    public int update(Manufacture manufacture) {
        String sql = "UPDATE manufacturer SET name = ?, description = ?, created_at = ?, updated_at = ?, status = ?, prevStatus = ? WHERE id = ?";

        return jdbcTemplate.update(sql,
                manufacture.getName(),
                manufacture.getDescription(),
                manufacture.getCreateAt(),
                LocalDateTime.now(),
                manufacture.getStatus(),
                manufacture.getPrevStatus(),
                manufacture.getId());
    }

    private static class ManuFactureRowMapper implements RowMapper<Manufacture>{

        @Override
        public Manufacture mapRow(ResultSet rs, int rowNum) throws SQLException {
            Manufacture manufactory = new Manufacture();
            manufactory.setId(rs.getInt("id"));
            manufactory.setName(rs.getString("name"));
            manufactory.setDescription(rs.getString("description"));

            Timestamp createAtTimestamp = rs.getTimestamp("created_at");
            if(createAtTimestamp != null){
                manufactory.setCreateAt(createAtTimestamp.toLocalDateTime());
            }

            Timestamp updateAtTimestamp = rs.getTimestamp("updated_at");
            if(updateAtTimestamp !=null){
                manufactory.setUpdateAt(updateAtTimestamp.toLocalDateTime());
            }

            manufactory.setStatus(rs.getByte("status"));
            manufactory.setPrevStatus(rs.getByte("prevStatus"));
            return manufactory;
        }
    }



}
