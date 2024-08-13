package edu.kh.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.member.dto.Member;
import edu.kh.member.service.MemberService;
import edu.kh.member.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/selectList")
public class SelectListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MemberService service = new MemberServiceImpl();
			/* MemberServiceImpl 객체를 새로 생성하고 MemberService 타입의 service 변수에 저장 */
			
			List<Member> memberList = service.getMemberList();
			/* service 객체의 getMemberList() 라는 메서드를 호출하여 Member 객체 목록을
			 * memberList라는 변수에 저장함*/

			req.setAttribute("memberList", memberList);
			
			// "memberList" = 속성의 이름을 지정하는 문자열
			//  memberList  = servlet에서 설정할 값 ( 보통 리스트나 객체를 포함) 
			
			String path = "/WEB-INF/views/selectList.jsp";
			
			
			req.getRequestDispatcher(path).forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}