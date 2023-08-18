package info.gweep.mvc5.controller;

import info.gweep.mvc5.entity.Singer;
import info.gweep.mvc5.service.SingerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/singers")
public class SingerController {

    private SingerServiceImpl singerServiceImpl;

    public SingerController(SingerServiceImpl singerServiceImpl) {
        this.singerServiceImpl = singerServiceImpl;
    }

    @GetMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        List<Singer> singers = singerServiceImpl.findAll();
        System.out.println(singers);
        modelAndView.addObject("singers", singers);
        modelAndView.setViewName("/singers/list");
        return modelAndView;
    }
}
