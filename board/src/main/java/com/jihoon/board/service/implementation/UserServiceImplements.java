package com.jihoon.board.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jihoon.board.common.constant.ResponseMessage;
import com.jihoon.board.dto.request.user.PatchProfileDto;
import com.jihoon.board.dto.response.ResponseDto;
import com.jihoon.board.dto.response.user.PatchProfileResponseDto;
import com.jihoon.board.entity.UserEntity;
import com.jihoon.board.repository.UserRepository;
import com.jihoon.board.service.UserService;

@Service
public class UserServiceImplements implements UserService {
    
    @Autowired private UserRepository userRepository;

    public ResponseDto<PatchProfileResponseDto> patchProfile(String email, PatchProfileDto dto) {

        PatchProfileResponseDto data = null;

        String profile = dto.getProfile();

        try {

            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);
            
            userEntity.setProfile(profile);
            userRepository.save(userEntity);

            data = new PatchProfileResponseDto(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

}
