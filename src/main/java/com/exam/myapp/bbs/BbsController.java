package com.exam.myapp.bbs;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.exam.myapp.member.MemberVo;

@Controller
@RequestMapping("/bbs/")
public class BbsController {

	@Autowired
	private BbsService bbsService;

	@GetMapping("list.do")
	public String list(Model model) {
		List<BbsVo> list = bbsService.selectBbsList();
		model.addAttribute("bbsList", list);
		return "bbs/bbsList";
	}

	@GetMapping("add.do")
	public String addform() {
		return "bbs/bbsAdd";
	}

	@PostMapping("add.do")
	public String add(BbsVo vo, HttpSession session, @SessionAttribute("loginUser") MemberVo mvo) {
		
		vo.setBbsWriter(mvo.getMemId());
		
		int n = bbsService.insertBbs(vo);
		System.out.println(n + "개의 글 추가");
		return "redirect:/bbs/list.do";
	}

	@GetMapping("edit.do")
	public String editform(int bbsNo, Model model) {
		BbsVo vo = bbsService.selectBbs(bbsNo);
		model.addAttribute("bvo", vo);
		return "bbs/bbsEdit";
	}

	@PostMapping("edit.do")
	public String edit(BbsVo vo) {
		int n = bbsService.updateBbs(vo);
		System.out.println(n + "개의 게시글 수정");
		return "redirect:/bbs/list.do";

	}

	@GetMapping("del.do")
	public String delete(int bbsNo) {
		int n = bbsService.deleteBbs(bbsNo);
		System.out.println(n + "명의 회원 삭제");
		return "redirect: list.do";
	}

}
