package edu.sust.jiancunqu.controller;

import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.User;
import edu.sust.jiancunqu.service.AdminService;
import edu.sust.jiancunqu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SunnyGrocery on 2021/1/8 15:23
 */
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping({"/info"})
    public String infoJump(String name, String pwd, Model model) {
        Admin admin = adminService.findByName(name);
        if (admin != null) {
            if (admin.getPwd().equals(pwd)) {
                model.addAttribute("admin_name", admin.getName());
                model.addAttribute("user_list", userService.findAll());
                return "admin_info";
            }
        }
        User user = userService.findByName(name);
        if (user != null) {
            if (user.getPwd().equals(pwd)) {
                model.addAttribute("user", user);
                return "user_info";
            }

        }

        return "redirect:/";
    }
}
