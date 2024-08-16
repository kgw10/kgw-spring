package com.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMemberDto;
import com.movieAndgame.Dto.MovieMember;
import com.movieAndgame.service.GameMemberService;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private GameMemberService gameMemberService;
	
	// localhost/game/index 매핑
	@GetMapping("/index")
	public String home(Model model) {
		
		return "game/index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("gameMember" , new GameMemberDto());		
		return "game/member/login";
	}
	
	//회원 가입 양식 페이지 요청
	@GetMapping("/signUp")
	public String signup(Model model) {
		model.addAttribute("gameMemberDto",new GameMemberDto());
		return "game/member/join";
	}
	
	@PostMapping("/signUp")
	public String signUp(@Valid GameMemberDto gameMemeberDto,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println("유효하지 않은값이 입력되었다.");
			
			return "game/member/join";
		}
		
		boolean isDup = gameMemberService.joinSave(gameMemeberDto);
		
		
		if( isDup ) {
			bindingResult.rejectValue("email", "error.email","이미 가입된 이메일입니다.");
			return "game/member/join";
		}
		
		return "redirect:/game/login";
		
	}

	
	@PostMapping("/signIn")
	public String signIn(GameMemberDto member, HttpSession session, Model model) {
		
		GameMemberDto user = gameMemberService.login(member);
		if(user == null) {
			model.addAttribute("member", member);
			model.addAttribute("lose", "<script> alert('이메일 또는 비밀번호가 잘못되었습니다.'); </script>");
			return "game/member/login";
		}
		session.setAttribute("user", user);
		
		return "redirect:/game/index";
	}
	
	
	
	@GetMapping("/logout")
	public String out(HttpSession session) {
		session.removeAttribute("user");
		return " redirect:/game/index";
	}
}