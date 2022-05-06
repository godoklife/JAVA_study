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