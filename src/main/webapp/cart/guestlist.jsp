<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<section>
<br>
<div align=center>
<h2>방명록</h2>
총:${totalcount}
<form>
<table border=1 width=650 height=350>
<tr>
<td>rownum</td> <td>rnum</td> <td>번호</td> <td>제목</td> <td>작성자</td> <td>등록일</td>
</tr>
<c:forEach var="b" items="${li}">
<tr>
<td>${b.rownum}</td>
<td>${b.rnum}</td>
<td>${b.idx}</td>
<td>${b.title}</td>
<td>${b.writer}</td>
<td><fmt:formatDate value="${b.datestr}" pattern="yyyy-MM-dd"/></td>
</tr>
</c:forEach>
</table>
</form>
</div>
<br>
</section>
<%@include file="/include/bottom.jsp" %>