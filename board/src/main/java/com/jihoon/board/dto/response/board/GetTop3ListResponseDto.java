package com.jihoon.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.jihoon.board.entity.BoardEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="좋아요 기준 상위 3개 게시물 리스트 가져오기 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTop3ListResponseDto {

    @ApiModelProperty(value="게시물 번호", example="1", required=true)
    private int boardNumber;
    @ApiModelProperty(value="게시물 제목", example="Board Title", required=true)
    private String boardTitle;
    @ApiModelProperty(value="게시물 내용", example="Board Content", required=true)
    private String boardContent;
    @ApiModelProperty(value="게시물 이미지 URL", example="Http://~", required=true)
    private String boardImgUrl;
    @ApiModelProperty(value="게시물 작성 날짜", example="2023-02-03 17:20", required=true)
    private String boardWriteDatetime;
    @ApiModelProperty(value="조회 수", example="0", required=true)
    private int viewCount;
    @ApiModelProperty(value="작성자 닉네임", example="nugoori", required=true)
    private String writerNickname;
    @ApiModelProperty(value="작성자 프로필 이미지 URL", example="Http://~", required=true)
    private String writerProfileUrl;
    @ApiModelProperty(value="댓글 수", example="0", required=true)
    private int commentCount;
    @ApiModelProperty(value="좋아요 수", example="0", required=true)
    private int likeCount;

    public GetTop3ListResponseDto(BoardEntity boardEntity) {
        this.boardNumber = boardEntity.getBoardNumber();
        this.boardTitle = boardEntity.getBoardTitle();
        this.boardContent = boardEntity.getBoardContent();
        this.boardImgUrl = boardEntity.getBoardImgUrl();
        this.boardWriteDatetime = boardEntity.getBoardWriteDatetime();
        this.viewCount = boardEntity.getViewCount();
        this.writerNickname = boardEntity.getWriterNickname();
        this.writerProfileUrl = boardEntity.getWriterProfileUrl();
        this.commentCount = boardEntity.getCommentCount();
        this.likeCount = boardEntity.getLikeCount();
    }

    public static List<GetTop3ListResponseDto> copyList(List<BoardEntity> boardEntityList) {

        List<GetTop3ListResponseDto> list = new ArrayList<>();

        for (BoardEntity boardEntity: boardEntityList) {
            GetTop3ListResponseDto dto = new GetTop3ListResponseDto(boardEntity);
            list.add(dto);
        }

        return list;

    }




}
