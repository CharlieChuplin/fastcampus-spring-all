package com.fastcampus.programming.entity;

import com.fastcampus.programming.code.StatusCode;
import com.fastcampus.programming.dto.CreateDeveloper;
import com.fastcampus.programming.type.DeveloperLevel;
import com.fastcampus.programming.type.DeveloperSkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class) //@EnableJpaAuditing 설정 -> @CreatedDate @LastModifiedDate 사용하여 날짜 값을 자동으로 설정
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    private DeveloperLevel developerLevel;

    @Enumerated(EnumType.STRING)
    private DeveloperSkillType developerSkillType;

    @Enumerated(EnumType.STRING)
    private StatusCode statusCode;

    private Integer experienceYears;
    private String memberId;
    private String name;
    private Integer age;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updateAt;




}
