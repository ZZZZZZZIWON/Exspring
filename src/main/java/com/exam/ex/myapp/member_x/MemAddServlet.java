package com.exam.ex.myapp.member_x;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.myapp.member.MemberVo;

//@WebServlet("/member/add.do")
public class MemAddServlet extends HttpServlet {

//	private MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/memAdd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		{
			MemberVo vo = new MemberVo(); // 파라미터의 갯수를 1개로 유지
			vo.setMemId(req.getParameter("memId")); // 요청 파라미터값 읽어온 것을 저장
			vo.setMemPass(req.getParameter("memPass")); // 요청 파라미터값 읽어온 것을 저장
			vo.setMemName(req.getParameter("memName")); // 요청 파라미터값 읽어온 것을 저장
			vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint"))); // 요청 파라미터값 읽어온 것을 저장

//			int n = memberService.insertMember(vo);

//			System.out.println(n + "명의 회원 추가"); // n 변수를 사용하는 코드가 있어야 return값으로 n을 반환할 수 있음

			resp.sendRedirect(req.getContextPath() + "/member/list.do");

		}

	}
}
