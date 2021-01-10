package edu.sust.jiancunqu.service.impl;

import edu.sust.jiancunqu.mapper.AdminMapper;
import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.User;
import edu.sust.jiancunqu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SunnyGrocery on 2021/1/8 14:47
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {
        return adminMapper.selectAll();
    }

    @Override
    public Admin findById(String id) {
        return adminMapper.selectById(id);
    }

    @Override
    public Admin findByName(String name) {
        return adminMapper.selectByName(name);
    }

    @Override
    public void save(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public void change(Admin admin) {
        adminMapper.update(admin);
    }

    @Override
    public void removeById(String id) {
        adminMapper.delete(id);
    }
}
