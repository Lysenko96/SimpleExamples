package org.example.kpactask.controller;

import org.example.kpactask.entity.KPac;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/kpacs")
public class KPacController {

    @GetMapping
    public ModelAndView addKPac(ModelAndView modelAndView) {
        modelAndView.addObject("kpac", new KPac());
        modelAndView.setViewName("kpacs");
        return modelAndView;
    }

}
