create table jspweb.category(
	cno int primary key auto_increment,	/* 카테고리 번호 */
    cname varchar(100) /* 카테고리 이름 */
);
create table `jspweb`.`product`(
	pno int primary key auto_increment,	/* 제품번호 */
    pname varchar(1000),	/* 제품명 */
    pprice int,	/* 제품가격 */
    pdiscount float,	/* 제품 할인율 */
    pactive int default 0,	/* 제품 상태(0 : 준비중, 1 : 판매중, 2 : 판매중지 등등) */
    pimg varchar(1000),	/* 제품 이미지 주소 */
    cno int,	/* 제품 카테고리 */
    foreign key(cno) references category(cno) on update cascade
    /* product의 cno필드(fk)가 category의 cno(pk)와 연결(=참조)한다. */
);
create table stock(
	sno int primary key auto_increment,	/* 재고 번호 */
    scolor varchar(100),	/* 재고 색상 */
    ssize varchar(100),	/* 재고 사이즈 */
    samount int,	/* 재고 수량 */
    ssfirstdate datetime default now(),		/* 최초 등록 날짜 */
    slastmoddate datetime default now() on update now(),	/* 마지막 수정 날짜 */
    /* on update now() : 레코드가 변경되면 자동으로 현재 날짜를 부여 */
    /* default : 값이 안들어왔을때 초기값 부여 */
    /* 즉, 값이 안들어와도 부여, 업데이트 되도 부여됨, */
    pno int,
    foreign key( pno ) references product(pno) on delete cascade
	/* on delete cascade : pk레코드가 삭제되면 fk레코드도 같이 삭제된다. */
);



create table porderdetail(
   orderdetailno int primary key auto_increment ,    /* 주문상세 번호 */
    orderdetailactive  int ,   /* 주문상세 상태 */
   sno int ,             /* 재고번호 */
    samount int ,          /* 수량 */ 
    totalprice   int ,       /* 총결제액 */
   orderno int ,           /* 주문번호 */ 
    foreign key( sno ) references stock( sno ) on update cascade , 
    foreign key( orderno ) references porder( orderno) on update cascade 
);
create table cart(
   cartno int primary key auto_increment ,    /* 카트 번호 */
    scolor varchar(100) , /* 색상 */
    sno int ,             /* 재고번호 */
    totalprice   int ,       /* 총결제액 */
    pno int ,            /* 제품번호 */
   mno int ,             /* 회원번호 */ 
    foreign key( sno ) references stock( sno ) on update cascade , 
    foreign key ( mno ) references member(mno) on update cascade 
);
create table porder(
   orderno    int primary key auto_increment ,    /* 주문 번호 */
    orderdate datetime default now() , /* 주문 날짜 */
    ordername varchar(20) , /* 받는사람 성명 */
    orderphone varchar(20) , /* 받는사람 연락처 */ 
    orderaddress varchar(100) , /* 받는사람 주소 */
    ordertotalpay int ,   /* 주문 총 결제액  */
    orderactive int ,   /* 주문 상태 */
    orderrequest varchar(100) ,   /* 주문 요청사항 */
    orderdeliverno int ,   /* 배송 번호  */
    mno int ,             /* 회원번호 */ 
    foreign key ( mno ) references member(mno) on update cascade 
);



