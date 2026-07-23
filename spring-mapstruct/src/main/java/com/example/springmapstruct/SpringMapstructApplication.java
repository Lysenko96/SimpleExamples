package com.example.springmapstruct;

import com.example.springmapstruct.repository.UserAppRepository;
import com.example.springmapstruct.service.UserAppService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMapstructApplication {

    @Resource
    private UserAppService userAppService;
    @Resource
    private UserAppRepository userAppRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMapstructApplication.class, args);
	}

    @PostConstruct
    public void init() {
        userAppService.addDb();
        System.out.println(userAppRepository.findAll());
    }

}
