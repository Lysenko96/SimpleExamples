package org.web.ecom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.ecom.model.Address;
import org.web.ecom.model.User;
import org.web.ecom.repository.AddressRepository;
import org.web.ecom.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> fetchUser(Long id) {
        return userRepository.findById(id);
    }

//    @Transactional(rollbackFor = Exception.class)
    public User addUser(User user) {
        return userRepository.save(user);
    }


    // SAVE ADDRESS FROM OTHER USER TO USER FROM DB
    // GET USER FROM DB
    // GET ADDRESS FROM DB BY USER FROM DB
    // SET ADDRESS FROM OTHER USER TO ADDRESS FROM DB
    // SET ADDRESS FROM DB TO USER FROM DB
    public boolean updateUser(Long id, User user) {
        User getUser = userRepository.getReferenceById(id);
        Address getAddress = addressRepository.getReferenceById(getUser.getAddress().getId());
        getAddress.setCity(user.getAddress().getCity());
        getUser.setAddress(getAddress);
        User saveUser = userRepository.save(getUser);
        return true;
    }

    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return userRepository.findById(id).isEmpty();
    }
}
