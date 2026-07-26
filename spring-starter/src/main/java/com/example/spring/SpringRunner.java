package com.example.spring;

import com.example.spring.dto.UserDto;
import com.example.spring.ioc.Container;
import com.example.spring.mapper.UserMapper;
import com.example.spring.repository.UserRepository;
import com.example.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {
//        var userRepository = new UserRepository();
//        var userDto = new UserDto();
//        var userMapper = new UserMapper(userDto);
//        var userService = new UserService(userMapper, userRepository);
//        var container = new Container();
//        var userService = container.get(UserService.class);
        var xmlContext = new ClassPathXmlApplicationContext("application.xml");
        var userRepository1 = xmlContext.getBean("repo1", UserRepository.class);
        var userRepository2 = xmlContext.getBean("repo2", UserRepository.class);
        System.out.println(userRepository1);
        System.out.println(userRepository2);
        var userDto = xmlContext.getBean("dto", UserDto.class);
        var userDto1 = xmlContext.getBean("dto", UserDto.class);
        var userDto2 = xmlContext.getBean("dto1", UserDto.class);
        var ctx = new AnnotationConfigApplicationContext("com.example.spring");
//        var userDto = ctx.getBean("userDto", UserDto.class);
//        var userDto1 = ctx.getBean("userDto", UserDto.class);
        System.out.println(userDto);
        System.out.println(userDto1);
        System.out.println(userDto2);
//        var userMapper = xmlContext.getBean(UserMapper.class);
//        System.out.println(userMapper);
        xmlContext.close();

    }

}
