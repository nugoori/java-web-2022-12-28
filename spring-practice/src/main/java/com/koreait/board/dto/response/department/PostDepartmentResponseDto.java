package com.koreait.board.dto.response.department;

import com.koreait.board.entity.DepartmentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDepartmentResponseDto {

    private String departmentCode;
    private String name;
    private int cheif;
    private String telNumber;

    public PostDepartmentResponseDto(DepartmentEntity departmentEntity) {
        this.departmentCode = departmentEntity.getDepartmentCode();
        this.name = departmentEntity.getName();
        this.cheif = departmentEntity.getCheif();
        this.telNumber = departmentEntity.getTelNumber();
    }
}
