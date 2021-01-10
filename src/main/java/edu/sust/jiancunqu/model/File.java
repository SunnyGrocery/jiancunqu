package edu.sust.jiancunqu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {
    private String fileName;
    private String fileSize;
    private Date ptime;
    //用户名称
    private String name;

    private String url;

    //共享
    private Integer share = 0;


}
