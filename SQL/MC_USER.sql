
/* MC_USER */
CREATE TABLE MC_USER (
	user_no NUMBER(16) NOT NULL, /* 회원 번호 */
	user_id VARCHAR2(16 BYTE) NOT NULL, /* 회원 id */
	user_password VARCHAR2(16 BYTE) NOT NULL, /* 회원 pw */
	user_div NUMBER(1) NOT NULL, /* 회원 구분 */
	user_name VARCHAR2(16 CHAR) NOT NULL, /* 회원 이름 */
	gender NUMBER(1), /* 성별 */
	age NUMBER(3), /* 나이 */
	email VARCHAR2(30 BYTE), /* 이메일 */
	address VARCHAR2(50 CHAR), /* 주소 */
	phone NUMBER(15), /* 연락처 */
	withdraw_flag NUMBER(1) NOT NULL /* 탈퇴 여부 */
);

COMMENT ON TABLE MC_USER IS 'MC_USER';

COMMENT ON COLUMN MC_USER.user_no IS '회원 번호';

COMMENT ON COLUMN MC_USER.user_id IS '회원 id';

COMMENT ON COLUMN MC_USER.user_password IS '회원 pw';

COMMENT ON COLUMN MC_USER.user_div IS '회원 구분';

COMMENT ON COLUMN MC_USER.user_name IS '회원 이름';

COMMENT ON COLUMN MC_USER.gender IS '성별';

COMMENT ON COLUMN MC_USER.age IS '나이';

COMMENT ON COLUMN MC_USER.email IS '이메일';

COMMENT ON COLUMN MC_USER.address IS '주소';

COMMENT ON COLUMN MC_USER.phone IS '연락처';

COMMENT ON COLUMN MC_USER.withdraw_flag IS '탈퇴 여부';

CREATE UNIQUE INDEX PK_MC_USER
	ON MC_USER (
		user_no ASC
	);

ALTER TABLE MC_USER
	ADD
		CONSTRAINT PK_MC_USER
		PRIMARY KEY (
			user_no
		);

--SEQUENCE 생성

CREATE SEQUENCE SEQ_USER_NO 
start with 0 
increment BY 1 
maxvalue 9999999999999999;



--select by user_no

SELECT
    user_no,
    user_id,
    user_password,
    user_div,
    user_name,
    gender,
    age,
    email,
    address,
    phone,
    withdraw_flag
FROM
    mc_user
WHERE user_no = :user_no;

--select by user_id

SELECT
    user_no,
    user_id,
    user_password,
    user_div,
    user_name,
    gender,
    age,
    email,
    address,
    phone,
    withdraw_flag
FROM
    mc_user
WHERE user_id = :user_id;

--select count(중복 아이디 체크)

SELECT count(user_id) cnt
  FROM MC_USER
 WHERE user_id = :user_id;



--update(회원 수정)

UPDATE mc_user
    SET user_password =:v2
        ,user_div =:v3
        ,user_name =:v4
        ,gender =:v5
        ,age =:v6
        ,email =:v7
        ,address =:v8
        ,phone =:v9
        ,withdraw_flag =:v10
WHERE user_no =:user_no;

--insert(회원가입)

INSERT INTO mc_user (
    user_no,
    user_id,
    user_password,
    user_div,
    user_name,
    gender,
    age,
    email,
    address,
    phone,
    withdraw_flag
) VALUES (
    SEQ_USER_NO.NEXTVAL,
    :user_id,
    :user_password,
    :user_div,
    :user_name,
    :gender,
    :age,
    :email,
    :address,
    :phone,
    1
);





















