package com.example.bookTest.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.BookDAO;
import com.example.bookTest.Dto.bookDto;

@Service
public class BookService {
	private final BookDAO bookDao;
	
	@Autowired
	public BookService(BookDAO bookDAO) {
		this.bookDao=bookDAO;
	}
	
	// 도서 삭제
	public void remove(int bid) {
		bookDao.delete(bid);
	}
	
	
	//도서 상세 정보 가져오기 - id 파라미터 값 DAO 넘겨서 조회하고 결과 받아서 control에 넘기기
	public bookDto getBook(int id) {
		if(id!=0) {// id 파라미터 값이 존재한다면 DAO를 통해 조회
			return bookDao.findId(id);
		}
		return null;// id 파라미터 없이 /book/view 주소 요청 들어온다면 null값 반환
	}
	
	//도서정보 데이터베이스에서 가져와서 list에 저장되어 있는거 받아서
	//control에게 넘겨주기
	public List<bookDto> selectAll(){
		return bookDao.select();
	}
	
	//도서정보 저장
	public void bookSave(bookDto bookDto) {
		
		if(bookDto != null) {
			//도서 코드가 이미 데이터베이스에 저장 되어있는지 확인 후 저장
			bookDao.insert(bookDto); // DAO 클래스의 insert메서드 실행해서 저장
		}
		
	}

	public void update(bookDto bookdto) {
		
		bookDao.update(bookdto);
		
	}
}