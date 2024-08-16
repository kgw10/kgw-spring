package com.movieAndgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameReviewDaoImpl;
import com.movieAndgame.Dto.GameReviewDto;
import com.movieAndgame.Dto.MovieReviewDto;

@Service
public class GameReviewService {
	
	
	@Autowired
	private GameReviewDaoImpl gameReviewDao;
	
	public void save(GameReviewDto gameReviewDto) {
		gameReviewDao.reviewSave(gameReviewDto);
	}
}
