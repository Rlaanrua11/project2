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
<td colspan=2 width=350px><div id="map" style="width:100%;height:370px;"></div>
<p><em>지도를 클릭해주세요!</em></p> 
<div id="clickLatlng"></div></td>
</tr>
<tr>
<td>번호</td><td><input type=text name=idx value="${m.idx}"></td>
</tr>
<tr>
<td>위치</td><td align=left><input type=text name=rdnmadr value="${m.rdnmadr}"></td>
</tr>
<tr>
<td>회사명</td><td><input type=text name=entrprsnm value="${m.entrprsnm}"></td>
</tr>
<tr>
<td>대표</td><td><input type=text name=rprsntvnm value="${m.rprsntvnm}"></td>
</tr>
<tr>
<td>사업</td><td><input type=text name=maingoods value="${m.maingoods}"></td>
</tr>

</table>
</form>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${key}"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(${m.latitude}, ${m.logitude}), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});
</script>
</div>
</section>
<%@include file="/include/bottom.jsp" %>