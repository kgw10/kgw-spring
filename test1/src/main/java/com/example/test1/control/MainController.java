package com.example.test1.control;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.test1.dto.LoginDto;
import com.example.test1.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	// JSP MVC 패턴 주소 맵핑
	// 주소 패턴과 서블렛 클래스 연결(web.xml)
	// 주소 패턴이 다양하면 서블렛 클래스 갯수도 늘어난다.
	// 주소 요청을 처리할 메서드 지정을 위해 Map, properties 같은 주소와 메서드를 1 : 1 지정하여 처리하기 위한 객체 또는 파일이 필요하다.
	// 어떤 주소 요청인지 파악하기 위한 코드와 실행 코드도 작성해야 한다.
	
	// 스프링에서의 주소 맵핑( 요청 주소와 처리 내용을 연결하는 작업)
	// @Controller 클래스에 지정
	// 요청 방식에 따른 주소 맵핑 -> @GetMapping("/");
	// 요청 주소 처리할 메서드 정의와 반환 값으로 보여줄 페이지 이름
	
	
	@GetMapping("/test")
	public String testFirst() {
		return "test";
	}
	
	
//	@GetMapping("/aaa.g")
//	public String testTwo() {
//		return "login";
//	}
	
	// 주소 요청 : /signUp
	// 뷰 페이지 : member/signUp.jsp
	// 뷰 페이지 내용 : 아이디, 비밀번호, 연락처, 생년월일 입력
	// 
	
	@GetMapping("/signUp")
	public String sign() {
		return "member/signUp";
	}

	// form 데이터 받아오는 방법 3. - 두 번째 방법에 비해 범용성은 있지만 데이터 베이스 사용하기에 애매함.
	@PostMapping("/signUp")
	public String signUpSave(@RequestParam Map<String, String> pm) {
		
		System.out.println("세번째 방법 : " + pm.get("id"));
		
		return "member/signUp";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
    public String loginshow (@ModelAttribute LoginDto logindto) {
		
		System.out.println(logindto.getUserId());
	        
		return "loginResult";
	}
	
	@GetMapping("/")
	public ModelAndView home() {
		String title="뭔가 뭘 까먹었는지 왜 이렇게 불안하냐";
		ModelAndView mv = new ModelAndView("index");	// ModelAndView 객체 생성하면서 뷰 페이지 입력
		mv.addObject("pageTitle", title);
		return mv;
	}
	 
	
	
	
//	// form 데이터 받아오는 방법 2 - 데이터 베이스 사용에 용이
//	
//	@PostMapping("/signUp")
//	public String signUpSave(@ModelAttribute MemberDTO memberdto ) {
//		
//		
//		System.out.println("두번째 방법 : " + memberdto.getId());
//		
//		return "member/signUp";
//	}
	
//	form 1.
//	@PostMapping("/signUp")
//	public String singUpSave(@RequestParam("id") String id, @RequestParam("pw") String pw, 
//	@RequestParam("tel") String tel, @RequestParam("birth") 
//	String birth) {
//
//		
//		System.out.println(id);
//		
//		return "member/signUp";
//	}
	
}

// 자바빈 : 1. 클래스의 인스턴스 변수는 input의 name과 일치시켜 준다.
//		  2. 클래스의 기본 생성자 메서드가 필요하다.
//		  3. 인스턴스 변수의 get, set 메서드
//		  4. 인스턴스 변수의 제어자는 private

// form 데이터 받아오기 실습
// 내용 : 로그인을 위해 로그인 페이지에서 아이디와 비밀번호를 입력하고 로그인 버튼을 클릭한다.
// DTO 클래스 : LoginDto
// 뷰 페이지 : login.jsp - 로그인 form 페이지
//			loginResult.jsp - 로그인 후 보여줄 페이지
// 			loginResult.jsp에 <a href="/test"> 페이지 이동 </a> 넣기

// 요청 주소 및 방식 : 로그인 페이지 - GET 방식, /login
//					로그인 처리 - POST방식, /login

