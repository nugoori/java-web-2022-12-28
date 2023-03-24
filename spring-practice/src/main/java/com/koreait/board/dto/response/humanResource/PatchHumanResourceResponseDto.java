package com.koreait.board.dto.response.humanResource;

import com.koreait.board.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchHumanResourceResponseDto {
    //? 사번
    private int employeeNumber;
    //? 직급
    private String position;
    //? 이름
    private String name;
    //? 나이
    private int age;
    //? 성별
    private String gender;
    //? 학력
    private String academicAbility;
    //? 생년월일
    private String birth;
    //? 휴대전화번호
    private String telNumber;
    //? 주소
    private String address;
    //? 상세 주소
    private String addressDetail;
    //? 입사일
    private String joinDate;
    //? 퇴사일
    private String resignationDate;
    //? 부서 코드
    private String department;
    //? 연봉
    private int annualIncome;
    //? 비고
    private String note;

    public PatchHumanResourceResponseDto(EmployeeEntity employeeEntity) {
        this.employeeNumber = employeeEntity.getEmployeeNumber();
        this.position = employeeEntity.getPosition();
        this.name = employeeEntity.getName();
        this.age = employeeEntity.getAge();
        this.gender = employeeEntity.getGender();
        this.academicAbility = employeeEntity.getAcademicAbility();
        this.birth = employeeEntity.getBirth();
        this.telNumber = employeeEntity.getTelNumber();
        this.address = employeeEntity.getAddress();
        this.addressDetail = employeeEntity.getAddressDetail();
        this.joinDate = employeeEntity.getJoinDate();
        this.resignationDate = employeeEntity.getResignationDate();
        this.department = employeeEntity.getDepartment();
        this.annualIncome = employeeEntity.getAnnualIncome();
        this.note = employeeEntity.getNote();
    }
}
