package repository;

import exceptions.UserDoesNotExistException;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> userMap = new HashMap<>();
    private Map<String, String> userLoginMap = new HashMap<>();

    public User createUser(User user) {
        userMap.put(user.getUserId(), user);
        userLoginMap.put(user.getName(), user.getUserId());
        return user;
    }

    public User getUserByUserId(String userId) throws UserDoesNotExistException {
        if (!userMap.containsKey(userId)) {
            throw new UserDoesNotExistException("User with given userId does not exist " + userId);
        }
        return userMap.get(userId);
    }

    public boolean getUserByUserNameAndUserPassword(String name, String password) throws UserDoesNotExistException {
        User user = null;
        if (userLoginMap.containsKey(name)) {
            user = getUserByUserId(userLoginMap.get(name));
        }
        if (user != null && password.equals(user.getPassword())) {
            return true;
        }
        return false;


    }

}
