package info.gweep.cookiefilter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        Cookie[] cookies = httpServletRequest.getCookies();
        boolean isAuth = false;
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) isAuth = true;
            }
        }
        if(isAuth){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.sendRedirect("index");
        }
    }
}
