package com.exam.ex.myapp.member_x;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/member/edit.do")
public class MemEditServlet extends HttpServlet {
	
//	private MemberService memberService = MemberServiceImpl.getInstance();
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String memId = req.getParameter("memId");
//		MemberVo vo = memberService.selectMember(memId);
//		req.setAttribute("mvo", vo);
//		
//		req.getRequestDispatcher("/WEB-INF/views/member/memEdit.jsp").forward(req, resp);
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//	
////		
//		MemberVo vo = new MemberVo(); // 파라미터의 갯수를 1개로 유지
//		vo.setMemId(req.getParameter("memId")); // 요청 파라미터값 읽어온 것을 저장
//		vo.setMemName(req.getParameter("memName")); // 요청 파라미터값 읽어온 것을 저장
//		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint"))); // 요청 파라미터값 읽어온 것을 저장
//						
//		
//		int n = memberService.updateMember(vo);
//		
//		System.out.println(n + "명의 회원 변경"); 
//				
//
//		resp.sendRedirect(req.getContextPath()+ "/member/list.do");
//		
//
//	}
}
