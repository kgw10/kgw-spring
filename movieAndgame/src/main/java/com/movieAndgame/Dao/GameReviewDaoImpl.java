package com.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GameReviewDto;

@Mapper
public interface GameReviewDaoImpl {


	public void reviewSave(GameReviewDto gameReviewDto);
}
