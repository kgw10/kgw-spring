package com.movieAndgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameMemberDao;
import com.movieAndgame.Dto.GameMemberDto;

@Service
public class GameMemberService {
	@Autowired
	private GameMemberDao gameMemberDao;
	
	public GameMemberDto login(GameMemberDto gameMemberDto) {
		
		return gameMemberDao.login(gameMemberDto);
	}
	
	public boolean joinSave(GameMemberDto gameMemberDto) {
		
		
		List<String> emailList = gameMemberDao.findAllEmail();
		
		if( emailList.contains( gameMemberDto.getEmail()) )
			return true;
		
		
		
		
		gameMemberDao.insert(gameMemberDto);
		
		
		return false;
	}
}