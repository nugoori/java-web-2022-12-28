package com.jihoon.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jihoon.board.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    
    public List<CommentEntity> findByBoardNumberOrderByWriteDatetimeDesc(int boardNumber);
    
    @Transactional
    public void deleteByBoardNumber(int boardNumber);

}
