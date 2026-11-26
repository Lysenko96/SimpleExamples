package org.web.ecom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.ecom.dto.UserRequest;
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
    public User addUser(UserRequest userRequest) {
        return userRepository.save(mapToUser(User.builder().build(), userRequest));
    }


    // SAVE ADDRESS FROM OTHER USER TO USER FROM DB
    // GET USER FROM DB
    // GET ADDRESS FROM DB BY USER FROM DB
    // SET ADDRESS FROM OTHER USER TO ADDRESS FROM DB
    // SET ADDRESS FROM DB TO USER FROM DB
    // Address getAddress = addressRepository.findById(getUser.getAddress().getId()).orElse(null);
    // getAddress.setCity(user.getAddress().getCity());
    // getUser.setAddress(getAddress);

    // OR JUST GET ADDRESS FILED(CITY, example) FROM USER DB AND GET ADDRESS FILED(CITY) FROM OTHER USER
    // getUser.getAddress().setCity(user.getAddress().getCity());
    public boolean updateUser(Long id, UserRequest userRequest) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser = mapToUser(existingUser, userRequest);
            Address exsitingAddress = addressRepository.findByUserId(existingUser.getId());
            if (exsitingAddress != null) {
                existingUser.getAddress().setId(existingUser.getAddress().getId() == null ? exsitingAddress.getId() : existingUser.getAddress().getId());
                existingUser.getAddress().setStreet(existingUser.getAddress().getStreet() == null ? exsitingAddress.getStreet() : existingUser.getAddress().getStreet());
                existingUser.getAddress().setCity(existingUser.getAddress().getCity() == null ? exsitingAddress.getCity() : existingUser.getAddress().getCity());
                existingUser.getAddress().setState(existingUser.getAddress().getState() == null ? exsitingAddress.getState() : existingUser.getAddress().getState());
                existingUser.getAddress().setCountry(existingUser.getAddress().getCountry() == null ? exsitingAddress.getCountry() : existingUser.getAddress().getCountry());
                existingUser.getAddress().setZipcode(existingUser.getAddress().getZipcode() == null ? exsitingAddress.getZipcode() : existingUser.getAddress().getZipcode());
            }
            userRepository.save(existingUser);
            return true;
        }).orElse(false);
    }

    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return userRepository.findById(id).isEmpty();
    }

    public User mapToUser(User user, UserRequest userRequest) {
        return user.toBuilder()
                .firstName(userRequest.getFirstName() != null ? userRequest.getFirstName() : user.getFirstName())
                .lastName(userRequest.getLastName() != null ? userRequest.getLastName() : user.getLastName())
                .email(userRequest.getEmail() != null ? userRequest.getEmail() : user.getEmail())
                .phone(userRequest.getPhone() != null ? userRequest.getPhone() : user.getPhone())
                .address(userRequest.getAddress() != null ? Address.builder()
                        .city(userRequest.getAddress().getCity())
                        .country(userRequest.getAddress().getCountry())
                        .state(userRequest.getAddress().getState())
                        .street(userRequest.getAddress().getStreet())
                        .zipcode(userRequest.getAddress().getZipcode())
                        .build() : null)
                .build();
    }
}
