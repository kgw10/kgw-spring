package com.example.bookTest.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.BookDAO;
import com.example.bookTest.Dao.CoffeDao;
import com.example.bookTest.Dto.CoffeDto;
import com.example.bookTest.Dto.bookDto;

@Service
public class CoffeService {
	private final CoffeDao coffeDao;
	
	@Autowired
	public CoffeService(CoffeDao coffeDao) {
		this.coffeDao=coffeDao;
	}
	
	
	public void remove(int del) {
		coffeDao.delete(del);
	}
	
	public CoffeDto getCoffe(int id) {
		if(id != 0) {
			return coffeDao.findId(id);
		}
		return null;
	}
	public List<CoffeDto> selectAll(){
		return coffeDao.select();
	}
	
	//도서정보 저장
	public void coffeSave(CoffeDto coffeDto) {
		
		if(coffeDto != null) {
			//도서 코드가 이미 데이터베이스에 저장 되어있는지 확인 후 저장
			coffeDao.insert(coffeDto); // DAO 클래스의 insert메서드 실행해서 저장
		}
		
	}
}