package com.ghao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

//@SpringBootApplication  
//@EnableCaching  
//public class BlogApplication extends SpringBootServletInitializer {  
//  
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
//        return application.sources(BlogApplication.class);  
//    }  
//  
//    public static void main(String[] args) {  
//        SpringApplication.run(BlogApplication.class, args);  
//    }  
//}
@SpringBootApplication
public class BlogApplication {  
    public static void main(String[] args) {  
        SpringApplication.run(BlogApplication.class, args);  
    }
}
