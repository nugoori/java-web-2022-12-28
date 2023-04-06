package com.jihoon.board.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="로그인 Request Body")
@Data
@NoArgsConstructor
public class SignInDto {
    @ApiModelProperty(value="사용자 이메일", example="jiraynor@naver.com", required=true)
    @NotBlank
    @Email
    @Length(max=40)
    private String email;

    @ApiModelProperty(value="비밀번호", example="P!ssw0rd", required=true)
    @NotBlank
    @Length(min=8, max=20)
    private String password;
}
