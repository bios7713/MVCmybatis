<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 글번호 : ${replies.commentDTO.commentNo } <br/> 
 작성자 : ${replies.commentDTO.cuserId } 
 제목: ${replies.commentDTO.commentSubject }   <br/>
 내용:	${replies.commentDTO.commentContent }	<br/>
 작성일: ${replies.commentDTO.regDate }   <br/>
 <p>
  <form action = "replyInsert" method="post" >
  <input type="hidden" name="cuserId" value=" ${replies.commentDTO.cuserId }" />
  <input type="hidden" name="commentNo" value=" ${replies.commentDTO.commentNo }" />
  	댓글쓰기 :  <input type="text" name="replyContent" value="" > 
  	  <input type="submit" name="submit" value="댓글달기"/>
  	</p>			
  
  
</form>
------ 여기부터 댓글목록 ------
 <c:forEach items="${replies.replyList}" var = "reply" >
 번호: ${reply.replyNo } <br/>
 작성자: ${ reply.ruserId } <br/>
 내용: ${reply.replyContent } <br/>
 작성일: ${reply.regDate } <br/>
 <p></p>
 </c:forEach>
 
</body>
</html>