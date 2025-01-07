package job.portal.model;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class JobUser {
	private int profileid;
	private String title;
	private String firstname;
	private String surname;
	private String gender;
	private String phoneno;
	private String dateofbirth;
	private String maritalstatus;
	private String visastatus;
	private String jobrole;
	public String getJobrole() {
		return jobrole;
	}



	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}



	public int getItexperience() {
		return itexperience;
	}



	public void setItexperience(int itexperience) {
		this.itexperience = itexperience;
	}



	private int itexperience;
	private String address;
	
	
	
	
	



	


	public JobUser() {
		super();
		// TODO Auto-generated constructor stub
	}



	public JobUser(int profileid, String title, String firstname, String surname, String gender, String phoneno,
			String dateofbirth, String maritalstatus, String visastatus, String address, String jobrole, int itexperience) {
		super();
		this.profileid = profileid;
		this.title = title;
		this.firstname = firstname;
		this.surname = surname;
		this.gender = gender;
		this.phoneno = phoneno;
		this.dateofbirth = dateofbirth;
		this.maritalstatus = maritalstatus;
		this.visastatus = visastatus;
		this.address = address;
		
		this.jobrole = jobrole;
		this.itexperience = itexperience;
	}

	

	public int getProfileid() {
		return profileid;
	}



	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getPhoneno() {
		return phoneno;
	}



	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}



	public String getDateofbirth() {
		return dateofbirth;
	}



	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}



	public String getMaritalstatus() {
		return maritalstatus;
	}



	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}



	public String getVisastatus() {
		return visastatus;
	}



	public void setVisastatus(String visastatus) {
		this.visastatus = visastatus;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	
	
	
}

