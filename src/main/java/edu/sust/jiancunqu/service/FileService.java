package edu.sust.jiancunqu.service;

import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.File;
import edu.sust.jiancunqu.model.User;

import java.util.List;

/**
 * Created by SunnyGrocery on 2021/1/8 14:47
 */
public interface FileService {
    List<File> findAll();


    File selectByName(String fileName);

    List<File> findByName(String name);

    void save(File file);

    List<File> shareFile(Integer share);

    void update(File file);

    void delete(String fileName);

}
