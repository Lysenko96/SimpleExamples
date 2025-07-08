package com.lysenko.shoppingcart.service.impl;

import com.lysenko.shoppingcart.service.CommonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@Service
public class CommonServiceImpl implements CommonService {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    @Override
    public void removeSessionMessage() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute(SUCCESS);
        session.removeAttribute(ERROR);
    }
}
