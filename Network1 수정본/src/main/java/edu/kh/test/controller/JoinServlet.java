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

public class JoinServlet extends HttpServlet {

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Member> memberList = new ArrayList<Member>();

		memberList.add(new Member("test01", "1234", "김테스트"));

		memberList.add(new Member("test02", "5678", "최테스트"));

		memberList.add(new Member("test03", "qwer", "박테스트"));
		
		
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

		req.getRequestDispatcher(path).forward(req, resp);

		req.getSession().setAttribute("message", message);
		

	}

}


//----------------------------------------------------------------------------------------------


/*
	문제 원인 1 : index.jsp 파일에 form 태그 요청 주소는 "/join" 으로 작성했으나
			  	  Servlet의 매핑 주소를 작성하는
			  	  @WebServlet 어노테이션의 값이 "/signup"으로 작성되어 매핑 X
			  
	조치 내용 1 : @WebServlet( ) 매개 변수로 작성된 주소를 "/join"으로 수정
			  	  수정 전 -> @WebServlet("/signup") 수정 후 -> @WebServlet("/join")
*/

//----------------------------------------------------------------------------------------------


/* 문제 원인 2 : 제출된 파라미터를 얻어오는 매개 변수의 값이 작성된 변수명과 맞지않아 오류가 발생
 * 				 
 * 
 * 조치 내용 2 : req.getParameter() 매개 변수의 값을 지정된 속성값과 동일하게 수정
 * 
 * 				 (수정 전)				    (수정 후)
 * 				 req.getParameter("Id"); -> req.getParameter("memberId");
 *  			 req.getParameter("Pw"); -> req.getParameter("memberPw");
 *  			 req.getParameter("Name"); -> req.getParameter("memberName");
 */

//----------------------------------------------------------------------------------------------

/* 문제 원인 3 : forward를 하는 JSP 경로를 작성할때
 * 				 JSP 파일 경로를 webapp 폴더부터 작성되지않아서 찾을수 없음
 * 
 * 조치 내용 3 : JSP 파일 경로를 webapp 폴더부터 작성하기
 * 				 수정 전 -> String path = "/success.jsp";
 *    			 수정 후 ->	String path = "/WEB-INF/views/success.jsp";
 *
 */

//----------------------------------------------------------------------------------------------
	
/* 문제 원인 4 : JoinServlet에서 request scope에 속성 추가 시
 * 				 key 값을 "message"로 작성 했으나
 * 				 EL에 작성된 key 값을 result로 다르게 작성됨
 * 
 * 조치 내용 4 : Servlet에서 request에 추가한 속성과 같은 key 값을 EL 구문에 작성
 * 				 수정 전 -> success.jsp 파일 h1 태그에 key 값 ${result}
 * 				 수정 후 -> success.jsp 파일 h1 태그에 key 값 ${message}
 * */

