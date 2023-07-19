<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<c:set var="path" value="${pageContext.request.contextPath}" scope="session" />
<c:set var="key" value="7f4ed9cc0614eebec384ec243a373444" scope="session" />

<!DOCTYPE html>
<html>
<style>
header{
   background-color:blue;
   height:75px;
   line-height:75px;
   text-align:center;
   font-size:30px;
   color:#ffffff;
}
nav{
   background-color:#6699ff;
   height:50px;
   line-height:50px;
   text-align:left;
   font-size:16px;
   font-color:white;
}
section{
 text-align:left;
 min-height:600px;
 text-align:left;
 background-color:#D8D8D8;
}

footer{
 background-color:#0044ff;
 text-align:center;
 height:60px;
 font-size:12px; color:#ffffff;
 line-height:20px;
}
td{
text-align:center;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>쇼핑몰 회원관리ver1.0</header>

<nav>
&ensp;&ensp;
<c:if test="${uer}">
<a href="${path}/evlist.do">전기차충전소목록</a>&ensp;&ensp;&ensp;
<a href="${path}/evlistmap.do">전기차map</a>&ensp;&ensp;&ensp;
<a href="${path}/list.do">회사목록</a>&ensp;&ensp;&ensp;
<a href="${path}/companylistmap.do">회사map</a>&ensp;&ensp;&ensp;
</c:if>

<c:if test="${m.custname eq admin}">
<a href="${path}/product/productform.jsp">상품등록</a> &ensp;&ensp;
<a href="${path}/getpsdlist.do">회원정보조회/수정</a> &ensp;&ensp;
<a href="${path}/shoplist.do">회원매출조회</a>&ensp;&ensp;&ensp;
</c:if>

<a href="${path}/productlist.do">상품목록</a> &ensp;&ensp;
<c:if test="${m.custname eq null}">
<a href="${path}/shopform.do">쇼핑회원등록</a> &ensp;&ensp;
<a href="${path}/login/login.jsp">로그인</a> &ensp;&ensp;
</c:if>

<c:if test="${m.custname ne null}">
<a href="${path}/logout.do?custno=${m.custno}">${m.custname}님로그아웃</a> &ensp;&ensp;
<a href="${path}/cartlist.do?custno=${m.custno}">장바구니</a> &ensp;&ensp;
<a href="${path}/orderlist.do">주문목록</a> &ensp;&ensp;
</c:if>
<a href="${path}/guestlist.do">방명록</a> &ensp;&ensp;
<a href="${path}/guestinsert.do">방명록생성</a> &ensp;&ensp;
<a href="${path}/index.jsp">홈으로</a>
</nav>