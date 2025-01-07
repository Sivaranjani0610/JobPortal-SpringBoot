package job.portal.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class FileDAO {

    private final JdbcTemplate jdbcTemplate;
//file dao
    @Autowired
    public FileDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public byte[] getFileContentById(int fileId) {
        String sql = "SELECT file_data FROM fileupload WHERE file_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{fileId}, (resultSet, i) -> {
            try {
                return resultSet.getBytes("file_data");
            } catch (SQLException e) {
                throw new RuntimeException("Failed to fetch file content from database.", e);
            }
        });
    }
    
    public String getOriginalFileName(int fileId) {
        String sql = "SELECT file_name FROM fileupload WHERE file_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{fileId}, String.class);
    }
	
}
