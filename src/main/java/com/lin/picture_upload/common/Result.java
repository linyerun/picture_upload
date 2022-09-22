package com.lin.picture_upload.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Result<T> {

    @ApiModelProperty(value = "返回码", position = 1)
    private int code;
    @ApiModelProperty(value = "提示信息", position = 2)
    private String message;
    @ApiModelProperty(value = "数据", position = 4)
    private T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
