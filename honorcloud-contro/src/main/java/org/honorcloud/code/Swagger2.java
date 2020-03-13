package org.honorcloud.code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
	
	@Bean
	public Docket ProductApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				// 是否开启
                .enable(true)
                .select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("org.honorcloud.controller"))//此处填写包的路径
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
				.apiInfo(productApiInfo());
	}

	private ApiInfo productApiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("王者荣耀-巔峰明月系统数据接口文档")
				.version("1.0.0")
				.description("Spring Boot测试使用 Swagger2 构建RESTful API")
				.license("sumoonyoko")
				.licenseUrl("https://github.com/sumoonyoko/honorcloud.git")
				.build();
		return apiInfo;
	}
	
}
