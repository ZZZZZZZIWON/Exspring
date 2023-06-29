package com.exam.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Map map, ModelMap modelMap ) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("a", formattedDate );
		map.put("b", formattedDate );
		modelMap.addAttribute("c", formattedDate );
		
		return "home";
	}

	@GetMapping("/test")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test( @RequestParam(value="x") String xv, int y, 
						MyVo v,
						@ModelAttribute("mv") MyVo vo, Model model) {
		
		logger.info("xv: {}, y: {}", xv, y);
		logger.info("vo.x: {}, vo.y: {}", vo.getX(), vo.getY());
		
		String s= "JSP에서 출력할 문자열";
		model.addAttribute("sv", s);
		
//		model.addAttribute("mv", vo);
		
		return "test";
	}
	
}
