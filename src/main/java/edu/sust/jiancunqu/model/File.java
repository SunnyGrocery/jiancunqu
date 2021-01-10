package edu.sust.jiancunqu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class File {
    private String fileName;
    private double fileSize;
    private Date ptime;
    //用户名称
    private String name;

    public File(String fileName, double fileSize, String name) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.ptime = new Date();
        this.name = name;
    }
}
