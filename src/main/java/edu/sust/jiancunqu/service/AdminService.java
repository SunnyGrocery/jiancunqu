package edu.sust.jiancunqu.service;

import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.User;

import java.util.List;

/**
 * Created by SunnyGrocery on 2021/1/8 14:47
 */
public interface AdminService {
    List<Admin> findAll();

    Admin findById(String id);

    Admin findByName(String name);

    Admin save(Admin admin);

    Admin change(Admin admin);

    void removeById(String id);
}
