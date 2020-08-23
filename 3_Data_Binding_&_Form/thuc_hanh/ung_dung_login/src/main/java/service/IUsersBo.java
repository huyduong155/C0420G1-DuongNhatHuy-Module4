package service;

import model.Login;
import model.Users;

public interface IUsersBo {
    public Users checkLogin(Login login);
}
