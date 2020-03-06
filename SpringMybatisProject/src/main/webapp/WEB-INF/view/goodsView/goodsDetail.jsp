<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript">
$(function(){
	   $("#wishBtn").click(function(){
	      $.ajax({
	         type:"POST",
	         url: "goodsWishAdd",
	         data: "num=${goods.goodsSeq}",
	         datatype: "html",
	         success:wish_ok,
	         error: function(){
	            alert('서버오류 입니다. 잠시후 다시해주세요');
	            return;
	         }
	      });      
	   }); 
	   $("#cartBtn").click(function(){
		      $.ajax({
		         type:"POST",
		         url: "goodsCartAdd",
		         data: "num=${goods.goodsSeq}",
		         datatype: "html",
		         success:cart_ok,
		         error: function(){
		            alert('로그인하세염');
		            location.href="../main";
		            return;
		         }
		      });      
		 });  
});
function wish_ok(responseText, statusText, xhr, $form) {  
	   if(statusText=="success"){
	      var i = responseText.trim();
	      if( i == "1"){
	         alert('카트에 등록되었습니다.')
	      }else{
	         alert('카트에서 삭제 되었습니다.')
	      }
	   }   
	}
function cart_ok(responseText, statusText, xhr, $form) {		   
		   if(statusText=="success"){
		      if(confirm("등록하쉴?")){
		     location.href="goodsCartList";
		      }
		   }   
}
	

</script>
</head>
<body>
<table align="center" width="600" border="1">
	<tr bgcolor="orange">
	
		<td align="right">	
		<button id="wishBtn">관심상품</button>	
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button id="cartBtn">장바구니</button>
	</tr>
</table>

<table align="center" width="600"  >
	<tr>
		<td rowspan="4">
		<c:forTokens items="${goods.goodsImage }" delims="-" var="goodsImage"
					varStatus="ii">
			<c:if test="${ ii.index == 0}">		
		<img src="../goodsView/update/${goodsImage }"/>
				</c:if>
		</c:forTokens>
		</td>
		
		<td>상품명 : ${goods.goodsName }</td>
	</tr>
	<tr>
	 <td>가격: ${goods.goodsPrice }</td>
	</tr>
	<tr>
	 <td>수량: ${goods.goodsQty }</td>
	</tr>
	<tr>
	 <td>상품 설명: ${goods.goodsContent } <br/>
	 
	 <td rowspan="4">
		<c:forTokens items="${goods.goodsImage }" delims="-" var="goodsImage"
					varStatus="ii">
			<c:if test="${ ii.index > 0}">		
		<img src="../goodsView/update/${goodsImage }"/>
				</c:if>
		</c:forTokens>
		</td>
	 
	 
	 </td>
	</tr>
    <tr><td colspan="2" align="center">
    		<a href="goodsList.gd">목록보기</a> 
    		<a href=
    		"goodsDelete?num=${goods.goodsSeq }&image=${goods.goodsImage }">
    		상품 삭제</a> 
    		<a href="goodsModify?num=${goods.goodsSeq }">상품 수정</a>
    		
    	</td>
    </tr>
</table>
</body>
</html>