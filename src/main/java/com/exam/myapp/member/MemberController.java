package com.exam.myapp.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/member/list.do")
	public String list(Model model) {
		List<MemberVo> list = memberService.selectMemberList();
		model.addAttribute("memberList", list);
		return "member/memList";

	}

	@GetMapping("/member/add.do")
	public String addform() {
		return "member/memAdd";
	}

	@PostMapping("/member/add.do")
	public String add(MemberVo vo) {
		int n = memberService.insertMember(vo);
		System.out.println(n + "명의 회원 추가");
		return "redirect:/member/list.do";
	}

	@GetMapping("/member/edit.do")
	public String editform(String memId, Model model) {
		MemberVo vo = memberService.selectMember(memId);
		model.addAttribute("mvo", vo);
		return "member/memEdit";
	}

	@PostMapping("/member/edit.do")
	public String edit(MemberVo vo) {
		int n = memberService.updateMember(vo);
		System.out.println(n + "명의 회원 변경");
		return "redirect:/member/list.do";

	}

	@GetMapping("/member/del.do")
	public String delete(String memId) {
		int n = memberService.deleteMember(memId);
		System.out.println(n + "명의 회원 삭제");
		return "redirect:/member/list.do";
	}

	@GetMapping("/member/login.do")
	public String loginform() {
		return "/member/login";
	}

	
	@PostMapping("/member/login.do")
	public String login(MemberVo vo, Model model, HttpSession session) {
		MemberVo mvo = memberService.selectLogin(vo);
		if (mvo == null) {
			return "redirect:/member/login.do";
		} else {
			session.setAttribute("loginUser", mvo);
			return "redirect:/member/list.do";
		}
	}

	
	@GetMapping("/member/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/login.do";
	}
}
