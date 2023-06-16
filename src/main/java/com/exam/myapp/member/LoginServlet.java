package com.exam.myapp.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {
	
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		MemberVo vo = new MemberVo(); 
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPass(req.getParameter("memPass"));
		
		MemberVo mvo = memberService.selectLogin(vo);
		
	
		if(mvo == null) { 
			resp.sendRedirect(req.getContextPath()+ "/member/login.do");
			
		} else { // 로그인 성공
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", mvo);

			resp.sendRedirect(req.getContextPath()+ "/member/list.do");
			
			
		}
		
	
	}
}
