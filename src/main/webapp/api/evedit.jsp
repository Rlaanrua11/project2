<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/include/top.jsp" />
<section>
<div align=center id="div1">
<h2>회사 상세보기</h2>
<br>
<form>
<table border=1>
<tr>
<td colspan=2 width=350px>
<div id="map" style="width:100%;height:350px;"></div>
</td>
</tr>
<tr>
<td>번호</td><td><input type=text name=idx value="${m.idx}"></td>
</tr>
<tr>
<td>충전소명칭</td><td align=left><input type=text name=csnm value="${m.csnm}"></td>
</tr>
<tr>
<td>주소</td><td><input type=text name=addr value="${m.addr}"></td>
</tr>
<tr>
<td>충전기명칭</td><td><input type=text name=cpnm value="${m.cpnm}"></td>
</tr>
<tr>
<td>충전기상태</td><td><input type=text name=cpstat value="${m.cpstat}"></td>
</tr>
</table>
</form>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${key}&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('${m.addr}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">${m.csnm}</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
</section>

<%@include file="/include/bottom.jsp" %>