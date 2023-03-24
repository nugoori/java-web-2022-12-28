package com.koreait.board.dto.request.department;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDepartmentRequestDto {
    
    @NotBlank
    @Length(min = 0, max = 5)
    private String departmentCode;
    
    @NotBlank
    @Length(min = 0, max = 50)
    private String name;

    @Min(1)
    private int cheif;

    @NotBlank
    @Length(min = 0, max = 15)
    private String telNumber;

}
