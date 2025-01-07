package job.portal.service;


import job.portal.model.Login;
import job.portal.model.User;

public interface UserService {

  int register(User user);

  User validateUser(Login login);
}
