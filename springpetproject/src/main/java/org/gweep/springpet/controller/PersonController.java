package org.gweep.springpet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    @RequestMapping("/person")
    public String goPerson(){
        return "person";
    }
}
