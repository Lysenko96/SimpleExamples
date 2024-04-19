package org.example.webservice.user;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.example.entity.User;

import java.util.List;

@WebService
public interface UserWebService {

    @WebMethod
    List<User> findAll();
}
