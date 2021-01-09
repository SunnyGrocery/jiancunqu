package edu.sust.jiancunqu.mapper;

import edu.sust.jiancunqu.model.Admin;
import edu.sust.jiancunqu.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SunnyGrocery on 2021/1/8 12:53
 */
@Repository
@Mapper
public interface AdminMapper {
    List<Admin> selectAll();

    Admin selectById(String id);

    Admin selectByName(String name);

    Admin insert(Admin admin);

    Admin update(Admin admin);

    void delete(String id);
}
