package com.movieAndgame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.MovieMember;

@Controller
@RequestMapping("/movie")
public class MovieController {

	// "/" 은  localhost/movie/index 매핑이다.
	@GetMapping("/index")
	public String Home(Model model) {
		
		return "movie/index";
	}
	
	@GetMapping("/login")
	public String loginHome(Model model) {
		
		model.addAttribute("member" , new MovieMember() );
		
		return "movie/member/login";
	}
	
	// 회원가입 페이지 제공 요청
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("movieMember", new MovieMember());
		return "movie/member/join";
	}
}