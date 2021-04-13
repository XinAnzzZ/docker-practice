package com.yuhangma.docker.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Moore
 * @since 2020/04/13
 */
@RestController
@SpringBootApplication
public class DockerPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerPracticeApplication.class, args);
    }

    @GetMapping("/test/docker/practice")
    public String testDockerPractice() {
        return "Hello Docker!";
    }
}
