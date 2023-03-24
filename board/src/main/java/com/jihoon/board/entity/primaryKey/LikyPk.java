package com.jihoon.board.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
public class LikyPk implements Serializable {

    @Column(name="user_email")
    private String userEmail;

    @Column(name="board_number")
    private int boardNumber;
    
}
