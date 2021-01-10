package edu.sust.jiancunqu.service;

import edu.sust.jiancunqu.model.User;

import java.util.List;

/**
 * Created by SunnyGrocery on 2021/1/8 14:47
 */
public interface UserService {
    List<User> findAll();

    User findById(String id);

    User findByName(String name);

    void save(User user);

    void change(User user);

    void removeById(String id);
}
