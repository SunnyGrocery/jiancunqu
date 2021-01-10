package edu.sust.jiancunqu.service.impl;

import edu.sust.jiancunqu.mapper.AdminMapper;
import edu.sust.jiancunqu.mapper.FileMapper;
import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.File;
import edu.sust.jiancunqu.service.AdminService;
import edu.sust.jiancunqu.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SunnyGrocery on 2021/1/8 14:47
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public List<File> findAll() {
        return fileMapper.selectAll();
    }

    @Override
    public File findById(String id) {
        return fileMapper.selectById(id);
    }

    @Override
    public List<File> selectByName(String fileName) {
        return fileMapper.selectByName(fileName);
    }

    @Override
    public List<File> findByName(String name) {
        return fileMapper.findByName(name);
    }

    @Override
    public File save(File file) {
        return fileMapper.insert(file);
    }



    @Override
    public void removeById(String id) {
        fileMapper.delete(id);
    }
}
