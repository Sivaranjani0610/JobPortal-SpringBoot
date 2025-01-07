package job.portal.service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {

    private JavaMailSender javaMailSender;

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendRegistrationEmail(String to, String firstname) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Welcome to Our Application!");
        message.setText("Hello " + firstname + ",\n\nThank you for registering with us.\n\nIn case, You need to update your details... please follow the below link. \n http://localhost:8080/jobportalmain/edituser/"+firstname+"\nRegards,\nThe Team");
        javaMailSender.send(message);
    }
}
