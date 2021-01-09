package edu.sust.jiancunqu.mapper;

import edu.sust.jiancunqu.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SunnyGrocery on 2021/1/8 12:53
 */
@Repository
@Mapper
public interface UserMapper {
    List<User> selectAll();

    User selectById(String id);

    User selectByName(String name);

    void insert(User user);

    User update(User user);

    void delete(String id);
}
