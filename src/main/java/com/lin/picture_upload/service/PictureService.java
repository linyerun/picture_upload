package com.lin.picture_upload.service;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
    String uploadOssFile(MultipartFile file);
}
