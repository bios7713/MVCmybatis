<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
			uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function
</script>
<body>
<form action="goodsPaymentPro.gd" method="post" name="frm">
<table align="center" width="600" border="1">
<h1 align = "center" style="font-size: 50px" > 결제 화면</h1>
	<tr align="center" bgcolor="orange">
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
	</tr>
	<c:forEach var="cart" items="${cartList }" step="1" >
	<tr align="center" bgcolor="orange">
		<td><img src = "GoodsView/update/${cart.goodsImage }" width="30"/></td>
		<td>${cart.goodsName }</td>
		<td>${cart.goodsPrice }</td>
		<td>${cart.qty } </td>	
	</tr>	
	</c:forEach>
</table>
<table width = 600 align = "center" border = 1 >
 	<tr>
 		<td width = "200">구매자 이름</td>
 		<td width = "400"><input type = "text" name="userName" 
 			size = "12" maxlength="10" id="userId">		
 		</td>
 	</tr>
 
	<tr><td width = 200 >사용자 주소 </td>
		<td width = 400 >
			<input type="text" name="userAddr" 
				id = "userAddr" size = "30" maxlength="28"/>
		</td>
	</tr>
 	<tr><td width = 200 >사용자 이메일 </td>
		<td width = 400 >
			<input type="text" name="userEmail" 
				id = "userEmail" size = "30" maxlength="28"/>
		</td>
	</tr>
 	<tr><td width = 200 >사용자 연락처 </td>
		<td width = 400 >
			<input type="text" name="userPh" 
				id = "userPh" size = "30" maxlength="28"/>
		</td>
	</tr>
	<tr align="center">
		<td align="right" colspan="6">
		<font color ="red" size="6">총 결제금액 : ${totalMoney }</font>
		<font color ="black" size="5">원</font>
		</td>	
	</tr>
 	<tr>
 		<td  width = "200">카드번호</td>
 		<td width = 400 >
			<input type="text" name="cardNum" 
				id = "cardNum" size = "30" maxlength="28"/>
		</td>
 	</tr>
	<tr>
		<td colspan = 2>
			<input type= "submit" value="결제확인" />
			<input type= "reset" value="다시 입력" />
 		</td>
	</tr>
 </table>
<div> 
 	
		
</div>

	



</form>

</body>
</html>