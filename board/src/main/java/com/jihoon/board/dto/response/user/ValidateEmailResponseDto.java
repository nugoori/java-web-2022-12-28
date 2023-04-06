package com.jihoon.board.dto.response.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="이메일 중복 체크 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateEmailResponseDto {
    @ApiModelProperty(value="중복 체크 결과", example="true", required=true)
    private boolean result;
    
}
