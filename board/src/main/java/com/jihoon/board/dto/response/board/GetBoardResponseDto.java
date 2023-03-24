package com.jihoon.board.dto.response.board;

import java.util.List;

import com.jihoon.board.entity.BoardEntity;
import com.jihoon.board.entity.CommentEntity;
import com.jihoon.board.entity.LikyEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="특정 게시물 가져오기 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBoardResponseDto {
    @ApiModelProperty(value="게시물 Entity", required=true)
    private BoardEntity board;
    @ApiModelProperty(value="댓글 Entity 리스트 ", required=true)
    private List<CommentEntity> commentList;
    @ApiModelProperty(value="좋아요 Entity 리스트 ", required=true)
    private List<LikyEntity> likeList;
}
