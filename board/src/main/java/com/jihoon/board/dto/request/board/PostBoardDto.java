package com.jihoon.board.dto.request.board;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="게시물 작성 Request Body")
@Data
@NoArgsConstructor
public class PostBoardDto {
    @ApiModelProperty(value="게시물 제목", example="Board Title!!", required=true)
    @NotBlank
    private String boardTitle;

    @ApiModelProperty(value="게시물 내용", example="Board Content!!", required=true)
    @NotBlank
    private String boardContent;

    @ApiModelProperty(value="게시물 이미지 URL", example="http://~", required=false)
    private String boardImgUrl;
}
