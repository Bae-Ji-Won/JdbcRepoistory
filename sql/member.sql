<!-- SQL문을 작성하기 전에 정상작동 하는지 확인하는 페이지 -->

SELECT * FROM member;

DROP TABLE member;

DELETE FROM member WHERE id = 2;

CREATE TABLE member
(
    id number(5) PRIMARY KEY,
    name varchar2(10)
);

CREATE TABLE member
(
    id NUMBER(5) GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR2(10),
    location VARCHAR2(30),
    menu VARCHAR2(10),
    price VARCHAR2(10),
    PRIMARY KEY (id)
);





