package com.jihoon.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Searchwordlog")
@Table(name="Searchwordlog")
public class SearchWordLogEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int sequence;
    private String searchWord;

    public SearchWordLogEntity(String searchWord) {
        this.searchWord = searchWord;
    }
}
