package services;

import exceptions.UserDoesNotExistException;
import models.User;
import repository.UserRepository;

import static utils.utility.generateNextId;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    // validation of input like mobile number and email Id
    public User registerUser(String name, String email, String mobileNumber, String address, String password) {
        User user = User.builder()
                .userId(generateNextId())
                .name(name)
                .mobileNumber(mobileNumber)
                .emailId(email)
                .password(password)
                .address(address)
                .build();
        userRepository.createUser(user);
        return user;
    }

    public boolean loginUser(String name, String password) throws UserDoesNotExistException {
        return userRepository.getUserByUserNameAndUserPassword(name, password);
    }

    public User getUser(String userId) throws UserDoesNotExistException {
        return userRepository.getUserByUserId(userId);
    }
}
