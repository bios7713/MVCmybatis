<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>                                <!--  문자형태의 방식은 get으로 날릴수있다 다만 256바이트의 제한이있음. -->
                                            <!--  파일의 크기는 256바이트 보다 넘는다. -->
                                            <!--  데이터크기제한으로 인해 GET방식은 되지않음 . -->
                                            <!--  그래서 파일 전송은 POST로 한다. -->
<form action="goodsPro" method="post" enctype="multipart/form-data" >
	<table border="1">
		<tr><td>상품번호</td>
			<td><input type="text" name="goodsNum" id="goodsNum" />
			</td>
		</tr>
		<tr><td>상품명</td>
			<td><input type="text" name="goodsName" id="goodsName" />
			</td>
		</tr>
		<tr><td>상품가격</td>
			<td><input type="text" name="goodsPrice" id="goodsPrice" />
			</td>
		</tr>
		<tr><td>입고수량</td>
			<td><input type="text" name="goodsQty" id="goodsQty" />
			</td>
		</tr>
		<tr><td>상품 설명</td>
			<td><textarea rows="13" cols="56" 
					name="goodsContent" id="goodsContent"></textarea>
			</td>
		</tr>
		<tr><td>상품 이미지</td>
			<td><input type="file" name="goodsImage" id="goodsImage" multiple="multiple" >
			</td>
		</tr>
		<tr>
			<td colspan=2>
				<input type="submit" value="상품등록" />
				<input type="reset" value="취소" />
				<input type="button" value="메인으로 이동" onclick="mainGo();"/>
			</td>
		</tr>
	</table>				
</form>
</body>
</html>