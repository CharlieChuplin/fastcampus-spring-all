package com.fastcampus.programming.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // @CreatedDate @LastModifiedDate 사용하여 날짜 값을 자동으로 설정
public class JpaConfig {
}
