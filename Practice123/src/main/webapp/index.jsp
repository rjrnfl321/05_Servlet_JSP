<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>연습하기 123</title>
</head>
<body>
	<h1>소설책 List</h1>
	<pre>
      * 나는 내일 어제의 너와 만난다
      
      * 용의자 x의 헌신
      
      * 삼국지
      
      * 너의 췌장을 먹고싶어
      
      * 불편한 편의점

      * 봉제인형 살인사건
    
    </pre>

	<hr>

	<pre>
    
     <h3> List에 같은 이름의 책이 있는지 확인하기</h3>
    
      - 책 이름을 입력 받아 GET 방식으로 요청하기

      - Servlet에 존재하는 책이 모인 List에서
        입력받은 책과 같은 책이 있는지 확인
    
      - 존재하는 경우
          -> "OOO은 X번째 인덱스에 존재합니다"
              문자열을 request scope 객체에 세팅하여
    
              /WEB-INF/views/result.jsp로 요청 위임하여 결과 출력
    
      - 존재하지 않는 경우
          -> "OOO은 존재하지 않습니다"
              문자열을 request scope 객체에 세팅하여
    
              /WEB-INF/views/result.jsp로 요청 위임하여 결과 출력
              
  </pre>

	<hr>

	<form action="/search" method="get">
		검색할 책을 입력 : <input type="text" name="inputBook">
		<button>검색</button>
	</form>

	<h2>${message}</h2>

	<c:if test="${not empty sessionScope.message}">
		<c:remove var="message" scope="session" />

	</c:if>







</body>
</html>