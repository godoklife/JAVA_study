CREATE TABLE EMP( 
   EMPNO INT NOT NULL ,
   ENAME VARCHAR(10) ,  
   JOB   VARCHAR(9) ,   
   MGR INT  , 
   HIREDATE DATE ,
   SAL INT  ,
   COMM INT  ,
   DEPTNO INT 
);

INSERT INTO EMP VALUES(7839,'KING','PRESIDENT',NULL,'81-11-17',5000,NULL,10);
INSERT INTO EMP VALUES(7698,'BLAKE','MANAGER',7839,'81-05-01',2850,NULL,30);
INSERT INTO EMP VALUES(7782,'CLARK','MANAGER',7839,'81-05-09',2450,NULL,10);
INSERT INTO EMP VALUES(7566,'JONES','MANAGER',7839,'81-04-01',2975,NULL,20);
INSERT INTO EMP VALUES(7654,'MARTIN','SALESMAN',7698,'81-09-10',1250,1400,30);
INSERT INTO EMP VALUES(7499,'ALLEN','SALESMAN',7698,'81-02-11',1600,300,30);
INSERT INTO EMP VALUES(7844,'TURNER','SALESMAN',7698,'81-08-21',1500,0,30);
INSERT INTO EMP VALUES(7900,'JAMES','CLERK',7698,'81-12-11',950,NULL,30);
INSERT INTO EMP VALUES(7521,'WARD','SALESMAN',7698,'81-02-23',1250,500,30);
INSERT INTO EMP VALUES(7902,'FORD','ANALYST',7566,'81-12-11',3000,NULL,20);
INSERT INTO EMP VALUES(7369,'SMITH','CLERK',7902,'80-12-11',800,NULL,20);
INSERT INTO EMP VALUES(7788,'SCOTT','ANALYST',7566,'82-12-22',3000,NULL,20);
INSERT INTO EMP VALUES(7876,'ADAMS','CLERK',7788,'83-01-15',1100,NULL,20);
INSERT INTO EMP VALUES(7934,'MILLER','CLERK',7782,'82-01-11',1300,NULL,10);

select empno, ename sal from emp;
select * from emp;
select empno as 사원번호 from emp;
select distinct job as 직업 from emp;
select ename, sal from emp order by sal asc;
select DEPTNO, ename, sal from emp order by deptno asc, sal desc;
select empno, sal from emp order by empno asc, sal desc;
select ename from emp where sal>=3000;
select ename as 이름, sal as 급여 from emp from emp where sal >= 3000;
select ename, sal * 12 as 연봉 from emp where sal*12 > 36000;
select ename, hiredate from emp where hiredate = '81/11/17';
select ename, hiredate from emp where hiredate >= '81/11/17';
select * from emp where sal between 1000 and 3000; -- 아랫줄과 같음.
select * from emp where sal >= 1000 and sal <=3000;-- 윗줄 명령어와 같은 값 반환
select * from emp where sal not between 1000 and 3000;	-- 아랫줄 명령어와 같은 값 반환
select * from emp where sal <1000 or sal >3000;	-- 윗줄 명령어와 같은 값 반환

select * from emp where hiredate between '1982/01/01' and '1982/12/31';

select * from emp where job in ('salesman', 'analyst', 'manager');
select * from emp where job = 'salesman' or job='analyst' or job='manager';

select * from emp where job not in ('salesman', 'analyst', 'manager');
select * from emp where job != 'salesman' and job !='analyst' and job !='manager';

-- like : 문자 패턴 찾기
select * from emp where ename = 'scott';
select * from emp where ename like 'scott';
select * from emp where ename like 's%';	-- 이름이 s로 시작하는 사람 출력 ->> 스캇, 스미스 출력
select * from emp where ename like 's_';	-- 이름이 s하고 한글자 인 사람 출력 ->> 없음
select * from emp where ename like '%s%';	-- 이름 중간에 s자가 들어가는 사람 출력 ->> 존스, 아담스, 스캇, 스미스 출력
select * from emp where ename like '_s%'; 	-- 이름 '두번째' 글자가 S 들어가고 뒷자리는 상관 없는 사람 출력 ->> 없음

select * from emp where comm = null;	-- sql 에서는 null 비교연산자 사용 불가 ->> 에러는 안뜨나 아무것도 안나옴
select * from emp where comm is null;
select * from emp where comm is not null;

select upper(ename), lower(ename) from emp;
select * from emp where ename = 'scott';	-- mysql은 대소문자 구분 X, oracle은 대소문자 구분 O

-- dual : 임시 테이블 ->> 연산 결과만 임시로 확인할 수 있는 테이블 [ 저장 X ] 
select substr('대한민국만세',1,3) from dual;

select length('대한민국만세') from dual;
-- instr('문자열', '찾을문자') : 해당 문자열 내 찾을 문자의 인덱스 순서 번호 반환
select instr('대한민국만세','대') from dual;
-- trim('문자열') : 해당 문자열의 앞뒤 공백 제거
	-- rtrim('문자열') : 해당 문자열 오른쪽 공백 제거
    -- ltrim('문자열') : 해당 문자열 왼쪽 공백 제거
select trim(' 대              한                  민                    국         ') from dual;

-- substr('이메일', @위치[instr('이메일','@')
select substr('asdasd@naver.com', instr('asdasd@naver.com','@') ) from dual;

-- replace : 치환 [ 데이터 교체 ] 
select ename , replace(sal, 0, '*') from emp;