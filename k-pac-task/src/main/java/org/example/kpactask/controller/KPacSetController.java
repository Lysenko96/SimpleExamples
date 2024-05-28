package org.example.kpactask.controller;

import lombok.RequiredArgsConstructor;
import org.example.kpactask.dao.jdbc.JdbcKPacDao;
import org.example.kpactask.dao.jdbc.JdbcKPacKPacSetDao;
import org.example.kpactask.dao.jdbc.JdbcKPacSetDao;
import org.example.kpactask.entity.KPac;
import org.example.kpactask.entity.KPacKPacSet;
import org.example.kpactask.entity.KPacKPacSetDto;
import org.example.kpactask.entity.KPacSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class KPacSetController {

    private final JdbcKPacDao jdbcKPacDao;
    private final JdbcKPacSetDao jdbcKPacSetDao;
    private final JdbcKPacKPacSetDao jdbcKPacKPacSetDao;

    @RequestMapping(value = "/sets", method = RequestMethod.GET)
    public ModelAndView sets(ModelAndView modelAndView) {
        List<KPacKPacSet> kPacKPacSets = jdbcKPacKPacSetDao.getAll();
        List<KPacSet> kPacSets = jdbcKPacSetDao.getAll();
        List<KPac> kPacs = jdbcKPacDao.getAll();
        List<Long> kPacIdByKPacSet = new ArrayList<>();
//        List<Long> kPacSetIds = new ArrayList<>();
        for(KPacKPacSet kPacKPacSet : kPacKPacSets) {
            Long kPacId = kPacKPacSet.getKPacId();
//            Long kPacSetId = kPacKPacSet.getKPacSetId();
            kPacIdByKPacSet.add(kPacId);
//            kPacSetIds.add(kPacSetId);
        }
//        modelAndView.addObject("kPacSets", kPacSets.stream().filter(kPacSet -> kPacSetIds.contains(kPacSet.getKPacSetId())).collect(Collectors.toList()));
        modelAndView.addObject("kPacSets", kPacSets);
        modelAndView.addObject("FreeKPacs", kPacs.stream().filter(kPac -> !kPacIdByKPacSet.contains(kPac.getKPacId())).collect(Collectors.toList()));
        modelAndView.setViewName("/WEB-INF/static/sets.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "sets/newKPacSet", method = RequestMethod.GET)
    public ModelAndView newKPac(ModelAndView modelAndView) {
        KPacSet kPacSet = new KPacSet();
        modelAndView.addObject("kPacSet", kPacSet);
        modelAndView.setViewName("/WEB-INF/static/addKPacSet.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "sets/addKPacSet", method = RequestMethod.POST)
    public ModelAndView addKPac(@ModelAttribute KPacSet kPacSet) {
        jdbcKPacSetDao.add(kPacSet);
        if(kPacSet.getKPacId() != null) {
            KPac kPac = jdbcKPacDao.getById(kPacSet.getKPacId());
            if (kPac != null) jdbcKPacKPacSetDao.addKPacKPacSet(new KPacKPacSet(kPac.getKPacId(), kPacSet.getKPacSetId()));
        }
        return new ModelAndView("redirect:/sets");
    }


    @RequestMapping(value = "/set/{id}", method = RequestMethod.GET)
    public ModelAndView sets(@ModelAttribute KPacSet kPacSet, @PathVariable Long id, ModelAndView modelAndView) {
        List<KPacKPacSet> kPacKPacSets = jdbcKPacKPacSetDao.getAll();
        List<KPac> kPacs = jdbcKPacDao.getAll();
        List<KPacSet> kPacSets = jdbcKPacSetDao.getAll();
        List<KPacKPacSetDto> kPacKPacSetDtos = new ArrayList<>();
        for(KPacKPacSet kPacKPacSet :kPacKPacSets) {
            Long kPacId = kPacKPacSet.getKPacId();
            Long kPacSetId = kPacKPacSet.getKPacSetId();
            kPacKPacSetDtos.add(new KPacKPacSetDto(kPacId, kPacs.get(Math.toIntExact(kPacId)-1), kPacSets.get(Math.toIntExact(kPacSetId)-1), kPacSetId));
        }
        modelAndView.addObject("kPacKPacSetDto", kPacKPacSetDtos.stream().filter(kPacKPacSetDto -> kPacKPacSetDto.getKPacSetId().equals(id)).collect(Collectors.toList()));
        modelAndView.setViewName("/WEB-INF/static/set.jsp");
        return modelAndView;
    }

    @GetMapping("/sets/deleteKPacSet/{id}")
    public ModelAndView deleteKPac(@PathVariable Long id) {
        List<KPacKPacSet> kPacKPacSets = jdbcKPacKPacSetDao.getAll();
        List<Long> kPacIds = kPacKPacSets.stream().filter(kPacKPacSet -> kPacKPacSet.getKPacSetId().equals(id)).map(KPacKPacSet::getKPacId).toList();
        kPacIds.forEach(kPacId -> jdbcKPacKPacSetDao.deleteKPacKPacSet(kPacId, id));
        jdbcKPacSetDao.deleteById(id);
        return new ModelAndView("redirect:/sets");
    }

}
