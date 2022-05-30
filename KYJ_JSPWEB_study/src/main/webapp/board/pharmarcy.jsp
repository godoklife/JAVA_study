<%@page import="java.time.LocalTime"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Calendar"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	
	<div class="container">
	
	<%
	// 공공데이터 포털
		// 1. URL 가져오기 [ URL : java.net 패키지 사용]
		URL url = new URL("https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=300&serviceKey=ArklluXbdFhZUrT2dakvMwq%2FrX32IsPZedNwTctPKWxDzvte1uYa3%2B6JxhOYt6nHVs5SUhQt5XZs8OhTrxiO7Q%3D%3D");
			// URL 클래스 : JAVA에서 HTTP URL을 객체화
			
		// 2. JAVA가 해당 URL 읽기 [바이트 스트림]
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
			// BufferedReader : 외부 데이터를 읽어올 때 사용되는 클래스.
		
		// 3. 읽어오기
		String result = bf.readLine();
			// 스트림에 존재하는 바이트열 모두 읽어와서 String에 저장하기.
		
		// 4. 읽어온 스트림을 JSON으로 변환하기
		JSONObject object = new JSONObject(result);
		
		// 5. JSON객체에서 특정 키에 해당하는 데이터 가져오기.
		JSONArray array =(JSONArray)object.get("data");	// Object형으로 리턴하므로 강제형변환 실행
//		JSONArray array = new JSONArray(object.get("data").toString());	// 윗 라인과 동일한 결과 반환
	
	%>
	<form action="pharmarcy.jsp">	<!--  주소 검색창 -->
		<input type="text" name = "keyword" placeholder="주소검색">
		<input type="submit" value="검색">
	</form>
	
	<!-- 카카오지도 표시 구역 -->
	<div id="map" style="width:100%;height:350px;"></div>




	
	
	
		<table class="table table-hover">
			<tr style="font-size:8px;">
				<th>약국명</th><th>대표전화</th><th>주소</th>
				<th>월요일 운영</th><th>화요일 운영</th><th>수요일 운영</th>
				<th>목요일 운영</th><th>금요일 운영</th><th>토요일 운영</th>
				<th>일요일 운영</th><th>공휴일 운영</th><th>데이터기준일자</th>
			</tr>
		
	
		<%
			
		// 현재 영업 여부 확인하기 [ 자바에서 요일 구하기 ]
		// 1. Calendar : 달력 클래스 [ 현재 날짜 / 시간 클래스 ]
		Calendar calendar = Calendar.getInstance();
		// 2. 요일 배열 선언
		String[] date = {"일","월","화","수","목","금","토"};
		// 2. 현재 요일 구하기
		String nowdate = date[calendar.get(Calendar.DAY_OF_WEEK)-1];
			// Calendar.DAY_OF_WEEK : 일요일이면 1 리턴. date에서 일요일 인덱스는 0, -1 처리
		
		// 현재 시간 구하기	
		int hour = calendar.get(Calendar.HOUR_OF_DAY);	// HOUR : 01시, HOUR_OF_DAY : 13시
		int minute = calendar.get(Calendar.MINUTE);	
		LocalTime nowtime = LocalTime.of(hour, minute, 0);	// 현재 시간, 분 저장
		
		
			// JSON 출력
			for(int i=0; i<array.length(); i++){
				JSONObject jo = array.getJSONObject(i);	// i번째 JSON객체
				// 만약 검색이 있을 경우
				String keyword=request.getParameter("keyword");
				if(keyword!=null){
					int index = jo.get("주소").toString().indexOf(keyword);
					if(index==-1){	// indexOf는 결과값이 없을 경우 -1를 리턴
						continue;	
							// 1. break : for문을 아예 꺼버림
							// 2. continue : for문을 1회만 재낌.
					}
				}
				// 영업 여부 판단
					// iterator : 인덱스가 없는 (set) 리스트를 순회하는 인터페이스
				/*	
				Iterator<JSONObject> iterator = jo.keys();
				
				while(iterator.hasNext()){	// hasNext() : 다음 객체가 있는지 boolean형으로 리턴
					String key = iterator.next().toString();
					if(key.equals(nowdate+"요일 운영")){
						System.out.println(nowdate+" : "+jo.get(key));	// 현재 요일과 동일한 키만 호출
						jo.put("영업여부", jo.get(key));	// i번째 json 객체에 새로운 엔트리 [엔트리?? 키 : 값 ] 추가
					}
				}
				*/
					// 무한루프 돎.
				
				// 1. JSONObject.getNames(json객체) : 해당 객체 내 모든 key 호출
				String[] keys = JSONObject.getNames(jo);
				
				// 2. 영업 여부를 저장하는 변수 선언
				String isopen="[영업종료]";
				
				// 3. 모든 key 반복문 돌리기
				for(String key : keys){
					// 4. 만약 해당 key가 현재 요일과 같으면서 -(영업시간없다) 가 아니면
					if(key.equals(nowdate+"요일 운영") && !jo.getString(key).equals("-")){
						String[] openingtime = jo.getString(key).split("~");
							// ~ 기준으로 문 여는시간, 닫는시간 구분
						
						if(Integer.parseInt(openingtime[1].split(":")[0])<=24){
							LocalTime opentime = LocalTime.of(
									Integer.parseInt(openingtime[0].split(":")[0]),
									Integer.parseInt(openingtime[0].split(":")[1]), 0);
							LocalTime closetime = LocalTime.of(
									Integer.parseInt(openingtime[1].split(":")[0]),
									Integer.parseInt(openingtime[1].split(":")[1]), 0);
						
						
							if(nowtime.isAfter(opentime)){	// 현재 시간이 여는시간보다 이후이면
								isopen = "영업중"+jo.getString(key);	// 5. 영업여부에 시간 넣어주기.
								// 닫는 시간
								if(nowtime.isAfter(closetime)){	 // 현재 시간이 닫는 시간보다 이후이면
									isopen = "[영업종료]";
								}
							}else{
								isopen = "[영업종료]";
							}
						}
					}
					jo.put("영업여부", isopen);
				}
		%>		
			<tr style="font-size:5px;" onclick="map('<%=jo.get("주소")%>' , '<%=jo.get("약국명")%>' , '<%=jo.get("영업여부")%>')">	<!--   인수값 사이에 띄워쓰기 해줘야함. -->
				<td><%=jo.get("약국명")%></td><td><%=jo.get("대표전화")%></td><td><%=jo.get("주소")%></td>
				<td><%=jo.get("월요일 운영")%></td><td><%=jo.get("화요일 운영")%></td><td><%=jo.get("수요일 운영")%></td>
				<td><%=jo.get("목요일 운영")%></td><td><%=jo.get("금요일 운영")%></td><td><%=jo.get("토요일 운영")%></td>
				<td><%=jo.get("일요일 운영")%></td><td><%=jo.get("공휴일 운영")%></td><td><%=jo.get("데이터기준일자")%></td>
			</tr>
		
		<%}%>
		</table>
	</div>
	
	
	<!-- services와 clusterer, drawing 라이브러리 불러오기 --> <!--  카카오 지도 API키, API키가 js보다상단에 위치해야함. -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f7357ce81adbf018af6a38f1c214342&libraries=services,clusterer,drawing"></script>
	<!--  카카오 지도 JS -->
	<script type="text/javascript" src="/KYJ_JSPWEB_study/js/kakaomap.js"></script>
	<%@include file="../footer.jsp"%>
</body>
</html>