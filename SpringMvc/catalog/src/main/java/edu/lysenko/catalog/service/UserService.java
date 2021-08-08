package edu.lysenko.catalog.service;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.lysenko.catalog.config.Config;
import edu.lysenko.catalog.controller.AppController;
import edu.lysenko.catalog.dao.UserDao;
import edu.lysenko.catalog.dao.jdbc.JdbcUserDao;
import edu.lysenko.catalog.dao.jdbc.mapper.UserMapper;
import edu.lysenko.catalog.entity.User;

public class UserService {


}
