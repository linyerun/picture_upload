package com.lin.picture_upload.controller;

import com.lin.picture_upload.common.Result;
import com.lin.picture_upload.dto.pic.ReturnData;
import com.lin.picture_upload.service.PictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pic")
@Api(tags = "OSS")
public class PictureController {

    private final PictureService service;

    public PictureController(PictureService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<ReturnData> uploadOssFile(MultipartFile file) {
        String url = service.uploadOssFile(file);
        if (url == null) return new Result<>(401,"上传失败，请稍后再次尝试。",null);
        return new Result<>(500,"成功",new ReturnData(url));
    }
}
