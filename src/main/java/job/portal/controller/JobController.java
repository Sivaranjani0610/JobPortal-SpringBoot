package job.portal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.protobuf.Message;

import job.portal.dao.FileDAO;
import job.portal.dao.JobDao;
import job.portal.service.PDFService;

import job.portal.model.JobUser;
import job.portal.model.PDFFile;





@Controller
public class JobController {
 

	@Autowired
	private JobDao dao;
	
	@Autowired
	private PDFService pdfService;
   
	
	private final FileDAO fileDAO;

    @Autowired
    public JobController(FileDAO fileDAO) {
        this.fileDAO = fileDAO;
    }

    @GetMapping("/downloadFile/{fileId}")
    @ResponseBody
    public ResponseEntity<byte[]> downloadFile(@PathVariable int fileId) {
        byte[] fileContent = fileDAO.getFileContentById(fileId);
        String originalFileName = fileDAO.getOriginalFileName(fileId);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "filename=" + originalFileName); // Change the filename and extension as needed

        return new ResponseEntity<>(fileContent, headers, org.springframework.http.HttpStatus.OK);
    }

	
	
  @RequestMapping(value="/")
	public ModelAndView finalform(HttpServletResponse response) throws IOException{
	return new ModelAndView("index");
  }
  
	@RequestMapping("/userdetails")
	public String showForm(Model m) {
		m.addAttribute("command", new JobUser());
		return "userdetails";
  }
		
	 /*@GetMapping("/logout")
	    public String logout(HttpServletRequest request, HttpServletResponse response) {
	        // Invalidate session
	        request.getSession().invalidate();
	        // Redirect to login page
	        return "redirect:/index";
	    }*/
	
	@RequestMapping(value="/cvfileupload")
	public ModelAndView usreee(HttpServletResponse response) throws IOException{
	return new ModelAndView("cvfileupload");
	}
	
	@RequestMapping(value="/adminmessage")
	public ModelAndView adminmessage(HttpServletResponse response) throws IOException{
	return new ModelAndView("adminmessage");
	}
	
	@RequestMapping(value="/adminlogin")
	public ModelAndView admin(HttpServletResponse response) throws IOException{
	return new ModelAndView("adminlogin");
	}
	
	@RequestMapping(value="/editprofile")
	public ModelAndView profileedit(HttpServletResponse response) throws IOException{
	return new ModelAndView("editprofile");
	}
	
	
	
	@RequestMapping(value="/viewuserinfo")
	public ModelAndView adminn(HttpServletResponse response) throws IOException{
	return new ModelAndView("viewuserinfo");
	}
	
	@RequestMapping(value="/downloadFile")
	public ModelAndView down(HttpServletResponse response) throws IOException{
	return new ModelAndView("downloadFile");
	}
	
	@RequestMapping(value="/index")
	public ModelAndView login(HttpServletResponse response) throws IOException{
	return new ModelAndView("index");
	}
  
	@RequestMapping(value="/applsubmit")
	public ModelAndView applicationsubmit(HttpServletResponse response) throws IOException{
	return new ModelAndView("applsubmit");
	}
	
	
	@RequestMapping(value="/error")
	public ModelAndView errormsg(HttpServletResponse response) throws IOException{
	return new ModelAndView("applsubmit");
	}
	
	@RequestMapping(value="/welcome")
	public ModelAndView applicationsuccess(HttpServletResponse response) throws IOException{
	return new ModelAndView("welcome");
	}
	
	@RequestMapping(value="/successedit")
	public ModelAndView editpagesuccess(HttpServletResponse response) throws IOException{
	return new ModelAndView("successedit");
	}
	
	@RequestMapping(value="/edituserdetailss")
	public ModelAndView succedit(HttpServletResponse response) throws IOException{
	return new ModelAndView("edituserdetailss");
	}
	
  @RequestMapping(value = "/addnewstud", method = RequestMethod.POST)
	public String addnewstud(@ModelAttribute("prod") JobUser prod) throws IOException {
		
		 
			 dao.addnewstud(prod);
	         String surname=prod.getSurname();
	         String firstname=prod.getFirstname();
	          return "redirect:/cvsuccess/"+surname + "/" +firstname; // Redirect to a success page
	     
		
	}
  
  
  @RequestMapping(value = "/cvsuccess/{surname}/{firstname}")
	public String cvsurname(@PathVariable String surname,@PathVariable String firstname, Model m) {
		
	  m.addAttribute("surname", surname);
	  m.addAttribute("firstname", firstname);
		return "cvfileupload";
	}
    
  @RequestMapping("/viewsusers")
	public String viewstud(Model m) {
		List<JobUser> list = dao.getAllStudents();
		m.addAttribute("list", list);
		return "viewuserinfo";
	}
	

	@RequestMapping(value = "/edituser/{firstname}")
	public String editstud(@PathVariable String firstname, Model m) {
		JobUser stud = dao.getUserByFirstnamepassword(firstname);
		m.addAttribute("command", stud);
		return "studenteditform";
	}
	
	@RequestMapping(value = "/usereditsubmit/{firstname}", method = RequestMethod.POST)
	public String editstudsubmit(@PathVariable String firstname,@ModelAttribute("stud") JobUser stud) {
		
		dao.newstudupdate(stud);
		return "redirect:/successedit";
	}
  
  
  @RequestMapping(value = "/uploadPDF/{surname}/{firstname}", method = RequestMethod.POST)
	public String edit(@RequestParam("file") CommonsMultipartFile file,@PathVariable String surname,@PathVariable String firstname, Model model) throws IOException {
	  try {
		  
 int id = dao.studentgetid(surname,firstname);
	     
 pdfService.storePDF(id,file);
          
         
          
         
          
          
	  }
	  catch(EmptyResultDataAccessException ex) {
		  model.addAttribute("errorMessage", "Firstname or Surname is wrong " + ex.getMessage());
          return "error";
      }
	  
	  return "redirect:/applsubmit";
	      
	}
 
  @RequestMapping(value = "/editprofinportal", method = RequestMethod.POST)
 	public String editprofile(@RequestParam("firstname") String firstname,@RequestParam("password") String password,Model model) throws IOException {
 	  try {
 		  dao.passsword(firstname, password);
 		  
 	     
     
           
          
           
          
           
           
 	  }
 	  catch(EmptyResultDataAccessException ex) {
 		  model.addAttribute("errorMessage", "Firstname or Password is wrong " + ex.getMessage());
           return "error";
       }
 	  
 	  return "redirect:/edituser/"+firstname;
 	      
 	}
  
  @RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String adminlogin(@RequestParam("username") String username,@RequestParam("password") String password,Model model) throws IOException {
	  try {
		  dao.loginadminn(username, password);
		  
	     
   
         
        
         
        
         
         
	  }
	  catch(EmptyResultDataAccessException ex) {
		  model.addAttribute("errorMessage", "Firstname or Password is wrong " + ex.getMessage());
         return "adminmessage";
     }
	  
	  return "admin";
	      
	}
 
  }
	
	
	
	
	
