package list.book.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/search")
public class BookServlet extends HttpServlet {
	
		private List<String> bookList = null;

		public BookServlet (){ // 기본 생성자

			bookList = ArrayList<String>();

			bookList.add("");
			bookList.add("");
			bookList.add("");
			bookList.add("");
			bookList.add("");
			bookList.add("");
			bookList.add("");
		}


}
