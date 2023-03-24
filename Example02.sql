# Board 데이터베이스 생성
CREATE DATABASE PEED;
USE PEED;boarduserboard

# User 테이블 생성
CREATE TABLE User (
  id INT PRIMARY KEY AUTO_INCREMENT,	# 아이디 / 정수형태 / 기본키 / 자동 증가
  password VARCHAR(30) NOT NULL, 		# 패스워드 / 길이 30의 가변 문자열 / 필수 값
  name VARCHAR(50) NOT NULL,			# 이름 / 길이 50의 가변 문자열 / 필수 값
  telNumber VARCHAR(15) NOT NULL UNIQUE # 전화번호 / 길이 15의 가변 문자열 / 필수 값 / 중복 불가능
);

# Board 테이블 생성
# 게시물 번호 (boardNumber)가 존재하고 정수형태 및 자동 증가로 관리,
# 게시물 번호로 각 데이터를 구분
# 게시물 제목 (boardTitle)이 존재하고 길이 200의 가변 문자열 및 필수 값으로 관리
# 게시물 내용 (boardContent)이 존재하고 길이의 제한이 없는 문자열 및 필수 값으로 관리
# 게시물 작성일 (boardDate)이 존재하고 날짜 타입 및 필수 값으로 관리
# 게시물 작성자 (boardWriter)가 존재하고 정수 형태 및 필수 값으로 관리
CREATE TABLE Board (
  boardNumber INT AUTO_INCREMENT PRIMARY KEY,
  boardTitle VARCHAR(200) NOT NULL,
  boardContent TEXT NOT NULL,
  boardDate DATE NOT NULL,
  boardWriter INT NOT NULL
);

SELECT * FROM User;

# User 레코드를 삽입
# 아이디는 자동 값을 그대로 사용, 
# 비밀번호는 'P!ssw0rd', 이름 '고길동', 전화번호는 '010-4488-9944'인 데이터를 삽입

# -- 회원가입 할때 사용 --
INSERT INTO User(password, name, telNumber) VALUES ('P!ssw0rd', '고길동', '010-4488-9944');

# User 테이블에서 이름이 '고길동'인 레코드의 비밀번호를 'qwer1234!!'로 수정

# -- 각종 회원정보 수정 할때 사용 --
UPDATE User SET password = 'qwer1234!!' WHERE name = '고길동';

# User 테이블에서 id가 1인 레코드를 삭제

# ??
DELETE FROM User WHERE id = 1;

INSERT INTO Board(boardTitle, boardContent, boardDate, boardWriter)
VALUES ('안녕히가세요.', '안녕하세요. 반갑습니다. 안녕히가세요.', '2023-01-11', 3);

# 전체 게시물 보기
SELECT * FROM Board;

# 최신 글 순으로 보기
SELECT * FROM Board ORDER BY boardDate DESC;

# 오래된 글 순으로 보기
SELECT * FROM Board ORDER BY boardDate ASC;

# 10일 이내에 작성된 글 보기
SELECT * FROM Board WHERE boardDate >= '2023-01-08';

# 10일 이내에 작성된 글을 최신 순으로 보기
SELECT * FROM Board WHERE boardDate >= '2023-01-08' ORDER BY boardDate DESC;

# 작성자가 1 이면서 10일 이내에 작성된 글을 최신 순으로 보기
SELECT * FROM Board WHERE boardWriter = 1 AND boardDate >= '2023-01-08' ORDER BY boardDate DESC;

# 게시물 제목에 '안녕하세요'가 포함된 게시글 보기
SELECT * FROM Board WHERE boardTitle LIKE '%안녕하세요%';

# 게시물 내용에 '반갑습니다'가 포함된 게시글 보기
SELECT * FROM Board WHERE boardContent LIKE '%반갑습니다%';

# 게시물 제목 + 내용에 '안녕히가세요'가 포함된 게시글 보기
SELECT * FROM Board WHERE boardTitle Like '%안녕히가세요%' OR boardContent Like '%안녕히가세요%';

SELECT * FROM Board;

SELECT * FROM Board WHERE boardTitle Like '%%';

# Board 테이블에서 boardWriter가 1 이거나 2인 레코드에서 모든 컬럼 선택

# 1. OR 연산 사용
SELECT * FROM Board WHERE boardWriter = 1 OR boardWriter = 2;
# 2. IN 연산 사용
SELECT * FROM Board WHERE boardWriter IN (1, 2);

# Board 테이블에서 boardDate가 2023-01-03부터 2023-01-10까지 레코드에서 모든 컬럼을 선택
SELECT * FROM Board WHERE boardDate BETWEEN '2023-01-03' AND '2023-01-10';

# Board 테이블에서 작성 일자가 1월인 레코드에서 모든 컬럼을 선택

# 1. LIKE _ 연산 사용
SELECT * FROM Board WHERE boardDate LIKE '_____01___';
# 2. LIKE % 연산 사용
SELECT * FROM Board WHERE boardDate LIKE '%-01-%';
# 3. BETWEEN 연산 사용 (2월 사용 불가능)
SELECT * FROM Board WHERE boardDate BETWEEN '2023-01-01' AND '2023-01-31';

DROP TABLE BOARD;

CREATE TABLE Board (
	id INT AUTO_INCREMENT PRIMARY KEY,
    boardTitle VARCHAR(200) NOT NULL,
    boardContent TEXT NOT NULL,
    boardDateTime DATETIME NOT NULL,
    boardLike INT DEFAULT 0,
    boardWriter INT NOT NULL,
    
	CONSTRAINT Board_FK FOREIGN KEY (boardWriter)
    REFERENCES User (id)
);

SELECT * FROM User;

INSERT INTO User (password, name, telNumber) VALUES ('P!ssw0rd', 'John doe', '010-1111-4444');
INSERT INTO User (password, name, telNumber) VALUES ('qwer1234!!', 'Alies', '010-2222-8888');
INSERT INTO User (password, name, telNumber) VALUES ('qlalfqjsgh12#$', 'Brown', '010-3333-6666');

SELECT * FROM Board;

INSERT INTO Board (boardTitle, boardContent, boardDateTime, boardWriter)
VALUES ('HelloWorld!', 'Hello MySQL', now(), 2);
INSERT INTO Board (boardTitle, boardContent, boardDateTime, boardWriter)
VALUES ('HelloWorld!@', 'Hello MySQL@', now(), 2);


INSERT INTO Board (boardTitle, boardContent, boardDateTime, boardWriter)
VALUES ('Good Bye World!', 'Good Bye MySQL', now(), 3);

# 게시물을 작성한 경험이 있는 유저의 이름과 전화번호, 작성한 게시물 제목을 구하시오.
SELECT U.name, U.telNumber, B.boardTitle
FROM User AS U, Board AS B
WHERE U.id = B.boardWriter;

SELECT U.name, U.telNumber, B.boardTitle
FROM User AS U RIGHT JOIN Board AS B
ON U.id = B.boardWriter;

# 게시물을 작성한 경험이 있는 유저의 이름과 전화번호를 구하시오.
SELECT DISTINCT U.name, U.telNumber
FROM User AS U, Board AS B
WHERE U.id = B.boardWriter;

SELECT name, telNumber
FROM User
WHERE id IN (
	SELECT DISTINCT boardWriter
    FROM Board
);





