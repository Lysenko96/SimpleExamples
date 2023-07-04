package org.example.jparelations.service;


import org.example.jparelations.entity.Husband;
import org.example.jparelations.entity.Wife;
import org.example.jparelations.repository.HusbandRepository;
import org.example.jparelations.repository.WifeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private HusbandRepository husbandRepository;
    private WifeRepository wifeRepository;

    public PersonService(WifeRepository wifeRepository, HusbandRepository husbandRepository) {
        this.husbandRepository = husbandRepository;
        this.wifeRepository = wifeRepository;
    }

    public void saveWife(Wife wife){
        wifeRepository.save(wife);
    }
    public void saveHusband (Husband husband){
        husbandRepository.save(husband);
    }

    public Wife findWifeById(long id){
        return wifeRepository.findById(id).orElse(null);
    }

    public Husband getHusbandById(long id){
        return husbandRepository.findById(id).orElse(null);
    }

    public void deleteHusbandById(long id) {
        husbandRepository.deleteById(id);
    }

    public void deleteWifeById(long id){
        wifeRepository.deleteById(id);
    }

}
