package edu.sust.jiancunqu.service.impl;

import edu.sust.jiancunqu.mapper.UserMapper;
import edu.sust.jiancunqu.model.User;
import edu.sust.jiancunqu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SunnyGrocery on 2021/1/8 14:47
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public User findByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public User change(User user) {
        return userMapper.update(user);
    }

    @Override
    public void removeById(String id) {
        userMapper.delete(id);
    }
}
