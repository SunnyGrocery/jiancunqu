package edu.sust.jiancunqu.model;

import lombok.*;
import org.apache.ibatis.annotations.Param;

/**
 * Created by SunnyGrocery on 2021/1/8 10:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private String pwd;
    private String phoneNum;
    private String realIdNum;
    private Integer volume;
    private Boolean available;

}
