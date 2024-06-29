package group1.baoholaodong.mapper;

import group1.baoholaodong.models.Major;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MajorRowMapper implements RowMapper<Major> {
    @Override
    public Major mapRow(ResultSet rs, int rowNum) throws SQLException {
        Major major = new Major();
        major.setId(rs.getInt("id"));
        major.setName(rs.getString("name"));
        major.setDescription(rs.getString("description"));
        major.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        major.setStatus(rs.getByte("status"));
        // set other fields if necessary
        return major;
    }
}
