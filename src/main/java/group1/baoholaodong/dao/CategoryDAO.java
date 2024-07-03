package group1.baoholaodong.dao;

import group1.baoholaodong.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
            // Lấy giá trị Timestamp và chuyển đổi sang LocalDateTime nếu không null
            Timestamp createdAtTimestamp = rs.getTimestamp("created_at");
            if (createdAtTimestamp != null) {
                category.setCreateAt(createdAtTimestamp.toLocalDateTime());
            }

            Timestamp updatedAtTimestamp = rs.getTimestamp("updated_at");
            if (updatedAtTimestamp != null) {
                category.setUpdateAt(updatedAtTimestamp.toLocalDateTime());
            }

            category.setStatus(rs.getByte("status"));
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


//    public int save (Category category){
//        String sql="INSERT INTO category(name, description, created_at, upated_at, status, parent_id) values ()"
//    }
}
