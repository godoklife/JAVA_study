/* = [ 같다 ] : 모두 동일한 데이터 검색
/* like 연산자 : 데이터가 일부 포함된 것 검색
/* % 연산자 : 모든 문자 대응

// % : 문자열 길이 상관 X
// _ : 언더바 개수 만큼.
select * from board where btitle like '%검색어%'	// 중간에 검색어를 포함하는 결과 출력
select * from board where btitle like '%검색어'	// 다른내용이 들어가며 검색어로 끝나는 결과 출력
select * from board where btitle like '검색어%'	// 검색어로 시작하며 다른 내용이 들어간 결과 출력

select * from board where btitle like '%검색어__'	// 중간에 검색어를 포함하고 뒤에 두글자만 더 있는 결과 출력
