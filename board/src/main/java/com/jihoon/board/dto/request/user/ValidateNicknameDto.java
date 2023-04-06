package com.jihoon.board.dto.request.user;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="유저 닉네임 중복 체크 Request Body")
@Data
@NoArgsConstructor
public class ValidateNicknameDto {
    @ApiModelProperty(value="유저 닉네임", example="이상한거적지마세요", required=true)
    @NotBlank
    @Length(min=0, max=15)
    private String nickname;
}
