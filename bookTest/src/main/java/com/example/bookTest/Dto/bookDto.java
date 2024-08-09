package com.example.bookTest.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class bookDto {
	private int bookId;
	private String bookTitle;	// 책 제목
	private String bookAuthor;	// 저자
	private int bookCost;	// 가격
	private int bookPage;	// 페이지 수
	private String publisher;	// 출판사
}
