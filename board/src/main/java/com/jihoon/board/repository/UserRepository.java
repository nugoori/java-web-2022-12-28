package com.jihoon.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jihoon.board.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    
    public boolean existsByEmail(String email);
    public boolean existsByNickname(String nickname);
    public boolean existsByTelNumber(String telNumber);

    public boolean existsByEmailOrNicknameOrTelNumber(String email, String nickname, String telNumber);

    public UserEntity findByEmail(String email);

}
