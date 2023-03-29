package com.jihoon.board.service;

import com.jihoon.board.dto.request.user.PatchProfileDto;
import com.jihoon.board.dto.response.ResponseDto;
import com.jihoon.board.dto.response.user.GetUserResponseDto;
import com.jihoon.board.dto.response.user.PatchProfileResponseDto;

public interface UserService {
    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, PatchProfileDto dto);
    public ResponseDto<GetUserResponseDto> getUser(String email);
}
