package com.jihoon.board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.jihoon.board.entity.resultSet.RelatedSearchWordResultSet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="검색어에 해당하는 연관 검색어 리스트 가져오기 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTop15RelatedSearchWordResponseDto {
    @ApiModelProperty(value="상위 15개의 연관 검색어 리스트", example="['아침', '점심', '저녁']", required=true)
    private List<String> top15SearchWordList;

    public static GetTop15RelatedSearchWordResponseDto copyList(List<RelatedSearchWordResultSet> list) {
        List<String> result = new ArrayList<>();
        for (RelatedSearchWordResultSet item: list) {
            result.add(item.getPreviousSearchWord());
        }
        return new GetTop15RelatedSearchWordResponseDto(result);
    }
}
