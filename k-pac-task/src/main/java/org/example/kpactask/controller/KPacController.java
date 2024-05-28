package org.example.kpactask.controller;

import lombok.RequiredArgsConstructor;
import org.example.kpactask.dao.jdbc.JdbcKPacDao;
import org.example.kpactask.dao.jdbc.JdbcKPacKPacSetDao;
import org.example.kpactask.dao.jdbc.JdbcKPacSetDao;
import org.example.kpactask.entity.KPac;
import org.example.kpactask.entity.KPacKPacSet;
import org.example.kpactask.entity.KPacSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/kpacs")
@RequiredArgsConstructor
public class KPacController {

    private final JdbcKPacDao jdbcKPacDao;
    private final JdbcKPacSetDao jdbcKPacSetDao;
    private final JdbcKPacKPacSetDao jdbcKPacKPacSetDao;

    @GetMapping
    public ModelAndView kpacs(ModelAndView modelAndView) {
        List<KPac> kpacs =  jdbcKPacDao.getAll();
        modelAndView.addObject("kpacs", kpacs);
        modelAndView.setViewName("/WEB-INF/static/kpacs.jsp");
//        modelAndView.setViewName("/static/kpacs_dhtmlx.html");
        return modelAndView;
    }

    @GetMapping("/newKPac")
    public ModelAndView newKPac(ModelAndView modelAndView) {
        KPac kPac = new KPac();
        modelAndView.addObject("kPac", kPac);
        modelAndView.setViewName("/WEB-INF/static/addKPac.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/addKPac", method = RequestMethod.POST)
    public ModelAndView addKPac(@ModelAttribute KPac kPac) {
        if(kPac.getKPacSetId() != null) {
            KPacSet kPacSet = jdbcKPacSetDao.getById(kPac.getKPacSetId());
            jdbcKPacDao.add(kPac);
            if (kPacSet != null) jdbcKPacKPacSetDao.addKPacKPacSet(new KPacKPacSet(kPac.getKPacId(), kPacSet.getKPacSetId()));
        } else  {
            jdbcKPacDao.add(kPac);
        }
        return new ModelAndView("redirect:/kpacs");
    }

    @GetMapping("deleteKPac/{id}")
    public ModelAndView deleteKPac(@PathVariable Long id) {
        List<KPacKPacSet> kPacKPacSets = jdbcKPacKPacSetDao.getAll();
        List<Long> kPacSetIds = kPacKPacSets.stream().filter(kPacKPacSet -> kPacKPacSet.getKPacId().equals(id)).map(KPacKPacSet::getKPacSetId).toList();
        kPacSetIds.forEach(kPacSetId -> jdbcKPacKPacSetDao.deleteKPacKPacSet(id, kPacSetId));
        jdbcKPacDao.deleteById(id);
        return new ModelAndView("redirect:/kpacs");
    }

}
