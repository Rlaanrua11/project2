<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<section>
<br>
<div align=center>
<h2>주문목록</h2>
<form>
<table border=1 width=650 height=350>
<tr>
<td>idx</td> <td>custno</td> <td>배송비</td> <td>총금액</td>
</tr>
<c:forEach var="o" items="${li1}">
<tr>
 <td>${o.idx}</td>
 <td>${o.ocustno}</td>
 <td>${o.baesongbi}</td>
 <td>${o.totalmoney}</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<br>
</section>
<%@include file="/include/bottom.jsp" %>