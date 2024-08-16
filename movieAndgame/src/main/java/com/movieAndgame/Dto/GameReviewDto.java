package com.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameReviewDto {
	
	private int postId;
	
	@NotBlank(message="제목은 꼭 입력하세요")
	private String writer;
	
	private String title;
	
	private String gameName;
	private String targetPost;
	
	private LocalDateTime writeDate;
}
