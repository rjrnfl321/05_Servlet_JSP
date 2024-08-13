package edu.kh.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import edu.kh.test.model.dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
/*
문제 원인 1 : jsp 파일은 webapp 폴더 기준으로 작성되어야하는데
	   servlet에 작성된 jsp의 경로가 webapp에 속해있지않고 주소가 맞지않아서
	   
조치 내용 1 : 기존 코드에서 jsp로 요청을 위임할 경로를 지정하였음
           	  String path = "success.jsp"; -> String path = "/WEB-INF/views/success.jsp";

*/

public class JoinServlet extends HttpServlet {

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Member> memberList = new ArrayList<Member>();

		memberList.add(new Member("test01", "1234", "김테스트"));

		memberList.add(new Member("test02", "5678", "최테스트"));

		memberList.add(new Member("test03", "qwer", "박테스트"));
		
		
//------------------------------------------------------------------------------------------------

/* 문제 원인 2 : 파라미터의 매개 변수의 값이 지정된 변수명과 맞지않아 오류가 발생
 * 				 
 * 
 * 조치 내용 2 : 카멜 표기법에 맞춰 매개 변수의 값을 지정된 변수명과 맞게 수정
 * 				 req.getParameter("Id"); -> req.getParameter("memberId");
 *  			 req.getParameter("Pw"); -> req.getParameter("memberPw");
 *  			 req.getParameter("Name"); -> req.getParameter("memberName");
 */
		String memberId = req.getParameter("memberId");

		String memberPw = req.getParameter("memberPw");

		String memberName = req.getParameter("memberName");

		for (Member member : memberList) {

			if (member.getMemberId().equals(memberId)) {

				HttpSession session = req.getSession();

				session.setAttribute("message", memberId + "은/는 이미 존재하는 아이디 입니다.");

				resp.sendRedirect("/");

				return;

			}

		}

		Member member = new Member(memberId, memberPw, memberName);

		memberList.add(member);

		String message = String.format(" %s / %s 님이 가입 되었습니다 (비밀번호 : %s)",
				memberId, memberName, memberPw);

		req.setAttribute("message", message);

		String path = "/WEB-INF/views/success.jsp";
		/* 문제 원인 3 : String path라는 변수에 저장된 "/success.jsp"; 파일이 어디 경로에 있고
		 * 			     어느 파일에 있는지 
		 *
		 */
		req.getRequestDispatcher(path).forward(req, resp);

		req.getSession().setAttribute("message", message);
		

	}

}