package edu.sust.jiancunqu.controller;

import com.obs.services.ObsClient;
import com.obs.services.model.ObjectListing;
import com.obs.services.model.ObsObject;
import com.obs.services.model.PutObjectResult;
import edu.sust.jiancunqu.Utils.BucketObjectUtil;
import edu.sust.jiancunqu.Utils.ObsUtil;
import edu.sust.jiancunqu.model.File;
import edu.sust.jiancunqu.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FileController {
    @Autowired
    private FileService fileService;

    @Autowired
    private ObsUtil obsUtil;

    @RequestMapping("/upload")
    public String upLoading(MultipartFile file, HttpServletRequest request,Model model) throws Exception {
        //获取文件内容，根据表单中标签的name
        Part part = request.getPart("f");
        String file_name = request.getParameter("file_name");
        file_name = request.getParameter("name") + "_" + file_name;
        System.out.println("--------------->"+ file_name);
        String ptime = request.getParameter("file_time");
        System.out.println("--------------->"+ ptime);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sf.parse(ptime);
        System.out.println("----------------->"+ date);
        String file_size = request.getParameter("file_size");
        String name = request.getParameter("name");

        System.out.println(file_name);
        //将Part对象转化为输入流
        InputStream inputStream = part.getInputStream();

        //将输入流传入OBS提供的上传API
        ObsClient obsClient = obsUtil.getInstance();
        //obsClient.putObject("jiancunqu",file_name,inputStream);

        //获取客户端可以下载的url
        PutObjectResult putObjectResult = obsClient.putObject("jiancunqu", file_name, inputStream);

        BucketObjectUtil objectUtil = new BucketObjectUtil();
        String url = objectUtil.preview(file_name);
        System.out.println(url);


        //前边上传成功，将文件属性插入至数据库
        File file1 = new File();
        file1.setFileName(file_name);
        file1.setPtime(date);
        file1.setFileSize(file_size);
        file1.setName(name);
        file1.setUrl(url);

        fileService.save(file1);
        List<File> file_list = fileService.findAll();
        model.addAttribute("file_list",file_list);
        System.out.println(file1);


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

    //download
    @RequestMapping("/download")
    public void downLoad(String file_name, HttpServletResponse response) throws IOException {
        //String file_name = request.getParameter("file_name");
        //file_name = request.getParameter("name") + "_" + file_name;

        BucketObjectUtil objectUtil = new BucketObjectUtil();
        ObsObject file2 = objectUtil.getFile(file_name);

        response.setContentType("text/html;charset=utf-8");

        //通知浏览器以下载的方式打开
        response.addHeader("Content-Type","application/octet-stream");
        response.addHeader("Content-Disposition","attachment;filename=" + file_name.substring(file_name.indexOf('_') + 1));

        OutputStream out = response.getOutputStream();

        InputStream in = file2.getObjectContent();

        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=in.read(bytes))!=-1) {
            out.write(bytes,0,len);
        }

    }

}



