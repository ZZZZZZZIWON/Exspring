package com.exam.myapp.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.exam.myapp.member.MemberVo;

public class LoginInterceptor implements HandlerInterceptor {

	// 컨트롤러 실행 전에 실행되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession(); // 요청 보낸 사용자의 세션을 가져옴
		MemberVo vo = (MemberVo) session.getAttribute("loginUser"); // 세션에서 로그인 정보를 꺼내옴
		if (vo == null) { // 로그인 정보가 없다면
			response.sendRedirect(request.getContextPath() + "/member/login.do"); // 로그인 페이지로 이동
			return false; // 컨트롤러 실행하지 않음
		}
		return true; // 컨트롤러 실행 ( 로그인 정보가 있음 )
	}

	// 컨트롤러 실행 후 + 뷰 ( JSP ) 실행 전에 실행되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	// 뷰 렌더링 ( JSP 실행 및 출력 ) 완료 후에 실행되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
