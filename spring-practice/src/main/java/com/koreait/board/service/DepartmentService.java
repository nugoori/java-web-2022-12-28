package com.koreait.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.common.constant.ResponseMessage;
import com.koreait.board.dto.request.department.PostDepartmentRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.department.DeleteDepartmentResponseDto;
import com.koreait.board.dto.response.department.GetAllDepartmentListResponseDto;
import com.koreait.board.dto.response.department.PostDepartmentResponseDto;
import com.koreait.board.entity.DepartmentEntity;
import com.koreait.board.repository.DepartmentRepository;
import com.koreait.board.repository.EmployeeRepository;

@Service
public class DepartmentService {

    @Autowired EmployeeRepository employeeRepository;
    @Autowired DepartmentRepository departmentRepository;

    public ResponseDto<PostDepartmentResponseDto> postDepartment(PostDepartmentRequestDto dto) {
        
        PostDepartmentResponseDto data = null;

        String departmentCode = dto.getDepartmentCode();
        int cheifEmployeeNumber = dto.getCheif();

        try {

            boolean hasDepartment = departmentRepository.existsById(departmentCode);
            if (hasDepartment) return ResponseDto.setFail(ResponseMessage.EXIST_DEPARTMENT_CODE);

            boolean hasEmployee = employeeRepository.existsById(cheifEmployeeNumber);
            if (!hasEmployee) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_EMPLOYEE_NUMBER);

            DepartmentEntity departmentEntity = new DepartmentEntity(dto);
            departmentRepository.save(departmentEntity);

            data = new PostDepartmentResponseDto(departmentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<List<GetAllDepartmentListResponseDto>> getAllDepartmentList() {

        List<GetAllDepartmentListResponseDto> data = null;

        try {

            List<DepartmentEntity> departmentList = departmentRepository.findAll();
            data = GetAllDepartmentListResponseDto.copyList(departmentList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<List<DeleteDepartmentResponseDto>> deleteDepartment(String departmentCode) {

        List<DeleteDepartmentResponseDto> data = null;

        try {

            boolean hasDepartment = departmentRepository.existsById(departmentCode);
            if (!hasDepartment) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_DEPARTMENT_CODE);

            boolean hasReferenceEmployee = employeeRepository.existsByDepartment(departmentCode);
            if (hasReferenceEmployee) return ResponseDto.setFail(ResponseMessage.REFERRING_EXIST);

            departmentRepository.deleteById(departmentCode);
            
            List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
            data = DeleteDepartmentResponseDto.copyList(departmentEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

}
