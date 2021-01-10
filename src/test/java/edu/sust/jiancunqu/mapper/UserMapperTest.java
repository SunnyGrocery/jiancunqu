package edu.sust.jiancunqu.mapper;

import edu.sust.jiancunqu.model.File;
import edu.sust.jiancunqu.model.User;
import edu.sust.jiancunqu.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FileService fileService;
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
    @Test
    @Transactional
    void findbyname(){
        List<File> files = fileService.findByName("1");
        System.out.println(files);
    }
}