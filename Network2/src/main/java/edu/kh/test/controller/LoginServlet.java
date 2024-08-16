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

@WebServlet("/join")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



		
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");

		if (memberId.equals("user01") && memberPw.equals("pass01")) {
			req.setAttribute("message", memberId + "로그인 성공!");
			String path = "/WEB-INF/views/result.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			return;

		} else {

			HttpSession session  = req.getSession();
			session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다");
			resp.sendRedirect("/");

		}

	}
}

// 문제원인 1 : index.jsp 파일에 form 태그 요청 주소는 "/join" 으로 작성함
// 				하지만 servlet에 매핑 주소를 작성하는 어노테이션 값이 작성이 안되서 매핑 x

// 조치내용 1 : @webservlet () 을 추가한후 매개변수에 작성될 주소를 index.jsp에 작성된 주소로 수정하여 매핑
//              수정 후 -> @WebServlet("/join")

// 문제원인 2 : 제출된 파라미터를 얻어오는 매개변수의 값이 작성된 변수명과 맞지않음
//

// 조치내용 2 : 수정 전 -> String inputId = req.getParameter("inputId");
//  					   String inputPw = req.getParameter("inputPw");

//				수정 후 -> String memberId = req.getParameter("memberId");
//						   String memberPw = req.getParameter("memberPw");

// 문제원인 3 : Servlet에 오버라이딩되는 Http 요청 방식이 index.jsp form 태그에 작성된 요청방식과 맞지않음
//			

// 조치내용 3 :  http 요청 방식을 jsp와 동일하게 수정하였음
// 				 수정 전 -> doGet 
//				 수정 후 -> doPost

