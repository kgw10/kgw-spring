package com.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieReviewDto {
	
	private int reviewId;
	
	@NotBlank(message="제목은 꼭 입력하세요")
	private String title;
	
	private String writer;
	
	@Size(min=10, max=300, message="10자 이상 300자 이하로 입력하세요")
	private String content;
	private LocalDateTime writeDate;
}
