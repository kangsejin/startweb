package com.example.startweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {
	
	@Autowired
	TestService testService;

	//@RequestMapping("/")
	//public String index() {
		//return "Greetings from Spring Boot!";
	//}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@RequestMapping("test")
	public ModelAndView test() {
		
		System.out.println("test start......");
		
		ModelAndView mv = new ModelAndView();
		
		List<TestVo> testList = testService.selectTest();
		
		System.out.println("testList size : " + testList.size());
		for(int i=0 ; i < testList.size() ; i++) {
			TestVo vo = testList.get(i);
			System.out.println("name:"+vo.getName());
			System.out.println("age:"+vo.getAge());
			System.out.println("btd:"+vo.getBtd());
		}
		
		
		mv.setViewName("testView");
		mv.addObject("list", testList);
		mv.addObject("title", "Thymeleaf View HTML");
		
		
		
		return mv;
	}
	
	
	/**
	 * vue 를 적용한 Thymeleaf 화면
	 * @return
	 */
	@RequestMapping("vue")
	public ModelAndView vue() {
		
		System.out.println("test start......");
		
		ModelAndView mv = new ModelAndView();
		
		List<TestVo> testList = testService.selectTest();
		
		System.out.println("testList size : " + testList.size());
		for(int i=0 ; i < testList.size() ; i++) {
			TestVo vo = testList.get(i);
			System.out.println("name:"+vo.getName());
			System.out.println("age:"+vo.getAge());
			System.out.println("btd:"+vo.getBtd());
		}
		
		
		mv.setViewName("testViewByVue");
		mv.addObject("list", testList);
		mv.addObject("title", "Thymeleaf View HTML (Vue)");
		
		
		
		return mv;
	}

}
