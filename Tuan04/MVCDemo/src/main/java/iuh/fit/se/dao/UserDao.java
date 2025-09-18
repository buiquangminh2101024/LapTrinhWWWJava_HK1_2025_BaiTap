package iuh.fit.se.dao;

import iuh.fit.se.models.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    void delete(String userId);
    void update(User user);
    User findById(int id);
    List<User> findAll();
}
