package org.example.mvcappboot;

import lombok.extern.slf4j.Slf4j;
import org.example.mvcappboot.service.NasaClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableCaching
@EnableScheduling
@Slf4j
@SpringBootApplication
public class MvcAppBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MvcAppBootApplication.class, args);
//        NasaClientService nasaClientService = context.getBean("nasaClientService",NasaClientService.class);
//        System.out.println(nasaClientService.getLargestPicture());
        //context.close();
    }

//    @Scheduled(fixedDelay = 10000)
//    @CacheEvict("largePicture")
//    public void refreshCache(){
//      log.info("Refresh largest picture cache...");
//    }

}
