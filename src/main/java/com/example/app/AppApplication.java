package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.File;

import static com.example.app.constant.FileConstant.*;

@SpringBootApplication
@EnableJpaAuditing
public class AppApplication {


    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
        new File(USER_FOLDER).mkdirs();
        new File(CHANNEL_FOLDER).mkdirs();
        new File(POST_FOLDER).mkdirs();
    }

}
