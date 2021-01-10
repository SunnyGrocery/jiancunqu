package edu.sust.jiancunqu.controller;

import edu.sust.jiancunqu.model.User;
import edu.sust.jiancunqu.service.AdminService;
import edu.sust.jiancunqu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by SunnyGrocery on 2021/1/10 13:27
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @RequestMapping("/info")
    public String info(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String adminName = null;
        for (Cookie cookie : cookies) {
            if ("loginUser".equals(cookie.getName())) {
                adminName = cookie.getValue();
                break;
            }
        }
        model.addAttribute("admin_name", adminName);
        model.addAttribute("user_list", userService.findAll());
        return "admin_info";
    }

    @PostMapping("/modify")
    public String modifyUser(User user) {
        userService.change(user);
        return "redirect:/admin/info";
    }

    @PostMapping("/forbid")
    public String forbidUser(String id, Boolean available) {
        User user = new User();
        user.setId(id);
        user.setAvailable(available);
        userService.change(user);
        return "redirect:/admin/info";
    }

    @PostMapping("/delete")
    public String deleteUser(String id) {
        userService.removeById(id);
        return "redirect:/admin/info";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.save(user);
        return "redirect:/admin/info";
    }
}
