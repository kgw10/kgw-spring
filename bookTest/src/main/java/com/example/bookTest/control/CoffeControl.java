package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.BookClassDto;
import com.example.bookTest.Dto.CoffeDto;
import com.example.bookTest.control.service.CoffeService;

@Controller
public class CoffeControl {
	
	@Autowired
	private CoffeService coffeService;
	
	
	@GetMapping("/coffe")
	public ModelAndView setHome() {
		ModelAndView mv = new ModelAndView("coffe/index");
		
		List<CoffeDto> list = coffeService.selectAll();
		mv.addObject("list", list);
		
		
		
		
		return mv;
	}
	@GetMapping("/coffeReg")
	public ModelAndView write() {
		ModelAndView mv = new ModelAndView("coffe/coffeForm");
		mv.addObject("count", 5);
		return mv;
	}
	
	
	@PostMapping("/CoffeForm")
	public String write( @ModelAttribute CoffeDto coffeDto) {
		coffeService.coffeSave(coffeDto);
		
		return "redirect:/coffe";
	}
}
