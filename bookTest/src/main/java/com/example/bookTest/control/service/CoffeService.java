package com.example.bookTest.control.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookTest.Dao.CoffeDao;
import com.example.bookTest.Dto.CoffeDto;


@Service
public class CoffeService {
	
	private final CoffeDao coffeDao;
	
	@Autowired
	public CoffeService(CoffeDao coffeDao) {
		this.coffeDao = coffeDao;
	}
	

	public List<CoffeDto> selectAll() {
		return coffeDao.select();
	}	
	
	public void coffeSave(CoffeDto coffeDto) {
		
		if(coffeDto != null) {
			coffeDao.insert(coffeDto);
		}
	}






}
