package com.zhengcj.demo.swagger.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${swagger.enabled}")
    private boolean swaggerEnabled;

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.macro.mall.demo"))
                .apis(basePackage(
                        "com.zhengcj.demo.swagger.controller1",
                        "com.zhengcj.demo.swagger.controller2"))
                .paths(PathSelectors.any())
//                .paths(PathSelectors.ant("/admin/*"))
                .build()
                .apiInfo(getApiInfo())
                .enable(swaggerEnabled);
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("swagger title demo")
                .description("swagger description demo")
                .version("0.0.1")
                .license("@2019 demo Service. All Rights Reserved")
                .licenseUrl("https://www.demo.com")
                .contact(new Contact("zhengcj", "https://www.zhengcj.com", "zhengcj@demo.com"))
                .build();
    }

//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }

    public static Predicate<RequestHandler> basePackage(final String... basePackages) {
        return new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                return declaringClass(input).transform(handlerPackage(basePackages)).or(true);
            }
        };
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String... basePackages) {
        return new Function<Class<?>, Boolean>() {
            @Override
            public Boolean apply(Class<?> input) {// 循环判断匹配
                for (String basePackage : basePackages) {
                    boolean isMatch = input.getPackage().getName().startsWith(basePackage);
                    if (isMatch) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}
