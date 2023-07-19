<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<section>
<br>
<div align=center>
<h2>쇼핑몰 상품목록</h2>
<form name=f1 action="${path}/productedit.do" method="post" enctype="multipart/form-data" >
<table border=1 width=650 height=350>
<tr>
<td>번호</td> <td>상품이름</td> <td>상품가격</td> <td>상품사진</td> <td>등록일</td>
</tr>
<c:forEach var="m" items="${li}">
<tr>
<td>${m.pid}</td>
<td><a href="${path}/productedit.do?pid=${m.pid}">${m.pname}</a></td>
<td>${m.pprice}</td>
<td><img src="${path}/product/files/${m.pimgstr}" width=60px height=60px></td>
<td>${m.pdate}</td>
</tr>
</c:forEach>
</table>
</form>
</div>
<br>
</section>
<%@include file="/include/bottom.jsp" %>