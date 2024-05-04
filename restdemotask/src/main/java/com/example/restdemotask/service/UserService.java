package com.example.restdemotask.service;

import com.example.restdemotask.entity.Users;
import com.example.restdemotask.exception.AgeValidationException;
import com.example.restdemotask.exception.DateRangeValidationException;
import com.example.restdemotask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService  {


    @Value("${validation.age}")
    private int age;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Users save(Users user) {
        if (LocalDate.now().minusYears(age).isAfter(user.getBirthDate())) {
            return userRepository.save(user);
        } else {
            throw new AgeValidationException();
        }
    }


    public Users getById(Long id) {
        return userRepository.getById(id);
    }


    public List<Users> getAll() {
        return userRepository.getAll();
    }

    public List<Users> getAllByBirthDateRange(String from, String to) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        List<Users> users = new ArrayList<>();

        if(from == null && to == null) users = userRepository.getAll();

        if (from != null && to == null)
            users = userRepository.getAll().stream().filter(u -> u.getBirthDate().isAfter(LocalDate.parse(from, formatter))).collect(Collectors.toList());

        if (to != null && from == null)
            users = userRepository.getAll().stream().filter(u -> u.getBirthDate().isBefore(LocalDate.parse(to, formatter))).collect(Collectors.toList());

        if (from != null && to != null) {
            LocalDate dateFrom = LocalDate.parse(from, formatter);
            LocalDate dateTo = LocalDate.parse(to, formatter);
            if (dateFrom.isAfter(dateTo)) throw new DateRangeValidationException();
            users = userRepository.getAll().stream().filter(u -> u.getBirthDate().isAfter(dateFrom) && u.getBirthDate().isBefore(dateTo)).collect(Collectors.toList());
        }
        return users;
    }


    public Users update(Users user) {
        return userRepository.update(user);
    }

    public Users updatePatch(Users user, Long id) {
        Users result = null;
        Users userMemory = getById(id);
        if (userMemory != null) {
            userMemory.setFirstName(user.getFirstName() != null ? user.getFirstName() : userMemory.getFirstName());
            userMemory.setLastName(user.getLastName() != null ? user.getLastName() : userMemory.getLastName());
            userMemory.setEmail(user.getEmail() != null ? user.getEmail() : userMemory.getEmail());
            userMemory.setBirthDate(user.getBirthDate() != null ? user.getBirthDate() : userMemory.getBirthDate());
            userMemory.setAddress(user.getAddress() != null ? user.getAddress() : userMemory.getAddress());
            userMemory.setPhone(user.getPhone() != null ? user.getPhone() : userMemory.getPhone());
            result = update(userMemory);
        }
        return result;
    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
