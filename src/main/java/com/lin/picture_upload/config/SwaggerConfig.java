package com.lin.picture_upload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


/**
 * Swagger 配置
 * @author dingdong
 */
@EnableSwagger2WebMvc
@Configuration
public class SwaggerConfig {

    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi() {
        // 指定扫描包路径
        return new Docket(DocumentationType.SWAGGER_2) // 指定生成的文档的类型是Swagger2
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lin.picture_upload.controller"))
                .paths(PathSelectors.any()).build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("文件OSS")
                // 描述
                .description("文件OSS程序开发文档")
                // 版本
                .version("版本号: 1.0")
                .build();
    }
}
