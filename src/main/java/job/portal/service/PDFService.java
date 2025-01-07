package job.portal.service;

import java.io.IOException;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import job.portal.model.PDFFile;


public class PDFService {
	
	Connection con = null;
	 @Autowired
	  DataSource datasource;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private PDFFile pdffile;

    public int storePDF(int id,CommonsMultipartFile file) throws IOException {
        String sql = "INSERT INTO fileupload (file_id,file_name,file_data) VALUES (?,?,?)";
        
        return jdbcTemplate.update(sql,id,file.getOriginalFilename(),file.getBytes());
    }
}
