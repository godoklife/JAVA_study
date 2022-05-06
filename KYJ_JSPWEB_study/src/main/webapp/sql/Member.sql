create table jspweb.member(
	mno int primary key auto_increment,
    mid varchar(15),
    mpassword varchar(15),
    mphone varchar(15),
    memail varchar(50),
    maddress varchar(1000),
    mpoint int default 0,
    mdate date default (current_date())
)