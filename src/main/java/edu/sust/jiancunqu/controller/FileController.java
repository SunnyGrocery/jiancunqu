package edu.sust.jiancunqu.controller;

import com.obs.services.ObsClient;
import com.obs.services.model.ObjectListing;
import com.obs.services.model.ObsObject;
import edu.sust.jiancunqu.Utils.ObsUtil;
import edu.sust.jiancunqu.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
public class FileController {
    @Autowired
    private FileService fileService;

    @Autowired
    private ObsUtil obsUtil;

    @RequestMapping("/upload")
    public String upLoading(MultipartFile file) throws FileNotFoundException {
        ObsClient obsClient = obsUtil.getInstance();

        FileInputStream fis = new FileInputStream(new File("C:\\Users\\18400\\Desktop\\陕科学生SVN账号.txt"));  // 待上传的本地文件路径，需要指定到具体的文件名
        obsClient.putObject("jiancunqu", "q", fis);

        System.out.println(file);
        return "user_info";
    }

    @RequestMapping("/all_file")
    public String allFile(Model model) throws IOException {
        ObsClient obsClient = obsUtil.getInstance();
        ObjectListing objectList = obsClient.listObjects("jiancunqu");
        List<ObsObject> list = objectList.getObjects();
        model.addAttribute("file_list",list);

        obsClient.close();
        return "files";
    }
}



