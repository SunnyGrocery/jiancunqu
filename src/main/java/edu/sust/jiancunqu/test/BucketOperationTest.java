package edu.sust.jiancunqu.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



/**
 *
 */
public class BucketOperationTest {
	public static void main(String[] args) throws IOException {
		BucketObjectUtil objectUtil = new BucketObjectUtil();
		// 上传
		 Integer statusCode = objectUtil.uploadFile(new FileInputStream(new File("C:/Users/18400/Desktop/陕科学生SVN账号.txt")),"1");

		 File file = new File("C:/Users/Administrator/Desktop/陕科学生SVN账号.txt");
		 FileInputStream fis = new FileInputStream(file);
		 Integer statusCodes = objectUtil.uploadFile(fis, "陕科学生SVN账号.txt");
		 System.out.println(statusCodes);

		/*boolean flag = objectUtil.removeFile("陕科学生SVN账号.txt");
		System.out.println(flag);
*/
		// 查询所有
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// List<ObsObject> list = objectUtil.getAllFileInfo();
		// for (ObsObject obsObject : list) {
		// System.out
		// .println("文件名：" + obsObject.getObjectKey() + "\t文件大小：" +
		// obsObject.getMetadata().getContentLength()
		// + "B\t上传时间:" +
		// sdf.format(obsObject.getMetadata().getLastModified()));
		// }

		// 下载
		// ObsObject object = objectUtil.getFile("陕科学生SVN账号.txt");
		// if (object != null) {
		// InputStream is = object.getObjectContent();
		// FileOutputStream fos = new FileOutputStream(new
		// File("C:/Users/Administrator/Desktop/陕科学生SVN账号222.txt"));
		// // 自定义缓冲流经典写法
		// // 自定义缓冲区 1024
		// byte[] b = new byte[1024];
		// int len;
		// // 从字节数组里读
		// while ((len = is.read(b)) != -1) {
		// // 往出写，读多少写多少
		// fos.write(b, 0, len);
		// }
		// System.out.println("完成");
		// // 正向打开，逆向关闭
		// fos.close();
		// is.close();
		// } else {
		// System.out.println("没有您要下载的文件");
		// }

		// 预览
		// String url = objectUtil.preview("刚刚好--薛之谦.mp4");
		// System.out.println(url);

	}

}
