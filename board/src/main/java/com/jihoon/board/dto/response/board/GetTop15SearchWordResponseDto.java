package com.jihoon.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.jihoon.board.entity.resultSet.SearchWordResultSet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="인기 검색어 리스트 가져오기 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTop15SearchWordResponseDto {
    @ApiModelProperty(value="상위 15개 인기 검색어 리스트", example="['아침', '점심', '저녁']", required=true)
    private List<String> top15SearchWordList;

    public static GetTop15SearchWordResponseDto copyList(List<SearchWordResultSet> list) {
        List<String> result = new ArrayList<>();
        for (SearchWordResultSet item: list) {
            result.add(item.getSearchWord());
        }
        return new GetTop15SearchWordResponseDto(result);
    }
}
