package com.koreait.board.dto.response.department;

import java.util.ArrayList;
import java.util.List;

import com.koreait.board.entity.DepartmentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllDepartmentListResponseDto {
    //? 부서코드
    private String departmentCode;
    //? 부서명
    private String name;
    //? 부서장 사번
    private int cheif;
    //? 부서 전화번호
    private String telNumber;

    public GetAllDepartmentListResponseDto(DepartmentEntity departmentEntity) {
        this.departmentCode = departmentEntity.getDepartmentCode();
        this.name = departmentEntity.getName();
        this.cheif = departmentEntity.getCheif();
        this.telNumber = departmentEntity.getTelNumber();
    }

    public static List<GetAllDepartmentListResponseDto> copyList(List<DepartmentEntity> departmentEntities) {
        List<GetAllDepartmentListResponseDto> result = new ArrayList<GetAllDepartmentListResponseDto>();
        
        for (DepartmentEntity departmentEntity: departmentEntities) {
            GetAllDepartmentListResponseDto item = new GetAllDepartmentListResponseDto(departmentEntity);
            result.add(item);
        }

        return result;
    }
}
