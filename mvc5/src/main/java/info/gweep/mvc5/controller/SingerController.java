package info.gweep.mvc5.controller;

import info.gweep.mvc5.entity.Singer;
import info.gweep.mvc5.service.SingerService;
import info.gweep.mvc5.service.SingerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/singer")
public class SingerController {

    private SingerServiceImpl singerServiceImpl;

    public SingerController(SingerServiceImpl singerServiceImpl) {
        this.singerServiceImpl = singerServiceImpl;
    }

    @GetMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        List<Singer> singers = singerServiceImpl.findAll();
        modelAndView.addObject("singers", singers);
        modelAndView.setViewName("/singer/list");
        return modelAndView;
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findSingerById(@PathVariable Long id, ModelAndView modelAndView){
         Singer singer = singerServiceImpl.findById(id);
         modelAndView.addObject("singer", singer);
         modelAndView.setViewName("/singer/findById");
         return modelAndView;
    }

    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthDate, ModelAndView modelAndView){
        Singer singer = singerServiceImpl.save(firstName, lastName, birthDate);
        modelAndView.addObject("singer", singer);
        modelAndView.setViewName("/singer/create");
        return modelAndView;
    }

    @RequestMapping(value ="/updateById/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public ModelAndView updateSingerById(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthDate, ModelAndView modelAndView){
        Singer singer = singerServiceImpl.update(id, firstName, lastName, birthDate);
        modelAndView.addObject("singer", singer);
        modelAndView.setViewName("/singer/updateById");
        return modelAndView;
    }


}
