package group1.baoholaodong.dao;


import group1.baoholaodong.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class CategoryDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class CategoryRowMapper implements RowMapper<Category>{

        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
            category.setCreatedAt((java.sql.Date) rs.getObject("created_at"));
            category.setUpdatedAt((java.sql.Date)  rs.getObject("updated_at"));
            category.setStatus(rs.getByte("status"));
            category.setParentId(rs.getInt("parent_id"));
            return category;
        }
    }

    public List<Category> findAll(){
        //language=SQL
        String sql = "SELECT * FROM category";
        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }

    public Category findById(int id){
        //language=SQL
        String sql = "SELECT * FROM category WHERE  id = ?";
        return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), id);
    }

    public int count() {
        String sql = "SELECT COUNT(*) FROM category";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<Category> findAll(int page, int size) {
        int offset = (page-1) * size;
        String sql = "SELECT * FROM category ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        return jdbcTemplate.query(sql, new Object[]{offset, size}, new CategoryRowMapper());
    }

    public int insert(Category category) {
        // Ensure that category.getParentId() returns an Integer
        Integer parentId = category.getParentId();
        if (parentId != null && hasCycle(category.getId(), category.getParentId())) {
            throw new IllegalArgumentException("Cycle detected in category hierarchy");
        }
        String sql = "INSERT INTO category (name, description, created_at, updated_at, status, parent_id) VALUES (?, ?, ?, ?, ?, ?)";
        LocalDate currentDate = LocalDate.now();
        return jdbcTemplate.update(sql, category.getName(), category.getDescription(), currentDate, currentDate, category.getStatus(), category.getParentId());
    }


    public int update(Category category) {
        Integer parentId = category.getParentId();
        if (parentId != null && hasCycle(category.getId(), category.getParentId())) {
            throw new IllegalArgumentException("Cycle detected in category hierarchy");
        }

        String sql = "UPDATE category SET name = ?, description = ?, created_at = ?, updated_at = ?, status = ?, parent_id = ? WHERE id = ?";
        LocalDate currentDate = LocalDate.now();
        return jdbcTemplate.update(sql,
                new Object[]{
                        category.getName(),
                        category.getDescription(),
                        category.getCreatedAt(),
                        currentDate,
                        category.getStatus(),
                        category.getParentId(),
                        category.getId()
                });
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from category where id=?", new Object[]{id});
    }


    public boolean hasCycle(int categoryId, Integer parentId) {
        Integer currentParentId = parentId;

        while (currentParentId != null) {
            if (currentParentId == categoryId) {
                return true;
            }

            String sql = "SELECT parent_id FROM category WHERE id = ?";
            currentParentId = jdbcTemplate.queryForObject(sql, new Object[]{currentParentId}, Integer.class);
        }

        return false;
    }

}
