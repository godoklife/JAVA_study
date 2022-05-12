create table jspweb.board(
	bno int primary key auto_increment,
    btitle varchar(200) not null,
    bcontent longtext,
    mno int,
    bview int default 0,
    bdate datetime default now(),
    bfile varchar(255),
    foreign key(mno) references member(mno)
)

select * from board where btitle like '%검색어%'	// 중간에 검색어를 포함하는 결과 출력
select * from board where btitle like '%검색어'	// 다른내용이 들어가며 검색어로 끝나는 결과 출력
select * from board where btitle like '검색어%'	// 검색어로 시작하며 다른 내용이 들어간 결과 출력