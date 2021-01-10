package edu.sust.jiancunqu.mapper;

import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.File;
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

    File selectById(String id);

    List<File> selectByName(String fileName);

    List<File> findByName(String name);

    File insert(File file);

    void delete(String id);
}
