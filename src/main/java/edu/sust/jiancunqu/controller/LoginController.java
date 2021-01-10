package edu.sust.jiancunqu.controller;

import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.User;
import edu.sust.jiancunqu.service.AdminService;
import edu.sust.jiancunqu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public String infoJump(String name, String pwd, Model model, HttpServletResponse response) {
        Admin admin = adminService.findByName(name);
        if (admin != null) {
            if (admin.getPwd().equals(pwd)) {
                response.addCookie(new Cookie("loginUser", name));
                return "redirect:/admin/info";
            }
        }
        User user = userService.findByName(name);
        if (user != null) {
            if (user.getPwd().equals(pwd)) {
                    model.addAttribute("user", user);
                    response.addCookie(new Cookie("loginUser", name));
                    return "user_info";
            }

        }

        return "redirect:/";
    }
}
