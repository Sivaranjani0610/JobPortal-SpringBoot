package job.portal.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import job.portal.model.JobUser;

import job.portal.model.User;

public class JobDao {
	
	Connection con = null;
	 @Autowired
	  DataSource datasource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	 
	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	public int addnewstud(JobUser use) throws IOException {
		String sql = "insert into users(title,firstname,surname,gender,phoneno,dateofbirth,maritalstatus,visastatus,jobrole,itexperience,address) values('" + use.getTitle() + "','" + use.getFirstname() + "','" + use.getSurname() + "','" + use.getGender() + "','" + use.getPhoneno() + "','" + use.getDateofbirth() + "','" + use.getMaritalstatus() + "','" + use.getVisastatus() + "','" + use.getJobrole() + "','" + use.getItexperience() + "','" + use.getAddress() + "')";
		return jdbcTemplate.update(sql);
	}
	
	public int newstudupdate(JobUser stu) {
		String sql = "Update users set title='" + stu.getTitle() + "',firstname='" + stu.getFirstname() + "',surname='" + stu.getSurname()
				+ "',gender='" + stu.getGender() + "',phoneno='" + stu.getPhoneno() + "',dateofbirth='" + stu.getDateofbirth() + "',maritalstatus='" + stu.getMaritalstatus() + "',visastatus='" + stu.getVisastatus() + "',address='" + stu.getAddress() + "' where firstname='" + stu.getFirstname() + "'";
		return jdbcTemplate.update(sql);
	}

	
	public int deletestudent(int profileid) {
		String sql = "delete from users where profileid=" + profileid;
		return jdbcTemplate.update(sql);
	}
	
	public int studentgetid(String surname, String firstname) {
		String sql = "select profileid from users where firstname='" + firstname + "' and surname='" + surname + "'";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public String userfirstname(String firstname) {
		String sql = "select firstname from auth where firstname='" + firstname + "'";
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	
	public String username(String firstname) {
		String sql = "select firstname from users where firstname='" + firstname + "'";
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	public String passsword(String firstname,String password) {
		String sql = "select firstname from auth where firstname='" + firstname + "' and password='" + password + "'";
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	
	public String loginadminn(String username,String password) {
		String sql = "select username from admin where username='" + username + "' and password='" + password + "'";
		return jdbcTemplate.queryForObject(sql, String.class);
	}
	
	public JobUser getUserByFirstnamepassword(String firstname) {
		String sql = "select firstname from users where firstname=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { firstname}, new BeanPropertyRowMapper<JobUser>(JobUser.class));
	}
	
	public int getUserByfirstname(String firstname) {
		String sql = "select id from users where firstname=?";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public JobUser getStudentById(int profileid) {
		String sql = "select * from users where profileid=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { profileid }, new BeanPropertyRowMapper<JobUser>(JobUser.class));
	}

	public List<JobUser> getAllStudents() {
		return jdbcTemplate.query("select * from users", new RowMapper<JobUser>() {
			public JobUser mapRow(ResultSet rs, int row) throws SQLException {
				JobUser prod = new JobUser();
				prod.setProfileid(rs.getInt(1));
				prod.setTitle(rs.getString(2));
				prod.setFirstname(rs.getString(3));
				prod.setSurname(rs.getString(4));
				prod.setGender(rs.getString(5));
				prod.setPhoneno(rs.getString(6));
				prod.setDateofbirth(rs.getString(7));
				prod.setMaritalstatus(rs.getString(8));
				prod.setVisastatus(rs.getString(9));
				prod.setJobrole(rs.getString(10));
				prod.setItexperience(rs.getInt(11));
				prod.setAddress(rs.getString(12));

				return prod;
			}
		});
	}
	

}