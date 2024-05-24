package org.example.kpactask.controller;

import lombok.RequiredArgsConstructor;
import org.example.kpactask.dao.jdbc.JdbcKPacDao;
import org.example.kpactask.entity.KPac;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final JdbcKPacDao jdbcKPacDao;

    @GetMapping
    public ModelAndView home(ModelAndView modelAndView) {
        List<KPac> kpacs =  jdbcKPacDao.getAll();
        modelAndView.addObject("kpacs", kpacs);
        modelAndView.setViewName("/WEB-INF/static/index.jsp");
        return modelAndView;
    }
}
