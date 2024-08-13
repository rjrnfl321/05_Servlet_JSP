<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 관리 프로그램</title>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
  <div class="container">
    <h1>회원 관리 프로그램</h1>
    <div class="menu">
      <div class="menu-item"><a href="/signUp">회원 가입(추가)</a></div>
      
      	<!-- 클라이언트가 회원가입을 요청할 때 index.jsp는 "/signUp"에 해당 서버로 요청을 보냄
      		 요청을 받은 서버는 Http 요청 방식에 따라 get / post인지 확인하고 해당하는 방식에 따라서
      		 내부 코드 실행합니다. 다시 "/signUp.JSP"로 재요청을 보내고 그걸 클라이언트에게 안내 
      	-->
      		 
      <div class="menu-item"><a href="/selectList">회원 전체 조회</a></div>
      
        <!-- 클라이언트가 회원전체조회를 요청할 떄 index.jsp는 "/selectList" 해당 서버로 요청을 보냄
        	 요청을 받은 서버는 Http 요청 방식에 따라 get / post인지 확인하고 해당하는 방식에 따라서
        	 내부 코드를 실행합니다. 다시 "/selectList.jsp"로 재요청을 보내고 그걸 클라이언트에게 안내
         -->
    </div>
  </div>

  <c:if test="${not empty sessionScope.message}" >
    <script>
      alert( "${message}" );    
    </script>
    <c:remove var="message" scope="session" />
  </c:if>
</body>
</html>