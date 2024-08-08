package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.BookClassDto;

@Repository
public class BookDAO {
	
	
	private final JdbcTemplate jt;
	
	@Autowired
	public BookDAO( JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}
	
	// book 테이블 전체 데이터 가져오기 - 첫 화면에 목록으로 출력하기 위해
	public List<BookClassDto> select(){
		String sql="select * from book";
		List<BookClassDto> list = jt.query(sql, new BookClassDtoRowMapper());
		
		return list;
	}
	
	
	
	public void insert( BookClassDto bookDto) {	// 도서 정보 데이터베이스에 저장
		String sql="insert into book(book_title, book_author, book_cost, book_page, publisher) values(?,?,?,?,?)";
		jt.update(sql , bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookCost(), bookDto.getBookPage(), bookDto.getPublisher());
	}
	
	public class BookClassDtoRowMapper implements RowMapper<BookClassDto> {

		@Override
		public BookClassDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookClassDto bookDto = new BookClassDto();
			bookDto.setBookAuthor(rs.getString("book_author"));
			bookDto.setBookCost(rs.getInt("book_cost"));
			bookDto.setBookPage(rs.getInt("book_page"));
			bookDto.setBookTitle(rs.getString("book_title"));
			bookDto.setPublisher(rs.getString("publisher"));
			bookDto.setBookId(rs.getInt("book_id"));
			
			
			return bookDto;
		}
		
	}
}
