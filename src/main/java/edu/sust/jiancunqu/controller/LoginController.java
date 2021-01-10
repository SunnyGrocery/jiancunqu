package edu.sust.jiancunqu.controller;

import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.File;
import edu.sust.jiancunqu.model.User;
import edu.sust.jiancunqu.service.AdminService;
import edu.sust.jiancunqu.service.FileService;
import edu.sust.jiancunqu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by SunnyGrocery on 2021/1/8 15:23
 */
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping({"/info"})
    public String infoJump(String id, String pwd, Model model, HttpServletResponse response) {
        Admin admin = adminService.findById(id);
        if (admin != null) {
            if (admin.getPwd().equals(pwd)) {
                response.addCookie(new Cookie("loginUser", id));
                return "redirect:/admin/info";
            }
        }
        User user = userService.findById(id);

        if (user != null) {
            if (user.getPwd().equals(pwd)) {
                response.addCookie(new Cookie("loginUser", id));
                model.addAttribute("user", user);
                List<File> fileList = fileService.findByName(user.getName());
                model.addAttribute("file_list", fileList);
                return "user_info";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response, HttpSession session) {
        Cookie cookie = new Cookie("loginUser", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
