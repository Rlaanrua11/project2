<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<script>
function delc(m1){
		alert(m1+"삭제");
		location.href="${path}/deleteonecart.do?cid="+m1+"&custno="+${m.custno};
}

function delall(m2){
	alert(m2+"장바구니비우기");
	location.href="${path}/deleteallcart.do?custno="+m2+"&custno="+${m.custno};
}
</script>
<section>
<br>
<div align=center>
<h2>장바구니목록</h2>
<form>
<table border=1 width=650 height=350>
<tr>
<td>장바구니번호</td> <td>상품번호</td> <td>상품이름</td> <td>단가</td> <td>구매수량</td> <td>상품사진</td> <td>삭제</td>
</tr>
<c:forEach var="m1" items="${li1}">
 <input  type=hidden  name=cid value="${m1.cid}" >
 <input  type=hidden  name=custno value="${m.custno}" >
 <input  type=hidden  name=pid value="${m1.pid}" >
 <input  type=hidden  name=pname value="${m1.pname}" >
<tr>
<c:if test="${m1.pname eq null}">
<td colspan=6><a href="${path}/productlist.do">구매 물건이 없습니다(상품목록으로이동)</a></td>
</c:if>
<td>${m1.cid}</td>
<td>${m1.pid}</td>
<td>${m1.pname}</td>
<td><fmt:formatNumber value="${m1.pprice}" pattern="#,###"/> </td>
<td><input type=number name=amount value="${m1.amount}" min="1" max="5"></td>
<td><img src="${path}/product/files/${m1.pimgstr}" width=60px height=60px></td>
<td><input type=button value="삭제" onClick="delc(${m1.cid})"></td>
</tr>
 <c:set var="sum"  value='${m1.pprice*m1.amount}' > </c:set> 
 <c:set var="total"  value='${total+sum}' > </c:set>
</c:forEach>

<tr> 
 <td colspan=6 align="left" >
 <c:if test="${total >= 30000}">
 배송비 : 0 <c:set var="baesongbi" value="0" /> <br/>
 장바구니 금액합계: 
 <fmt:formatNumber value="${total}" pattern="#,###"/> 
 </c:if>
 <c:if test="${total < 30000}">
 배송비 : 3000 <c:set var="baesongbi" value="3000" /> <br/>
 장바구니 금액합계: 
 <fmt:formatNumber value="${total+3000}" pattern="#,###"/> 
  </c:if>
 </td>
</tr>

<tr><td colspan=7>
<input  type=hidden  name=baesongbi value='${baesongbi}' />
<input  type=hidden  name=totalmoney value='${total}' />
<input type=submit value="주문하기" onclick="javaScript:action='${path}/order.do'" />&emsp;
<input type=submit value="수정하기" onclick="javaScript:action='${path}/cartupdate.do'"/>&emsp;
<input type=button value="비우기" onClick="delall(${m.custno})">
</td></tr>
</table>
</form>
</div>
<br>
</section>
<%@include file="/include/bottom.jsp" %>