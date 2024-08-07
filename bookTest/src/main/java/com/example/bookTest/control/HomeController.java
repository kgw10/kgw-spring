package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.Dto.InfoDto;
import com.example.bookTest.Dto.BankDto;
import com.example.bookTest.Dto.BookDto;

@Controller
public class HomeController {

	// 요청 주소와 메서드를 매핑(연결) 시켜준다.
	@GetMapping("/home")
	public String homeView() {	// 뷰 페이지만 제공하는 경우에 페이지 이름만 넘긴다.
		
		
		return "home";
		
	}
	
	@GetMapping("/infoInput")
	public ModelAndView info(@ModelAttribute InfoDto infoDto) {
		// ModelAndView는 사용자에게 제공할 페이지와 데이터를 저장할 수 있는 클래스이다.
		// 사용자에게 제공할 페이지는 객체 생성시 입력 setViewName 메서드로 입력하면 된다.
		
		ModelAndView mv = new ModelAndView("info");
		// mv.setViewName("info") 메서드로 제공 페이지 입력
		
		String byear = infoDto.getUBirth().substring(0, 4);
		
		int age=45 - Integer.parseInt(byear);
		mv.addObject("ageData", age);	// 뷰 페이지에 전달할 데이터 설정
		
		return mv;
	}
//	
	@GetMapping("/write")
	public String view() {
		
		return "bookWrite";
	}
	
	@GetMapping("/detail")
	public ModelAndView boardwrite(@ModelAttribute BookDto dto) {
		ModelAndView mvv = new ModelAndView("bookWrite");
		mvv.setViewName("bookDetail");
		mvv.addObject("book", dto);
		
		
		
		return mvv;
		
	}
	
	@GetMapping("/input")
	public String banking() {
		
		return "bank";
	}
	
	
	@PostMapping("/result")
	public ModelAndView bankyou(@ModelAttribute BankDto dto) {
		ModelAndView re = new ModelAndView();
		re.setViewName("result");
		re.addObject("Bank", dto);
		
		return re;
	}
	
	
}


// 뷰 페이지
// bookWrite.jsp - 도서 정보 입력 페이지, 책 제목, 저자, 출판사 입력
// bookDetail.jsp - 도서 정보 출력 페이지 책 제목, 출판사 입력


// 요청 주소
// 		/write - GET (도서 정보 입력 페이지 제공)
//		/detail - GET (도서 정보 출력 페이지 제공)

// 동작 흐름 : 사용자가 localhost/write라고 브라우저에 입력하고 페이지에서 도서 정보를 입력 후 버튼을 클릭한다.
//		     다음에 제공되는 페이지에서는 사용자가 입력한 값이 출력되어야 한다.


// 동작 : 사용자가 localhost/input이라고 브라우저에 주소를 입력 브라우저에 보이는 페이지에서 은행명과 