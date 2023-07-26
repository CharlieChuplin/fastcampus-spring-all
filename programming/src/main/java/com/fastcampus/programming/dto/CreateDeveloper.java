package com.fastcampus.programming.dto;

import com.fastcampus.programming.entity.Developer;
import com.fastcampus.programming.type.DeveloperLevel;
import com.fastcampus.programming.type.DeveloperSkillType;
import lombok.*;

import javax.validation.constraints.*;

public class CreateDeveloper {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request {
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillType developerSkillType;
        @NotNull
        @Min(0)
        @Max(20)
        private Integer experienceYears;

        @NotNull
        @Size(min=3, max=50, message = "memberId size must 3~50")
        private String memberId;
        @NotNull
        @Size(min=3, max=50, message = "memberId size must 3~50")
        private String name;
        @Min(18)
        private Integer age;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private DeveloperLevel developerLevel;
        private DeveloperSkillType developerSkillType;
        private Integer experienceYears;
        private String memberId;

        public static Response fromEntity(@NonNull Developer developer) {
            return Response.builder()
                    .developerLevel(developer.getDeveloperLevel())
                    .developerSkillType(developer.getDeveloperSkillType())
                    .memberId(developer.getMemberId())
                    .experienceYears(developer.getExperienceYears())
                    .build();
        }
    }

}
