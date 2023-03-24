package com.jihoon.board.dto.response.user;

import com.jihoon.board.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="유저 프로필 URL 수정 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchProfileResponseDto {
    @ApiModelProperty(value="유저 이메일", example="yir@akak.com", required=true)
    private String email;
    @ApiModelProperty(value="유저 닉네임", example="nugoori", required=true)
    private String nickname;
    @ApiModelProperty(value="유저 휴대전화 번호", example="010-0000-0000", required=true)
    private String telNumber;
    @ApiModelProperty(value="유저 주소", example="부산광역시 해운대구", required=true)
    private String address;
    @ApiModelProperty(value="유저 프로필 이미지 URL", example="Http://~", required=true)
    private String profile;

    public PatchProfileResponseDto(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.telNumber = userEntity.getTelNumber();
        this.address = userEntity.getAddress();
        this.profile = userEntity.getProfile();
    }
}
