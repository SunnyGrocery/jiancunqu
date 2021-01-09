package edu.sust.jiancunqu.mapper;

import edu.sust.jiancunqu.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    @Transactional
    void insert() {
        User user = new User();
        user.setId("122");
        user.setPhoneNum("12345");
        user.setAvailable(true);
        user.setRealIdNum("sadas");
        user.setName("asdas");
        user.setPwd("sadasd");
        user.setVolume(123);
        userMapper.insert(user);
    }
}