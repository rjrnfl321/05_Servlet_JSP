package list.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class BookServlet extends HttpServlet {

	private List<String> bookList = null;

	public BookServlet (){ // 기본 생성자
		bookList = new ArrayList<String>();
		
			bookList.add("불편한 편의점");
			bookList.add("용의자 x의 헌신");
			bookList.add("가면산장 살인 사건");
			bookList.add("삼국지");
			bookList.add("너의 이름은");
			bookList.add("나는 내일 어제의 너와 만난다");
			bookList.add("고백");
			

			
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 제출된 파라미터 얻어오기
		String inputBook = req.getParameter("inputBook");
		
		
	}

}
