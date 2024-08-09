package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.CoffeDto;
import com.example.bookTest.control.service.CoffeService;



@Controller
public class CoffeControl {

	
	@Autowired
	private com.example.bookTest.control.service.CoffeService coffeService;
	
	@GetMapping("/coffe")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView("coffe/index");
		
		List<CoffeDto> list = coffeService.selectAll();
		mv.addObject("lists", list);
		
		return mv;
	}
	
	
	@GetMapping("/coffeReg")
	public String write(){
		return "coffe/coffeform";
	}
	
	@PostMapping("/coffeSave")
	public String menuSave(@ModelAttribute CoffeDto coffeDto) {
		coffeService.coffeSave(coffeDto);
		return "redirect:/coffe";
	}
	@GetMapping("/coffe/view")
	public ModelAndView view(@RequestParam(value="id",
			required=false, defaultValue="0")int id) {
		CoffeDto data=coffeService.getCoffe(id);
		
		if(data==null) data = new CoffeDto();
		
		return new ModelAndView("/coffe/view").addObject("coffe", data);
	}
	
	
	@GetMapping("/coffe/delete")
	public String bookRemove( @RequestParam("id") int del) {
		
		coffeService.remove(del);
		return "redirect:/";
	}
	
	

}