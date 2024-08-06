package com.example.test1.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.test1.dto.BoardDto;
import com.example.test1.dto.LoginDto;


@Controller
public class BoardController {
	
	
	@GetMapping("/board")
	public ModelAndView boardHome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardList");
		
		return mav;
		
	}
	
	@GetMapping("/boardWrite")
	public String view() {
		
		return "board/write";
	}
	
	@PostMapping("/write")
	public ModelAndView boardwrite(@ModelAttribute BoardDto dto) {
		String title = dto.getTitle();
		String writer = dto.getWriter();
		String content = dto.getContent();
		String boardPw = dto.getBoardPw();
		ModelAndView mvv = new ModelAndView("view");
		mvv.setViewName("board/view");
		mvv.addObject("title", title);
		mvv.addObject("writer", writer);
		mvv.addObject("content", content);
		mvv.addObject("boardPw", boardPw);
		
		
		
		return mvv;
		
		
		
		
		
		
	}
	
}
