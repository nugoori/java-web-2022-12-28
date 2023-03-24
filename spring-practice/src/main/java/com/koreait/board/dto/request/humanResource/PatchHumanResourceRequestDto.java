package com.koreait.board.dto.request.humanResource;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchHumanResourceRequestDto {
    //? 사번
    @Min(1)
    private int employeeNumber;

    //? 직급
    @NotBlank
    @Length(min=0, max=5)
    private String position;

    //? 이름
    @NotBlank
    @Length(min=0, max=10)
    private String name;

    //? 나이
    @Range(min=0, max=120)
    private int age;

    //? 성별
    @NotBlank
    @Length(min=0, max=5)
    private String gender;

    //? 학력
    @NotBlank
    @Length(min=0, max=10)
    private String academicAbility;

    //? 생년월일
    @NotBlank
    private String birth;

    //? 휴대전화번호
    @NotBlank
    private String telNumber;

    //? 주소
    @NotBlank
    private String address;

    //? 상세 주소
    @NotBlank
    private String addressDetail;

    //? 입사일
    @NotBlank
    private String joinDate;

    //? 퇴사일
    private String resignationDate;

    //? 부서 코드
    private String department;

    //? 연봉
    @Min(0)
    private int annualIncome;

    //? 비고
    private String note;
}
