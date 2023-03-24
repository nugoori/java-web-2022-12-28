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
public class DeleteDepartmentResponseDto {
    //? 부서코드
    private String departmentCode;
    //? 부서명
    private String name;
    //? 부서장 사번
    private int cheif;
    //? 부서 전화번호
    private String telNumber;

    public DeleteDepartmentResponseDto(DepartmentEntity departmentEntity) {
        this.departmentCode = departmentEntity.getDepartmentCode();
        this.name = departmentEntity.getName();
        this.cheif = departmentEntity.getCheif();
        this.telNumber = departmentEntity.getTelNumber();
    }

    public static List<DeleteDepartmentResponseDto> copyList(List<DepartmentEntity> departmentEntities) {
        List<DeleteDepartmentResponseDto> result = new ArrayList<DeleteDepartmentResponseDto>();
        
        for (DepartmentEntity departmentEntity: departmentEntities) {
            DeleteDepartmentResponseDto item = new DeleteDepartmentResponseDto(departmentEntity);
            result.add(item);
        }

        return result;
    }
}
