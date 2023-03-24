package com.jihoon.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jihoon.board.common.constant.ApiPattern;
import com.jihoon.board.service.FileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="파일 모듈")
@RestController
@RequestMapping(ApiPattern.FILE)
public class FileController {
    
    @Autowired private FileService fileService;

    private final String UPLOAD = "/upload";
    private final String GET_FILE = "/{fileName}";

    @ApiOperation(value="파일 업로드", notes="Request Body에 100MB 이하의 file을 포함하여 요청을 하면, 성공시 다운로드 URL을 반환, 실패시 null을 반환")
    @PostMapping(UPLOAD)
    public String upload(
        @ApiParam(value="업로드할 파일", required=true)
        @RequestParam("file") MultipartFile file) {
        String response = fileService.upload(file);
        return response;
    }

    @ApiOperation(value="파일 다운로드", notes="Path Variable에 fileName을 포함하여 요청하면, 성공시 해당하는 파일의 Resource를 반환, 실패시 null을 반환")
    @GetMapping(value=GET_FILE, produces={MediaType.ALL_VALUE})
    public Resource getFile(
        @ApiParam(value="파일명", example="example.png", required=true)
        @PathVariable("fileName") String fileName) {
        Resource response = fileService.getFile(fileName);
        return response;
    }

}
