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
@Entity(name="Relatedsearchword")
@Table(name="Relatedsearchword")
public class RelatedSearchWordEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int sequence;
    private String searchWord;
    private String previousSearchWord;

    public RelatedSearchWordEntity(String searchWord, String previousSearchWord) {
        this.searchWord = searchWord;
        this.previousSearchWord = previousSearchWord;
    }
}
