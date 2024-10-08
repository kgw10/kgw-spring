package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.bookDto;

@Repository
public class BookDAO {
	
	private final JdbcTemplate jt;
	
	@Autowired
	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}
	
	// 도서 삭제
	public void delete(int bid) {
		String sql="delete from book where book_id=?";
		
		jt.update(sql, bid);
	}
	
	//도서 상세 정보 가져오기 - 1권에 대해서만 !!(book_id 컬럼으로 조회)
	//book_id 컬럼이 중복데이터를 가질 수 없는 유일값이기 때문에
	public bookDto findId(int id) {
		String sql="select * from book where book_id=?";
		
		//jt.queryForObject(쿼리문, mapper, ?에 넣어줄 값);
		
		bookDto data=jt.queryForObject(sql, 
				new RowMapper<bookDto>() {
					@Override
					public bookDto mapRow(ResultSet rs, int rowNum) throws SQLException{
						bookDto bookdto = new bookDto();
						bookdto.setBookAuthor(rs.getString("book_author"));
						bookdto.setBookCost(rs.getInt("book_cost"));
						bookdto.setBookPage(rs.getInt("book_page"));
						bookdto.setBookTitle(rs.getString("book_title"));
						bookdto.setPublisher(rs.getString("publisher"));
						bookdto.setBookId(rs.getInt("book_id"));
						return bookdto;
						
					}
		}
				, id);
		return data;
	}
	
	//book 테이블 전체 데이터 가져오기 - 첫화면에 목록으로 출력하기 위해
	public List<bookDto> select(){
		String sql="select *from book";
		List<bookDto>list=jt.query(sql, new BookDtoRowMapper());
		return list;
	}
	public void insert(bookDto bookDto) { // 도서정보 데이터베이스에 저장
		String sql="insert into book(book_title, book_author, "+
					"book_cost, book_page, publisher) values(?,?,?,?,?)";
		
		jt.update(sql, bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookCost(),
				bookDto.getBookPage(), bookDto.getPublisher());
		
	}
	
	public class BookDtoRowMapper implements RowMapper<bookDto>{

		@Override
		public bookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			bookDto bookdto = new bookDto();
			bookdto.setBookAuthor(rs.getString("book_author"));
			bookdto.setBookCost(rs.getInt("book_cost"));
			bookdto.setBookPage(rs.getInt("book_page"));
			bookdto.setBookTitle(rs.getString("book_title"));
			bookdto.setPublisher(rs.getString("publisher"));
			bookdto.setBookId(rs.getInt("book_id"));
			return bookdto;
			
		}
		
	}

	// 수정 도서의 정보를 데이터 베이스에 수정하여 저장하기
	public void update(bookDto bookdto) {
		
		String sql="update book set book_title=? , book_author=? , book_cost=? , book_page=? , publisher=?  where book_id=?" ;
		
		jt.update(sql, bookdto.getBookTitle(), bookdto.getBookAuthor(), bookdto.getBookCost(), bookdto.getBookPage(), bookdto.getPublisher(), bookdto.getBookId());
	}
}