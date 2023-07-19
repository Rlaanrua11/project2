<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@include file="/include/top.jsp" %>
<section>
<div align=center>
<h2>회원매출조회</h2>
<br>
<form>
<table border=1>
<tr>
<td>번호</td>
<td>위치</td>
<td>회사명</td>
<td>대표</td>
<td>사업</td>
<td>위도</td>
<td>경도</td>
</tr>
<c:forEach  var="m" items="${li}">
<tr>
<td><a href="${path}/edit.do?idx=${m.idx}">${m.idx}</a></td>
<td>${m.rdnmadr}</td>
<td>${m.entrprsnm}</td>
<td>${m.rprsntvnm}</td>
<td>${m.maingoods}</td>
<td>${m.logitude}</td>
<td>${m.latitude}</td>
</tr>
</c:forEach>
</table>
</form>
<form action="${path}/getpsdlist.do">
<select name=ch1>
<option value="idx">번호</option>
<option value="entrprsnm">이름</option>
</select>
<input type=text name="ch2" size=10>
<input type=submit  value="검색">
</form>
</div>
</section>
<%@include file="/include/bottom.jsp" %>