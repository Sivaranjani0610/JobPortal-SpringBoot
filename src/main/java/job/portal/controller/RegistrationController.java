package job.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import job.portal.model.User;
import job.portal.service.EmailService;
import job.portal.service.UserService;

@Controller
public class RegistrationController {
	
	private EmailService emailService;
	 public void setEmailService(EmailService emailService) {
	        this.emailService = emailService;
	    }
	
  @Autowired
  public UserService userService;

  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {

      StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

      dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }
  
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());

    return mav;
  }

  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public String addUser( @Valid @ModelAttribute("user") User user, BindingResult theBindingResult, Model model ) {
	 try {
	  if (theBindingResult.hasErrors()) {
		  return ("register");
      }
	 
	  else {
          
    userService.register(user);
    model.addAttribute("firstname", user.getFirstname());
    String email=user.getEmail();
    String firstname=user.getFirstname();
    emailService.sendRegistrationEmail(email, firstname);
    
    return ("welcome");
	  }
  }
	 catch(DuplicateKeyException ex) {
		 
         return "duplicate";
     }
  }
}
