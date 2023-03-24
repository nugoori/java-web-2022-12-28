package com.koreait.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.board.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    
    public boolean existsByTelNumber(String telNumber);
    public boolean existsByDepartment(String department);

    public EmployeeEntity findByEmployeeNumber(int employeeNumber);

}
