-- 1. 개인 별 장바구니 정보 뺴오기
select * from cart where mno = 1;	-- 회원번호 2번의 장바구니 정보 싹 다 빼오기

-- 2. 장바구니 번호 별 제품 정보 뺴오기	( 색상, 사이즈가 알고 싶다!! )
select * from stock where sno=1;	-- 재고번호 33번의 정보 출력

-- 3. table 합치기 ->> 합집합 출렧
select * from cart join stock;

-- 4. 동일한 데이터의 table 합치기 ->> 교집합 출력
select * from cart inner join stock on sno = sno;	-- 필드명이 서로 동일한 경우 에러 발생.
select * from cart inner join stock on `cart`.`sno` = `stock`.`sno`;	-- 하단 쿼리문과 동일한 기능.
select * from cart A inner join stock B on A.sno = B.sno;	-- 상단 라인과 동일한 쿼리문임.

-- 5. 특정 회원의 장바구니 테이블과 재고 테이블의 합집합 출력
select * from cart a join stock b on a.sno = b.sno where mno = 1;

-- 6. 두 테이블에서 특정 필드만 골라서 표시
select asd.cartno 장바구니번호,
	asd.samount as 구매수량,
    asd.totalprice as 총가격,
    B.scolor as 색상,
    B.ssize as 용량,
    B.pno as 제품번호 from cart as asd join stock as B on asd.sno = B.sno where mno=1;