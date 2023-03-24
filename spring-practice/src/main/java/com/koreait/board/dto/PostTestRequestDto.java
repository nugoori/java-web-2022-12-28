package com.koreait.board.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostTestRequestDto {

	@NotBlank
	private String text;
	private int number;
	private boolean flag;
	
}
