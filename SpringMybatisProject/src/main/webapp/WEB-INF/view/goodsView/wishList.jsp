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

번호&nbsp;&nbsp;&nbsp;상품명&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이미지&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
가격<br/>
 <c:forEach items="${wishList }" var="list"  >
      ${list.goodsNum }&nbsp;&nbsp;&nbsp;
    <a href="goodsDetail?num=${list.goodsSeq }" >${list.goodsName }</a>&nbsp;&nbsp;&nbsp;
    <c:forTokens items="${list.goodsImage }" delims="-" var="image" varStatus="ii" >
      	<c:if test="${ii.index == 0}">
      		<img src="../goodsView/update/${image }" width="100px" height="100px"  />     	 
      	</c:if>
    </c:forTokens>
      &nbsp;&nbsp;&nbsp;${list.goodsPrice }<br>
 </c:forEach>

 

</body>
</html>