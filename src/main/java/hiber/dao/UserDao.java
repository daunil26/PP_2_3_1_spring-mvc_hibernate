package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void removeUserById(long id);
   User getUserById(long id);
   void updateUserById(User user);
   void add(User user);
   List<User> listUsers();
}
