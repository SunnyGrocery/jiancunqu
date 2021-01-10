package edu.sust.jiancunqu;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseMobileNumberGenerator;
import edu.sust.jiancunqu.mapper.AdminMapper;
import edu.sust.jiancunqu.mapper.UserMapper;
import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.User;
import edu.sust.jiancunqu.service.AdminService;
import edu.sust.jiancunqu.service.UserService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Random;
import java.util.UUID;

@SpringBootTest
class JiancunquApplicationTests {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = new User();

        for (int i = 0; i < 20; i++) {
            String id = UUID.randomUUID().toString().substring(0, 31);
            user.setId(id);
            user.setName(Double.toString(new Random().nextDouble()));
            user.setPwd(MD5Encoder.encode(id.getBytes()));
            user.setPhoneNum(ChineseMobileNumberGenerator.getInstance().generate());
            user.setRealIdNum(ChineseIDCardNumberGenerator.getInstance().generate());
            user.setAvailable(true);
            userService.save(user);
        }
    }

}
