package group1.baoholaodong.repository;

import group1.baoholaodong.mapper.MajorRowMapper;
import group1.baoholaodong.models.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MajorRepository {

    @Autowired
    JdbcTemplate conn;

    // Find all majors
    public List<Major> findAll() {
        String query = "SELECT * FROM major";
        return conn.query(query, new MajorRowMapper());
    }

    // Find major by ID
    public Major findById(int id) {
        String query = "SELECT * FROM major WHERE id = ?";
        try {
        	return conn.queryForObject(query, new MajorRowMapper(), id);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    // Create a new major
    public int create(Major major) {
        String query = "INSERT INTO major (name, description, created_at, status) VALUES (?, ?, ?, ?)";
        return conn.update(query, major.getName(), major.getDescription(), major.getCreatedAt(), major.getStatus());
    }

    // Update a major
    public int update(Major major) {
        String query = "UPDATE major SET name = ?, description = ?, created_at = ?, status = ? WHERE id = ?";
        return conn.update(query, major.getName(), major.getDescription(), major.getCreatedAt(), major.getStatus(), major.getId());
    }

    // Delete a major by ID
    public int delete(int id) {
        String query = "DELETE FROM major WHERE id = ?";
        return conn.update(query, id);
    }
}
