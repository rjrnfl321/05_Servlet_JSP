package edu.kh.member.controller;

import java.io.IOException;

import edu.kh.member.service.MemberService;
import edu.kh.member.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteMember")
public class DeleteMemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int index = Integer.parseInt(req.getParameter("index"));
			
			MemberService service = new MemberServiceImpl();
			// MemberServiceImpl(); 라는 새로운 객체 생성하고 MemberService 타입의 service 변수에 저장
			
			boolean result = service.deleteMember(index);
			// service 객체 deleteMember 메서드
			// (index)는 메서드에 전달되는 매개변수 * 삭제할 멤버를 식별함
			// service 객체의 deleteMember 메서드 호출 후 index번째 멤버 삭제
			// 성공시 result 변수는 true 값 / 실패시 false 값
			
			HttpSession session = req.getSession();
			
			String message = null;
			// String(문자열) message(변수명)의 초기값을 null로 지정
			
			if (result) // result의 결과가 true라면 if를 실행하고, false라면 else를 실행
				message = "탈퇴 되었습니다";
			else
				message = "탈퇴 실패";

			session.setAttribute("message", message);

			resp.sendRedirect("/selectList"); // 클라이언트의 브라우저를
											  // "/selectList" URL로 redirect
											  // 클라이언트는 요청을 새로운 URL로 보내고
											  // 서버는 해당 페이지 반환

			
		// 예외 처리 코드	
			
		} catch (Exception e) { // 프로그램이 예외로 인해 종료되지 않도록 함
			
			e.printStackTrace(); // 예외 발생 위치와 호출 경로를 출력하여
								 // 디버깅과 문제 해결에 도움을 줌
		}

	}

}