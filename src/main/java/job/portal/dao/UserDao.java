package job.portal.dao;


import job.portal.model.Login;
import job.portal.model.User;


public interface UserDao {

  int register(User user);

  User validateUser(Login login);
}
