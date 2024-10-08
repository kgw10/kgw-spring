package com.movieAndgame.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GamePostDao;
import com.movieAndgame.Dto.GamePostDto;

@Service
public class GamePostService {

	@Autowired
	private GamePostDao gamePostDaoImpl;
	
	public void write(@Valid GamePostDto gamePostDto) {
		gamePostDaoImpl.save(gamePostDto);
		
	}

}