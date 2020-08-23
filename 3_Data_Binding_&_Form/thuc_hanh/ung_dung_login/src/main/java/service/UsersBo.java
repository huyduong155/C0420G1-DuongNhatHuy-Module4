package service;

import model.Login;
import model.Users;
import repository.IUsersDao;
import repository.UsersDao;

public class UsersBo implements IUsersBo {
    IUsersDao iUsersDao = new UsersDao();
    @Override
    public Users checkLogin(Login login) {
        return iUsersDao.checkLogin(login);
    }
}
