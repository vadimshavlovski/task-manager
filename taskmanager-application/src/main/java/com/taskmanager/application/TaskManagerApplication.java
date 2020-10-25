package com.taskmanager.application;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SuppressWarnings("PMD.UseUtilityClass")
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class TaskManagerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TaskManagerApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .listeners(new ApplicationPidFileWriter())
            .run(args);
    }
}
