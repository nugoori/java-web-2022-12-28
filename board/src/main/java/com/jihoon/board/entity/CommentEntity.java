package com.jihoon.board.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jihoon.board.dto.request.board.PostCommentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Comment")
@Table(name="Comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int commentNumber;
    private String writerEmail;
    private int boardNumber;
    private String writeDatetime;
    private String commentContent;
    private String writerProfileUrl;
    private String writerNickname;

    public CommentEntity(UserEntity userEntity, PostCommentDto dto) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        this.writerEmail = userEntity.getEmail();
        this.boardNumber = dto.getBoardNumber();
        this.writeDatetime = simpleDateFormat.format(now);
        this.commentContent = dto.getCommentContent();
        this.writerProfileUrl = userEntity.getProfile();
        this.writerNickname = userEntity.getNickname();
    }
}
