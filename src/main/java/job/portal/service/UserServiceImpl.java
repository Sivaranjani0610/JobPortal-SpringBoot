package job.portal.service;

import org.springframework.beans.factory.annotation.Autowired;

import job.portal.dao.UserDao;
import job.portal.model.Login;
import job.portal.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
