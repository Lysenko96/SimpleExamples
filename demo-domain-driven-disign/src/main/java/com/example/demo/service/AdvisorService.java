package com.example.demo.service;

import com.example.demo.domain.Advisor;
import com.example.demo.domain.Application;
import com.example.demo.repository.AdvisorRepository;
import com.example.demo.repository.ApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdvisorService {

    private final AdvisorRepository advisorRepository;
    private final ApplicationRepository applicationRepository;

    public AdvisorService(AdvisorRepository advisorRepository, ApplicationRepository applicationRepository) {
        this.advisorRepository = advisorRepository;
        this.applicationRepository = applicationRepository ;
    }

    @Transactional
    public Application assignNewApplicationByAdvisorId(Long advisorId) {
        Advisor advisor = advisorRepository.findById(advisorId).orElseThrow();
        Application application = applicationRepository.findFirstByStatusOrderByCreatedAt(Application.Status.NEW);
        advisor.assignApplication(application);
        return application;
    }


}
