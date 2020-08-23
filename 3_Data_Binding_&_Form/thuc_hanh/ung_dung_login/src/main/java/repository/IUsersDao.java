package repository;

import model.Login;
import model.Users;

public interface IUsersDao {
    public Users checkLogin(Login login);
}
