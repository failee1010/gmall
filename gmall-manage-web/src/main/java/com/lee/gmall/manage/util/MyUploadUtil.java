package com.lee.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class MyUploadUtil {

    public static String uploadImage(MultipartFile file) {
        //配置fdfs的全局信息
        String path = MyUploadUtil.class.getClassLoader().getResource("tracker.conf").getFile();
        try {
            ClientGlobal.init(path);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        //获得tracker
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = null;
        try {
            connection = trackerClient.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通过tracker获得storage
        StorageClient storageClient = new StorageClient(connection, null);
        //通过storage上传文件
        String[] gifs = new String[0];
        try {
            //获取扩展名
            String originalFilename = file.getOriginalFilename();
            int i = originalFilename.lastIndexOf(".");
            String substring = originalFilename.substring(i + 1);
            gifs = storageClient.upload_file(file.getBytes(), substring, null);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        String url = "http://192.168.159.129:8888";
        for (String gif :
                gifs) {
            url = url + "/" + gif;
        }
        return url;

    }
}
