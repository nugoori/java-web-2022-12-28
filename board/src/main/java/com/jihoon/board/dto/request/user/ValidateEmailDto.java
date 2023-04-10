package com.jihoon.board.dto.request.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="유저 이메일 중복체크 Request Body")
@Data
@NoArgsConstructor
public class ValidateEmailDto {
    @ApiModelProperty(value="유저 이메일", example="id@email.com", required=true)
    @NotBlank
    @Email
    private String email;
}
