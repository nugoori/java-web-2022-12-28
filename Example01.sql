# 첫번째 SQL 주석(한 줄 주석)
-- 두번쨰 SQL 주석(한 줄 주석) -- 주석은 '-'뒤에 반드시 띄어쓰기가 포함 되어야 함
/* 
세번째 SQL 주석 (여러 줄 주석) 
*/

# 데이터베이스( == java Project) 생성 쿼리 (CREATE DATABASE 데이터베이스 명;)
CREATE DATABASE HOTEL;
# 생성된 데이터베이스 목록 보기
SHOW DATABASES;
# 데이터베이스 선택 ( USE 데이터베이스 명;)
USE HOTEL;
# 테이블 생성 ( 
# CREATE TABLE 테이블명( 
# 필드명 필드타입 제약조건,
# ...
# );
CREATE TABLE Reservation(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    reservationDate DATE NOT NULL, -- 필수
    roomNumber INT
);
# 선택된 데이터베이스의 테이블 조회
SHOW TABLES;

# 테이블 수정
# - 컬럼 추가 : ALTER TABLE 테이블명 ADD 필드명 필드타입 [제약조건];

ALTER TABLE Reservation ADD telNumber VARCHAR(20);

# - 컬럼 삭제 : ALTER TABLE 테이블명 DROP 필드명;

ALTER TABLE Reservation DROP roomNumber;

# - 컬럼 수정 : ALTER TABLE 테이블명 MODIFY COLUMN 필드명 필드타입 [제약조건];

ALTER TABLE Reservation MODIFY COLUMN reservationDAte VARCHAR(20) NOT NULL;

# 테이블 삭제
# - DROP :( DROP TABLE 테이블명;) 테이블의 존재 자체를 삭제 (DDL)
 
DROP TABLE Reservation;

# - TRUNKATE (TRUNKATE TABLE 테이블명) : 해당 테이블을 생성 직후의 상태로 되돌림 (DDL)

INSERT INTO Reservation(name, reservationDate) VALUES ('홍길동', now());
SELECT * FROM Reservation;

TRUNCATE TABLE Reservation;

# - DELETE FROM ( DELETE FROM 테이블명;) : 레코드만 삭제 (DML)

DELETE FROM Reservation;

### DML ###

# INSERT : # - 데이터 삽입
#  ( INSERT INTO 테이블명(컬럼명1, 컬럼명2, ...) VALUES (값1, 값2, 값3, ...)
#  ( INSERT INTO 테이블명 VALUES (값1, 값2 ...); ) : 각 컬럼에 매칭되는 값을 순서대로 작성 해야 함

INSERT INTO Reservation(name, reservationDate, roomNumber) VALUES ('홍길동', '2023-01-17', 3140);
INSERT INTO Reservation VALUES (4, '이영희', '2022-10-11', 908);
# NOT NULL 조건으로 걸린 name 컬럼 값을 지정하지 않았기 때문에 삽입 에러가 발생
INSERT INTO Reservation (reservationDate, roomNumber) VALUES ('1999-02-10', 1004);
# NOT NULL로 정의된? 필드들은 java에서 실행할 때 검증을 해 줘야 함

# UPDATE (UPDATE 테이블명 SET 컬럼1 = 값1, ... [WHERE 컬럼 = 값])  []: 필요에 따라 넣으면 됨
# WHERE : 조건을 지정하는 키워드, 조건에 해당하는 레코드에만 명령을 실행
# - 데이터 수정

# IS NULL : WHERE 조건에서 해당 컬럼이 NULL인 레코드를 고를 때 사용 
UPDATE Reservation SET roomNumber = 502 WHERE roomNumber IS NULL;
UPDATE Reservation SET reservationDate = '2023-01-30' WHERE name = '김철수';
UPDATE Reservation SET roomNumber = 1001;

# 데이터 삭제
# - DELETE (DELETE FROM 테이블명 [WHERE 컬럼 = 값]

DELETE FROM Reservation WHERE id = 7;

INSERT INTO Reservation (name, reservationDate, roomNumber) VALUES ('고수', '2023-03-02', 904);
INSERT INTO Reservation (name, reservationDate) VALUES ('홍길동', '2023-09-07');
INSERT INTO Reservation VALUES (20, '고길동', '2023-03-02', 3414);

# 데이터 검색
# - SELECT
# SELECT 컬럼명1 [, 컬럼명2, ...] FROM 테이블명 [WHERE 조건];
# 지정한 테이블에서 선택한 컬럼을 검색할 때 사용

SELECT name FROM Reservation;
SELECT name, roomNumber FROM Reservation;
SELECT name, roomNumber FROM Reservation WHERE reservationDate = '2023-03-02';

# SELECT * 으로 모든 컬럼을 선택 할 수 있음
SELECT * FROM Reservation;
SELECT * FROM Reservation WHERE name = '홍길동';

# WHERE 문 뒤에 비교 연산자 및 논리 연산자로 조건을 추가하여 검색할 수 있음reservation
SELECT * FROM Reservation WHERE name = '홍길동' AND reservationDate < '2023-04-01';
SELECT * FROM Reservation WHERE name = '홍길동' OR reservationDate < '2023-04-01';
SELECT * FROM Reservation WHERE roomNumber IS NOT NULL;
SELECT * FROM Reservation WHERE roomNumber IS NULL;
SELECT * FROM Reservation WHERE name LIKE '%길동' AND roomNumber IS NOT NULL;

# 특정 컬럼의 중복 제거 : DISTINCT
SELECT DISTINCT name, roomNumber FROM Reservation;

# 특정 컬럼을 기준으로 정렬 : ORDER BY
# 옵션 - ASC : 오름차순, DESC : 내림차순
SELECT * FROM Reservation ORDER BY reservationDate;
SELECT * FROM Reservation ORDER BY reservationDate DESC;
SELECT * FROM Reservation ORDER BY reservationDate DESC, roomNumber DESC;
SELECT * FROM Reservation ORDER BY roomNumber DESC, reservationDate DESC; -- ~BY 뒤의 순서에 따라 우선순위가 정해짐

# 별칭 사용 AS
SELECT name AS eman, roomNumber FROM Reservation;
SELECT name, roomNumber FROM Reservation AS R; -- 테이블끼리 조인 할 떄

# MySQL 데이터 타입
# 문자열 타입 CHAR
# 고정 길이 문자열 / 길이로 지정할 수 있는 값의 범위 0 ~ 255
ALTER TABLE Reservation ADD note CHAR(4);

# DESCRIBE 테이블명 : 테이블의 정보를 볼 수 있음
DESCRIBE Reservation;

SELECT char_length(note) FROM Reservation WHERE name = '노트';

INSERT INTO Reservation (name, reservationDate, note) VALUES ('노트', NOW(), '');

# 비교 연산자
SELECT * FROM Reservation;

# 동등 비교 연산 ( = )
# 좌항이 우항과 같으면 1을 반환, 아니면 0을 반환
SELECT 1 = 1;

# Reservation 테이블에서 roomNumber가 1001인 레코드의 모든 컬럼을 선택
SELECT * FROM Reservation WHERE roomNumber = 1001;

# 다르다 연산자 ( != , <> )
# 좌항이 우항과 다르면 1을, 아니면 0을 반환함
SELECT 1 != 1, 1 <> 2;

# Reservation 테이블에서 roomNumber가 1001이 아닌 레코드의 모든 컬럼들 선택
SELECT * FROM Reservation WHERE roomNumber != 1001;

#  Great than, Greate Than Equal 연산 ( > , >= ) 
# 좌항이 우항보다 크면 1을 반환, 아니면 0을 반환
# 좌항이 우항보다 크거나 같으면 1을, 아니면 0을 반환
SELECT 1 > 1, 1 >= 1; 

# Reservation 테이블에서 reservationDate가 2023년 01월 01일 보다 크거나 같은 (이후의) 모든 컬럼을 선택
SELECT * FROM Reservation WHERE reservationDate >= '2023-01-01';

# Less than, Less than Equal 연산 ( < , <= )
# 좌항이 우항보다 작으면 1을, 아니면 0을 반환
# 좌항이 우항보다 작거나 같으면 1을, 아니면 0을 반환
SELECT 1 < 1, 1 <= 1;

# Reservation 테이블에서 reservationDate가 2023년 02-28일 보다 작거나 같은 (이전의) 모든 컬럼을 선택
SELECT * FROM Reservation WHERE reservationDate <= '2023-02-28';

# null 확인 연산 ( <=> )
# 좌항과 우항이 모두 null이면 1을, 아니면 0을 반환
SELECT null <=> 1, null <=> null;

# Reservation 테이블에서 roomNumber와 note가 모두 null인 레코드의 모든 컬럼을 선택
SELECT * FROM Reservation WHERE roomNumber <=> note;

# Equal 연산 ( IS )
# 좌항과 우항이 같으면 1, 다르면 0을 반환
# 우항이 TRUE, FALSE, UNKNOWN 일 때만 사용
SELECT FALSE IS TRUE;

# Not Equal 연산 ( IS NOT )
# 좌항이 우항과 다르면 1을, 다르면 0을 반환
# 우항이 TRUE, FALSE, UNKNOWN 일 때만 사용
SELECT FALSE IS NOT TRUE;

# NULL 비교 연산 ( IS NULL, IS NOT NULL )
# 좌항이 NULL이면 1을, 아니면 0을 반환
SELECT 1 IS NULL;

# Reservation 테이블에서 note 컬럼에 값이 없는 레코드의 모든 값을 선택
SELECT * FROM Reservation WHERE note IS NULL;

# 좌항이 NULL이 아니면 1을, 아니면 0을 반환
SELECT 1 IS NOT NULL;

# Reservation 테이블에서 roomNumber 컬럼에 값이 존재하는 레코드의 모든 값을 선택
SELECT * FROM Reservation WHERE roomNumber IS NOT NULL;

# 사잇값 비교 연산 ( BETWEEN a AND b, NOT BETWEEN a AND b )
# 좌항이 a보다 크거나 같으면서 b보다 작거나 같으면 1을, 아니면 0을 반환
# 좌항이 a보다 작거나 b보다 크면 1을, 아니면 0을 반환
SELECT 10 BETWEEN 5 AND 10, 10 NOT BETWEEN 3 AND 8;

# Reservation 테이블에서 reservationDate가 2023-01-01부터 2023-02-28까지인 레코드의 모든 컬럼을 선택
SELECT * FROM Reservation WHERE reservationDate BETWEEN '2023-01-01' AND '2023-02-28';

# IN 연산 ( IN, NOT IN )
# 좌항이 우항에 해당하는 배열 값 중 하나라도 같다면 1을, 아니면 0을 반환
# 좌항이 우항에 해당하는 배열 값이 포함되지 않았다면 1을, 아니면 0을 반환
SELECT 1 IN (1, 2, 3, 4, 5	), 10 NOT IN (1, 2, 3, 4, 5);

# Reservation 테이블에서 name이 '홍길동','고길동' 중 하나라도 해당되는 레코드의 모든 컬럼을 선택
SELECT * FROM Reservation WHERE name IN ('홍길동', '고길동');

# 논리 연산

# AND 연산 ( AND, && )
# 좌항과 우항이 모두 1이면 1을, 아니면 0을 반환
# 여기서 비교되는 1과 0은 비교 연산의 결과를 말함
SELECT 1 AND 0;

# Reservation 테이블에서 name이 '고길동'이면서 note컬럼에 값이 지정되어있지 않은 모든 컬럼 선택
SELECT * FROM Reservation WHERE name = '고길동' AND note IS NULL;
# Reservation 테이블에서 note컬럼에 값이 지정되지 않고 reservationDate가 '2023-01-01'부터 '2023-02-28'까지인 모든 레코드의 컬럼을 선택
SELECT * FROM Reservation
WHERE note IS NULL
AND (reservationDate BETWEEN '2023-01-01' AND '2023-02-28');

# OR 연산 ( OR , || )
# 좌항과 우항 중 하나라도 1이면 1을, 아니면 0을 반환
# 여기서 비교되는 1과 0은 비교 연산의 결과
SELECT 1 OR 0;

# Reservation 테이블 중 name이 '고수' 이거나 note값이 존재하는 레코드의 모든 컬럼을 선택
SELECT * FROM Reservation WHERE name = '고수' OR note IS NOT NULL;

# XOR 연산 ( XOR )
# 좌항과 우항이 모두 다르면 1을, 같으면 0을 반환
SELECT 1 XOR 0;

# AND 연산과 OR 연산에서의 주의점
# 실제로 구하고자 하는 값을 정확히 파악해야 함 (중의적으로 해석되는 부분을 주의해라. -> 소괄호를 잘 사용할 것) 

#EX) Reservation 테이블에서
#    name이 고길동 이면서 note값이 존재하지 않거나 roomNumber가 1000 이상인 레코드 중 모든 컬럼을 선택
SELECT * FROM Reservation WHERE (name = '고길동' AND note IS NULL) OR roomNumber > '1000'; -- AND 연산자가 우선순위가 높다
SELECT * FROM Reservation WHERE name = '고길동' OR (note IS NULL AND roomNumber > '1000');

# IFNULL(검사할 인수, null일 때 반환할 값) 
# 검사할 인수가 NULL이면 NULL일 때의 값을 반환
SELECT IFNULL(NULL, '값이 지정되지 않았습니다.');

# Reservation 테이블에서 모든 레코드 중 name과 roomNumber를 선택하는데 roomNumber가 null이면 '아직 방이 배정되지 않았습니다.'를 출력
SELECT name, IFNULL(roomNumber, 0) FROM Reservation;
 
# 패턴 매칭 ( % , _ )
# 데이터의 특정 패턴에 해당하는 데이터를 조건으로 사용하기 위한 용도
# LIKE 연산자를 사용

# Reservation 테이블에서 name 값 중 성씨가 '고'인 레코드에서 모든 컬럼을 선택
SELECT * FROM Reservation WHERE name LIKE '고%';
SELECT * FROM Reservation WHERE name LIKE '고_';
# % : 0개 이상의 문자를 대체 
# _ : 한개의 문자를 대체

SELECT * FROM Reservation WHERE name LIKE '%';
SELECT * FROM Reservation WHERE name LIKE '__';

# FOREIGN KEY : 해당 테이블이 외부 테이블을 참조 할 때 특정 컬럼을 외부 테이블의 컬럼 값으로 지정하는 키
# 참조의 기준

# CONSTRAINT [제약 조건명] FOREIGN KEY (해당 필드에서 참조 키로 지정할 컬럼)
# REFERENCES 참조 할 테이블명 (참조할 테이블의 기본 키 or UNIQUE KEY도 가능)

# 주의사항
# 1. 참조 할 테이블이 존재 해야 함
# 2. 참조 할 컬럼이 참조할 테이블의 기본 키이거나 후보 키여야 함

# [CONSTRAINT 제약조건명]은 생략 가능

CREATE TABLE Room(
	roomNumber INT PRIMARY KEY,
    roomSize INT NOT NULL,
    roomName VARCHAR(20) NOT NULL
);
SElECT * FROM Room;
CREATE TABLE Reservation2 (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
	reservationDate DATE NOT NULL,
    note TEXT,
    roomNumber INT,
 
	CONSTRAINT Reservation_RoomnNmber_FK
    FOREIGN KEY (roomNumber)
    REFERENCES Room(roomNumber)
); 
DROP TABLE Reservation2;

# 참조 제약 조건을 설정하면
# 참조하는 테이블에 해당 컬럼의 값이 존재해야 참조 할 수 있음
INSERT INTO Reservation(name, reservationDate, roomNumber)
VALUES ('김철수', '2023-01-24', 2902);

INSERT INTO Reservation2(name, reservationDate, roomNumber)
VALUES ('김철수', '2023-01-24', 2901);

INSERT INTO Room VALUES (2901, 28, 'VIP');

SELECT * FROM Reservation2;

DELETE FROM Room WHERE roomNumber = 2901;

# ON DELETE , ON UPDATE
# 참조 키로 지정된 필드에서 참조하는 데이터가 변경 되거나 삭제되었을 때 대처를 설정 할 수 있도록 함
CREATE TABLE Reservation3 (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    reservationDate DATE NOT NULL,
    note TEXT,
    roomNumber INT DEFAULT 2901,
   
    CONSTRAINT reservation3_FK FOREIGN KEY (roomNumber)
    REFERENCES Room(roomNumber)
	# CASCADE 옵션 : 참조하는 데이터가 변경되거나 삭제되면 참조 테이블에서도 함께 이루어짐
    # ON UPDATE CASCADE
    # ON DELETE CASCADE
    
    # SET NULL 옵션 : 참조하는 데이터가 변경되거나 삭제되면 참조 키가 설정된 필드의 데이터 값이 null로 변경
    # ON UPDATE SET NULL
	# ON DELETE SET NULL
    
    # NO ACTION 옵션 : 참조하는 데이터가 변경되거나 삭제되어도 아무 변화가 일어나지 않음 (워크스페이스에서 막혀있는 경우도 있음 : 무결성 제약 조건에 어긋남 > 잘 안쓰임)
    # MySQL에서는 RESTRICT와 동일
    # ON UPDATE NO ACTION
    # ON DELETE NO ACTION
    
    # SET DEFAULT 옵션 : 참조하는 데이터가 변경, 삭제 되면 기본 값으로 지정한 데이터로 변경됨 (잘 안쓰임)
    # InnoDB 에서는 지원안함
    # ON UPDATE SET DEFAULT
    # ON DELETE SET DEFAULT
    
    # RESTRICT 옵션 : 참조되는 데이터의 변경, 삭제가 불가능
    # 기본값
    # ON UPDATE SET RESTRICT
    # ON DELETE SET RESTRICT
);

DROP TABLE Reservation3;

INSERT INTO Room VALUES (2902, 28, 'VIP');
INSERT INTO Reservation3(name, reservationDate, roomNumber)
VALUES ('이영희', '2023-01-24', null);

UPDATE Reservation3 SET roomNumber = 2902 WHERE name = '김철수';

SELECT * FROM Reservation3;
SELECT * FROM Room;

UPDATE Room SET roomNumber = 2903 WHERE roomNumber = 2902;
DELETE FROM Room WHERE roomNumber = 2903;

# JOIN
# 여러 테이블을 조합하여 하나의 테이블로 표현하는 방법
# 일반적으로 SELECT 구문에 사용 됨

# INNER JOIN
# ON 절에 조건을 만족하는 데이터만 가져옴
# SELECT 컬럼명 FROM 테이블1 명 INNER JOIN 테이블2 명 ON 조인 조건 
SELECT * FROM Reservation3 INNER JOIN Room ON Reservation3.roomNumber = Room.roomNumber;
# MySQL 에서는 INNER JOIN 구문을 , 로 대체하고 ON을 WHERE로 대체해서 사용 가능
SELECT * FROM Reservation3, Room WHERE Reservation3.roomNumber = Room.roomNumber;

# FROM 절에 두 개 이상의 테이블을 사용할 때 Alias를 사용해서 별칭 부여 가능
SELECT * FROM Reservation3 AS rv, Room AS RM WHERE rv.roomNumber = RM.roomNumber;

# 두 테이블 이상을 FROM절에서 사용할 때는 컬럼명 앞에 어떤 테이블의 컬럼인지 직접 지정하는 것이 좋음
# 동일한 컬럼명이 각 테이블에 존재하면 쿼리는 어떤 테이블의 컬럼인지 구분하지 못함
SELECT RV.id, RV.name, RV.reservationDate, RV.note, RM.roomNumber, RM.roomSize, RM.roomName
FROM Reservation3 AS RV, Room AS RM WHERE RV.roomNumber = RM.roomNumber;

# LEFT JOIN
# 왼쪽테이블에 참조 키(꼭 참조 키일 필요는 없음)를 기준으로 조인 결과를 나열
# SELECT 컬럼명 FROM 테이블1 명 LEFT JOIN 테이블2 명 ON 조인 조건 [WHERE 조건]
SELECT * FROM Reservation3 AS RV LEFT JOIN Room AS RM ON RV.roomNumber = RM.roomNumber;

# RIGHT JOIN
# 오른쪽 테이블에 참조 키를 기준으로 조인 결과를 나열
# SELECT 컬럼명 FROM 테이블1 명 RIGHT JOIN 테이블2 명 ON 조인조건 [WHERE 조건]
SELECT * FROM Reservation3 AS RV RIGHT JOIN Room AS RM ON RV.roomNumber = RM.roomNumber;

# 서브 쿼리
# 테이블의 검색 결과를 조건으로 사용하거나 FROM절에서 새로운 테이블로 사용할 수 있도록 한 것

# WHERE 절에서 사용하는 방법
# SELECT 컬럼명 FROM 테이블1 명
# WHERE 컬럼명 = (SELECT 컬럼명 FROM 테이블2 명 WHERE 조건( 주의! : "=" 비교연산은 1:1 관계 > 두개 이상의 컬럼이나 조건이 오지 못함))
# 또는
# WHERE 컬러명 IN (SELECT 컬럼명(반드시 1개) FROM 테이블2 명 WHERE 조건)

SELECT * FROM Reservation3
WHERE roomNumber = (
	SELECT roomNumber
    FROM Room
    WHERE roomNumber = 2902
);

SELECT * FROM Reservation3
WHERE roomNumber IN (
	SELECT roomNUmber
    FROM Room
);

# FROM 절에서 사용하는 방법
# SELECT 컬럼명
# FROM (
# 	SELECT 컬럼명 FROM 테이블 WHERE 조건 (드물게 사용)
# ) 
# WHERE 조건;

# VIEW
# 미리 선언된 쿼리를 가상의 테이블로 만들어 보여주는 것
# CREATE VIEW 뷰이름 AS SELECT 쿼리
CREATE VIEW ReservationInfo AS
SELECT RV.id, RV.name, RV.reservationDate, RV.note, RM.roomNumber, RM.roomSize, RM.roomName
FROM Reservation3 AS RV, Room AS RM
WHERE RV.roomNumber = RM.roomNumber;

SELECT * FROM ReservationInfo WHERE name = '김철수';
SELECT * FROM (
	SELECT RV.id, RV.name, RV.reservationDate, RV.note, RM.roomNumber, RM.roomSize, RM.roomName
	FROM Reservation3 AS RV, Room AS RM
	WHERE RV.roomNumber = RM.roomNumber
) AS T
WHERE T.name = '김철수';

DROP VIEW ReservationInfo;
