package com.lin.picture_upload.service.impl;

import com.lin.picture_upload.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class PictureServiceImpl implements PictureService {

    @Value("${pic.host}")
    private String host;
    @Value("${pic.path}")
    private String path;

    @Override
    public String uploadOssFile(MultipartFile file) {
        String prefix =
                "/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File f = new File(path + prefix);
        if (!f.exists()) f.mkdirs();
        prefix +=
                "/"+ UUID.randomUUID().toString().replaceAll("-","")+
                "_"+file.getOriginalFilename();
        try {
            InputStream in = file.getInputStream();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path + prefix));
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = in.read(buf))!=-1 ) {
                out.write(buf,0,len);
            }
            out.flush();
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;//出现错误，返回null
        }
        return host+prefix;
    }
}
