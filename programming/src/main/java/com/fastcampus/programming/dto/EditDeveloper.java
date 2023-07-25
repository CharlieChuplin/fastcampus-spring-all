package com.fastcampus.programming.dto;

import com.fastcampus.programming.type.DeveloperLevel;
import com.fastcampus.programming.type.DeveloperSkillType;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class EditDeveloper {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Request {
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillType developerSkillType;
        @NotNull
        @Min(0) @Max(20)
        private Integer experienceYears;
    }

}
