package org.example.webservice.user;

import jakarta.jws.WebService;
import org.example.dao.UserDao;
import org.example.entity.User;

import java.util.List;
@WebService(endpointInterface = "org.example.webservice.user.UserWebService")
public class UserWebServiceImpl implements UserWebService {

    private UserDao userDao = new UserDao();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
