package edu.sust.jiancunqu.service.impl;

import edu.sust.jiancunqu.mapper.AdminMapper;
import edu.sust.jiancunqu.mapper.FileMapper;
import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.File;
import edu.sust.jiancunqu.model.User;
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
    public File selectByName(String fileName) {
        return fileMapper.selectByName(fileName);
    }

    @Override
    public List<File> findByName(String name) {
        return fileMapper.findByName(name);
    }

    @Override
    public void save(File file) {
        fileMapper.save(file);
    }

    @Override
    public List<File> shareFile(Integer share) {
         return fileMapper.shareFile(share);
    }

    @Override
    public void update(File file) {
        fileMapper.update(file);
    }

    @Override
    public void delete(String fileName) {
        fileMapper.delete(fileName);
    }

}
