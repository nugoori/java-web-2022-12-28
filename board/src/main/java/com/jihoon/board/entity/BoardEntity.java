package com.jihoon.board.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jihoon.board.dto.request.board.PatchBoardDto;
import com.jihoon.board.dto.request.board.PostBoardDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Board")
@Table(name="Board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImgUrl;
    private String boardWriteDatetime;
    private int viewCount;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileUrl;
    private int commentCount;
    private int likeCount;

    public BoardEntity(UserEntity userEntity, PostBoardDto postBoardDto) {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.boardTitle = postBoardDto.getBoardTitle();
        this.boardContent = postBoardDto.getBoardContent();
        this.boardImgUrl = postBoardDto.getBoardImgUrl();
        this.boardWriteDatetime = simpleDateFormat.format(now);
        this.viewCount = 0;
        this.writerEmail = userEntity.getEmail();
        this.writerNickname = userEntity.getNickname();
        this.writerProfileUrl = userEntity.getProfile();
        this.commentCount = 0;
        this.likeCount = 0;
    }

    public void patch(PatchBoardDto dto) {
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
        this.boardImgUrl = dto.getBoardImgUrl();
    }

    public void increaseViewCount() {
        this.viewCount++;
    }

    public void increaseLikeCount() {
        this.likeCount++;
    }

    public void decreaseLikeCount() {
        this.likeCount--;
    }

    public void increaseCommentCount() {
        this.commentCount++;
    }
}
