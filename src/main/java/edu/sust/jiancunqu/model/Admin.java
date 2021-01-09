package edu.sust.jiancunqu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Created by SunnyGrocery on 2021/1/8 10:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private String id;
    private String name;
    private String pwd;
    private Integer availableFlag;
}
