// package com.server.ToyProject.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiInfo;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;


// //https://velog.io/@borab/Spring-boot-Swagger-%EC%84%A4%EC%A0%95-gradle

// @Configuration
// @EnableSwagger2
// public class SwaggerConfiguration {

//     @Bean
//     public Docket restAPI() {
//         return new Docket(DocumentationType.SWAGGER_2)
//                 .apiInfo(apiInfo())
//                 .select()
//                 .apis(RequestHandlerSelectors.basePackage("com.hobbybee"))
//                 .paths(PathSelectors.any())
//                 .build();
//     }

//     private ApiInfo apiInfo() {
//         return new ApiInfoBuilder()
//                 .title("hobbybee Spring Boot REST API")
//                 .version("1.0.0")
//                 .description("취미 생활 커뮤니티 hobbybee의 swagger api 입니다.")
//                 .build();
//     }
// }
