package com.fastcampus.programming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // @CreatedDate @LastModifiedDate 사용하여 날짜 값을 자동으로 설정
public class ProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgrammingApplication.class, args);
    }

}
