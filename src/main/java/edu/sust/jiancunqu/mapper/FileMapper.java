package edu.sust.jiancunqu.mapper;

import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.File;
import edu.sust.jiancunqu.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SunnyGrocery on 2021/1/8 12:53
 */
@Repository
@Mapper
public interface FileMapper {
    List<File> selectAll();

    File selectByName(String fileName);

    List<File> findByName(String name);

    void save(File file);

    List<File> shareFile(Integer share);

    void update(File file);

    void delete(String fileName);

}
