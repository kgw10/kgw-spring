package com.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMemberDto;
import com.movieAndgame.Dto.GameReviewDto;
import com.movieAndgame.Dto.MovieMember;
import com.movieAndgame.Dto.MovieReviewDto;
import com.movieAndgame.service.GameReviewService;
import com.movieAndgame.service.MovieReviewService;

@Controller
@RequestMapping("/gameMenu")
public class GameMenuControl {
	
	@Autowired
	private GameReviewService reviewService;
	
	// 글 내용 작성 후 저장 요청
	@GetMapping("/write")
	public String reviewWrtie(@Valid GameReviewDto gameReviewDto, BindingResult bind, Model model) {
		
		if(bind.hasErrors()) {	// form 데이터 값이 유효하지 않다면
			return "game/review/write";
		}
		
		reviewService.save(gameReviewDto);
		return "redirect:/gameMenu/review";
	}
	
	
	@GetMapping("/review")
	public String reviewMain(Model model) {
		
		
		return "game/review/index";
	}
	
	// 리뷰 작성 페이지 요청
	@GetMapping("/reviewWrite")
	public String write(Model model, HttpSession session) {
		
		if(session.getAttribute("user") == null) {	// 로그인 상태가 아니면 로그인 페이지 이동
			return "redirect:/game/login";
		}
		
		GameReviewDto dto = new GameReviewDto();
		String name = ((GameMemberDto)session.getAttribute("user")).getNickName();
		dto.setWriter(name);
		
		model.addAttribute("gameReviewDto", dto);
		
		return "game/review/write";
	}
}
