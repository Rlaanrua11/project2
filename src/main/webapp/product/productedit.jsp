<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<section>
<script>
function delk1(){
	alert("${p.pid}삭제");
	location.href="${path}/productdelelte.do?pid=${p.pid}";
}

function list1(){
	location.href="${path}/productlist.do";
}
</script>
<br>
<div align=center>
<h2>쇼핑몰 상품 상세보기</h2>
<form action="${path}/cartinsert.do">
<input type=hidden name=custno value="${m.custno}">

<table border=1 width=650 height=350>
<tr><td align="center">상품번호</td>  
   <td><input type=text name=pid value="${p.pid}" /> </td>
	<td rowspan=5 width=300px height=300px><img src="${path}/product/files/${p.pimgstr}" width=100% height=100%></td>
</tr> 
<tr><td align="center">상품이름</td>  
   <td><input type=text name=pname value="${p.pname}" /> </td></tr> 
<tr><td align="center">상품가격</td>  
   <td><input type=text name=pprice value="${p.pprice}"/> </td></tr>
<tr><td align="center">상품설명</td>  
   <td><textarea cols=30  rows=9 name=pdesc >${p.pdesc} </textarea> </td></tr>
<tr><td align="center">등록일</td>  
   <td><input type=text name=pdate value="${p.pdate}"/> </td></tr>
<tr><td align="center">구매수량</td>  
   <td colspan=2><input type=number name=amount value=amount min="1" max="5"   /> </td></tr>
<tr><td colspan=3  align="center"> 
    <input  type=button value="목록보기" onclick="list1()">
    <input  type=button value="삭제" onclick="delk1()">
     <input  type=submit value="상품구매">
   </td></tr>
</table>
</form>
</div>
<br>
</section>
<%@include file="/include/bottom.jsp" %>