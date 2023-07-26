package com.fastcampus.programming.dto;

import com.fastcampus.programming.exception.DMakerErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 로직 실패 -> 에러처리 -> DMakerResponse(dto)
public class DMakerErrorResponse {

    private DMakerErrorCode errorCode;
    private String errorMessage;

}
