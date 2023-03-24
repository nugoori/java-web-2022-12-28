package com.jihoon.board.dto.request.user;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="유저 프로필 URL 수정 Request Body")
@Data
@NoArgsConstructor
public class PatchProfileDto {
    @ApiModelProperty(value="프로필 이미지 URL", example="http://~", required=true)
    @NotBlank
    @URL
    private String profile;
}
