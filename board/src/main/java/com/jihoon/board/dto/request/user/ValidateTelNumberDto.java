package com.jihoon.board.dto.request.user;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="유저 전화번호 중복 체크 Request Body")
@Data
@NoArgsConstructor
public class ValidateTelNumberDto {
    @ApiModelProperty(value="유저 전화번호", example="010-0000-0000", required=true)
    @NotBlank
    @Max(13)
    private String telNumber;
}
