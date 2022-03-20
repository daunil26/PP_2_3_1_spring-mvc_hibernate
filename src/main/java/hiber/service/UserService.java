package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void removeUserById(long id);
    User getUserById(long id);
    List<User> listUsers();
    void updateUserById(User user);
}
