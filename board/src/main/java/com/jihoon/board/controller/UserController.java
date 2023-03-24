package com.jihoon.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihoon.board.common.constant.ApiPattern;
import com.jihoon.board.dto.request.user.PatchProfileDto;
import com.jihoon.board.dto.response.ResponseDto;
import com.jihoon.board.dto.response.user.PatchProfileResponseDto;
import com.jihoon.board.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="유저 모듈")
@RestController
@RequestMapping(ApiPattern.USER)
public class UserController {

    @Autowired private UserService userService;

    private final String PATCH_PROFILE = "/profile";

    @ApiOperation(value="유저 프로필 URL 수정", notes="Request Header Athorization에 Bearer JWT를 포함하여 Request Body에 profile을 포함하여 요청을 하면 성공시 유저 정보를 반환, 실패시 실패 메세지를 반환")
    @PatchMapping(PATCH_PROFILE)
    public ResponseDto<PatchProfileResponseDto> patchProfile(
        @ApiParam(hidden=true)
        @AuthenticationPrincipal String email,        
        @Valid @RequestBody PatchProfileDto requestBody
    ) {
        ResponseDto<PatchProfileResponseDto> response = userService.patchProfile(email, requestBody);
        return response;
    }
    
}
