package com.exam.myapp.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController  {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/member/list.do")
	public String list(Model model) {

		List<MemberVo> list = memberService.selectMemberList(); 

		model.addAttribute("memberList", list);
		
		return "member/memList";

	}
}
