<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@include file="/include/top.jsp" %>
<%@page import="com.anrua.a1.psd.*"%>
<section>
<div align=center>
<h2>회원매출조회</h2>
<br>
<form>
<table border=1>
<tr>
<td>회원번호</td>
<td>회원성명</td>
<td>고객등급</td>
<td>매출</td>
</tr>
<c:forEach  var="m" items="${li}">
<tr>
<td><a href="${path}/editshop.do?custno=${m.custno}">${m.custno}</a></td>
<td>${m.custname}</td>
<td>
<c:choose>
	<c:when test="${m.grade=='A'}">
		<c:out value="VIP"></c:out>
	</c:when>
	<c:when test="${m.grade=='B'}">
		<c:out value="일반"></c:out>
	</c:when>
	<c:when test="${m.grade=='C'}">
		<c:out value="직원"></c:out>
	</c:when>
</c:choose></td>
<td>${m.price}</td>
</tr>
</c:forEach>
</table>
</form>
<form action="${path}/getpsdlist.do">
<select name=ch1>
<option value="custno">번호</option>
<option value="custname">성명</option>
</select>
<input type=text name="ch2" size=10>
<input type=submit  value="검색">
</form>
</div>
</section>
<%@include file="/include/bottom.jsp" %>