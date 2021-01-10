package edu.sust.jiancunqu;

import cn.binarywang.tools.generator.ChineseIDCardNumberGenerator;
import cn.binarywang.tools.generator.ChineseMobileNumberGenerator;
import cn.binarywang.tools.generator.ChineseNameGenerator;
import cn.binarywang.tools.generator.util.ChineseCharUtils;
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
import sun.security.provider.MD5;

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
    void loadDB() {
        adminService.save(new Admin("1", "1", "1", 1));
        User user = new User();
        for (int i = 0; i < 20; i++) {
            String id = getRandomString(2) + "-202001" + randMonth();
            user.setId(id);
            user.setName(ChineseNameGenerator.getInstance().generate());
            user.setPwd(MD5Encoder.encode(id.getBytes()));
            user.setPhoneNum(ChineseMobileNumberGenerator.getInstance().generate());
            user.setRealIdNum(ChineseIDCardNumberGenerator.getInstance().generate());
            user.setAvailable(true);
            userService.save(user);
        }
    }

    public String randMonth() {
        int first = new Random().nextInt(1);
        int second = 1;
        if (first == 1) {
            second = new Random().nextInt(1) + 1;
        } else {
            second = new Random().nextInt(8) + 1;
        }
        return first + Integer.toString(second);
    }

    public static String getRandomString(int stringLength) {
        String string = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringLength; i++) {
            int index = (int) Math.floor(Math.random() * string.length());//向下取整0-25
            sb.append(string.charAt(index));
        }
        return sb.toString();
    }
}
