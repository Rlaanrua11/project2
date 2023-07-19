<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@include file="/include/top.jsp" %>
<section>
<div align=center>
<h2>전기충전소목록</h2>
<br>
<form>
<table border=1>
<tr>
<td>번호</td>
<td>충전소명칭</td>
<td>주소</td>
<td>충전기명칭</td>
<td>충전기상태</td>
</tr>
<c:forEach  var="m" items="${li}">
<tr>
<td>${m.idx}</td>
<td>${m.csnm}</td>
<td>${m.addr}</td>
<td>${m.cpnm}</td>
<td>${m.cpstat}</td>
</tr>
</c:forEach>
</table>
</form>
<form action="${path}/evlist.do">
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