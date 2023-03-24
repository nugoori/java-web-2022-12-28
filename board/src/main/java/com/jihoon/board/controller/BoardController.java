package com.jihoon.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihoon.board.common.constant.ApiPattern;
import com.jihoon.board.dto.request.board.LikeDto;
import com.jihoon.board.dto.request.board.PatchBoardDto;
import com.jihoon.board.dto.request.board.PostBoardDto;
import com.jihoon.board.dto.request.board.PostCommentDto;
import com.jihoon.board.dto.response.ResponseDto;
import com.jihoon.board.dto.response.board.DeleteBoardResponseDto;
import com.jihoon.board.dto.response.board.GetBoardResponseDto;
import com.jihoon.board.dto.response.board.GetListResponseDto;
import com.jihoon.board.dto.response.board.GetMyListResponseDto;
import com.jihoon.board.dto.response.board.GetSearchListResponseDto;
import com.jihoon.board.dto.response.board.GetTop15RelatedSearchWordResponseDto;
import com.jihoon.board.dto.response.board.GetTop15SearchWordResponseDto;
import com.jihoon.board.dto.response.board.GetTop3ListResponseDto;
import com.jihoon.board.dto.response.board.LikeResponseDto;
import com.jihoon.board.dto.response.board.PatchBoardResponseDto;
import com.jihoon.board.dto.response.board.PostBoardResponseDto;
import com.jihoon.board.dto.response.board.PostCommentResponseDto;
import com.jihoon.board.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="게시물 모듈")
@RestController
@RequestMapping(ApiPattern.BOARD)
public class BoardController {
    
    @Autowired private BoardService boardService;

    private final String POST_BOARD = "";
    private final String POST_COMMENT = "/comment";
    private final String LIKE = "/like";
    
    private final String GET_BOARD = "/{boardNumber}";
    private final String GET_LIST = "/list";
    private final String GET_MY_LIST = "/my-list";
    private final String GET_SEARCH_LIST = "/search-list/{searchWord}";
    private final String GET_SEARCH_LIST_PREVIOUS = "/search-list/{searchWord}/{previousSearchWord}";
    private final String GET_TOP3_LIST = "/top3-list";
    private final String GET_TOP15_SEARCH_WORD = "/top15-search-word";
    private final String GET_TOP15_RELATED_SEARCH_WORD = "/top15-related-search-word/{searchWord}";

    private final String PATCH_BOARD = "";
    
    private final String DELETE_BOARD = "/{boardNumber}";

    @ApiOperation(value="게시물 작성", notes="제목, 내용, 이미지를 전송하면 게시물 작성 결과로 작성된 게시물 정보를 반환, 실패시 실패 메시지를 반환")
    @PostMapping(POST_BOARD)
    public ResponseDto<PostBoardResponseDto> postBoard(
        @ApiParam(hidden=true)
        @AuthenticationPrincipal String email,
        @Valid @RequestBody PostBoardDto requestBody
    ) {
        ResponseDto<PostBoardResponseDto> response = boardService.postBoard(email, requestBody);
        return response;
    }

    @ApiOperation(value="댓글 작성", notes="Request Header Athorization에 Bearer JWT를 포함하고 Request Body에 boardNumber, content를 포함하여 요청을 하면, 성공시 게시물 전체 데이터를 반환, 실패시 실패 메시지를 반환")
    @PostMapping(POST_COMMENT)
    public ResponseDto<PostCommentResponseDto> postComment(
        @ApiParam(hidden=true)
        @AuthenticationPrincipal String email,
        @Valid @RequestBody PostCommentDto requestBody
    ) {
        ResponseDto<PostCommentResponseDto> response = boardService.postComment(email, requestBody);
        return response;
    }

    @ApiOperation(value="좋아요 기능", notes="Request Header Athorization에 Bearer JWT를 포함하고 Request Body에 boardNumber를 포함하여 요청을 하면, 성공시 게시물 전체 데이터를 반환, 실패시 실패 메세지를 반환")
    @PostMapping(LIKE)
    public ResponseDto<LikeResponseDto> like(
        @ApiParam(hidden=true)
        @AuthenticationPrincipal String email, 
        @Valid @RequestBody LikeDto requestBody
    ) {
        ResponseDto<LikeResponseDto> response = boardService.like(email, requestBody);
        return response;
    }

    @ApiOperation(value="특정 게시물 가져오기", notes="Path Variable에 boardNumber를 포함하여 요청을 하면, 성공시 게시물 전체 데이터를 반환, 실패시 실패 메세지를 반환")
    @GetMapping(GET_BOARD)
    public ResponseDto<GetBoardResponseDto> getBoard(
        @ApiParam(value="게시물 번호", example="1", required=true)
        @PathVariable("boardNumber") int boardNumber
    ) {
        ResponseDto<GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @ApiOperation(value="전체 게시물 리스트 가져오기", notes="요청을 하면, 성공시 전체 게시물 리스트를 최신순으로 반환, 실패시 실패 메세지를 반환")
    @GetMapping(GET_LIST)
    public ResponseDto<List<GetListResponseDto>> getList() {
        ResponseDto<List<GetListResponseDto>> response = boardService.getList();
        return response;
    }

    @ApiOperation(value="본인 작성 게시물 리스트 가져오기", notes="Request Header Athorization에 Bearer JWT를 포함하여 요청을 하면, 성공시 요청자가 작성한 게시물 전체 리스트를 최신순으로 반환, 실패시 실패 메세지를 반환")
    @GetMapping(GET_MY_LIST)
    public ResponseDto<List<GetMyListResponseDto>> getMyList(
        @ApiParam(hidden=true)
        @AuthenticationPrincipal String email) {
        ResponseDto<List<GetMyListResponseDto>> response = boardService.getMyList(email);
        return response;
    }

    @ApiOperation(value="검색어에 대한 게시물 리스트 가져오기", notes="Path Variable에 searchWord와 previousSearchWord를 포함하여 요청을 하면, 성공시 검색어에 해당하는 게시물 리스트를 최신순으로 반환, 실패시 실패 메세지를 반환")
    @GetMapping(value={GET_SEARCH_LIST_PREVIOUS, GET_SEARCH_LIST})
    public ResponseDto<List<GetSearchListResponseDto>> getSearchList(
        @ApiParam(value="검색어", example="아침", required=true)
        @PathVariable("searchWord") String searchWord,
        @ApiParam(value="이전 검색어", example="점심메뉴", required=false)
        @PathVariable(name="previousSearchWord", required=false) String previousSearchWord
    ) {
        ResponseDto<List<GetSearchListResponseDto>> response = boardService.getSearchList(searchWord, previousSearchWord);
        return response;
    }

    @ApiOperation(value="좋아요 기준 상위 3개의 게시물 리스트 가져오기", notes="요청을 하면, 성공시 좋아요 수 기준으로 상위 3개의 게시물 리스트를 반환, 실패시 실패 메세지를 반환")
    @GetMapping(GET_TOP3_LIST)
    public ResponseDto<List<GetTop3ListResponseDto>> getTop3List() {
        ResponseDto<List<GetTop3ListResponseDto>> response = boardService.getTop3List();
        return response;
    }

    @ApiOperation(value="인기 검색어 리스트 가져오기", notes="요청을 하면, 성공시 가장 많이 검색된 15개의 검색어 리스트를 반환, 실패시 실패 메세지를 반환")
    @GetMapping(GET_TOP15_SEARCH_WORD)
    public ResponseDto<GetTop15SearchWordResponseDto> getTop15SearchWord() {
        ResponseDto<GetTop15SearchWordResponseDto> response = boardService.getTop15SearchWord();
        return response;
    }

    @ApiOperation(value="검색어에 해당하는 연관 검색어 리스트 가져오기", notes="Path Variable에 searchWord를 포함하여 요청하면, 성공시 해당하는 검색어와 관련된 검색어 중 가장 많이 검색된 15개의 검색어 리스트를 반환, 실패시 실패 메세지를 반환")
    @GetMapping(GET_TOP15_RELATED_SEARCH_WORD)
    public ResponseDto<GetTop15RelatedSearchWordResponseDto> getTop15RelatedSearchWord(
        @ApiParam(value="검색어", example="아침", required=true)
        @PathVariable("searchWord") String searchWord
        ) {
        ResponseDto<GetTop15RelatedSearchWordResponseDto> response = boardService.getTop15RelatedSearchWord(searchWord);
        return response;
    }

    @ApiOperation(value="특정 게시물 수정", notes="Request Header Athorization에 Bearer JWT를 포함하고 Request Body에 boardNumber, title, content, boardImgUrl을 포함하여 요청하면, 성공시에 게시물 전체 데이터를 반환, 실패시에 실패 메세지를 반환")
    @PatchMapping(PATCH_BOARD)
    public ResponseDto<PatchBoardResponseDto> patchBoard(
        @ApiParam(hidden=true)
        @AuthenticationPrincipal String email, 
        @Valid @RequestBody PatchBoardDto requestBody
    ) {
        ResponseDto<PatchBoardResponseDto> response = 
            boardService.patchBoard(email, requestBody);
        return response;
    }

    @ApiOperation(value="특정 게시물 삭제", notes="Request Header Athorization에 Bearer JWT를 포함하고 Path Variable에 boardNumber를 포함하여 요청을 하면, 성공시 true를 반환, 실패시 실패 메세지를 반환")
    @DeleteMapping(DELETE_BOARD)
    public ResponseDto<DeleteBoardResponseDto> deleteBoard(
        @ApiParam(hidden=true)
        @AuthenticationPrincipal String email,
        @ApiParam(value="게시물 번호", example="1", required=true)
        @PathVariable("boardNumber") int boardNumber
    ) {
        ResponseDto<DeleteBoardResponseDto> response
            = boardService.deleteBoard(email, boardNumber);
        return response;
    }
}
