
/* MC_USER */
CREATE TABLE MC_USER (
	user_no NUMBER(16) NOT NULL, /* ȸ�� ��ȣ */
	user_id VARCHAR2(16 BYTE) NOT NULL, /* ȸ�� id */
	user_password VARCHAR2(16 BYTE) NOT NULL, /* ȸ�� pw */
	user_div NUMBER(1) NOT NULL, /* ȸ�� ���� */
	user_name VARCHAR2(16 CHAR) NOT NULL, /* ȸ�� �̸� */
	gender NUMBER(1), /* ���� */
	age NUMBER(3), /* ���� */
	email VARCHAR2(30 BYTE), /* �̸��� */
	address VARCHAR2(50 CHAR), /* �ּ� */
	phone NUMBER(15), /* ����ó */
	withdraw_flag NUMBER(1) NOT NULL /* Ż�� ���� */
);

COMMENT ON TABLE MC_USER IS 'MC_USER';

COMMENT ON COLUMN MC_USER.user_no IS 'ȸ�� ��ȣ';

COMMENT ON COLUMN MC_USER.user_id IS 'ȸ�� id';

COMMENT ON COLUMN MC_USER.user_password IS 'ȸ�� pw';

COMMENT ON COLUMN MC_USER.user_div IS 'ȸ�� ����';

COMMENT ON COLUMN MC_USER.user_name IS 'ȸ�� �̸�';

COMMENT ON COLUMN MC_USER.gender IS '����';

COMMENT ON COLUMN MC_USER.age IS '����';

COMMENT ON COLUMN MC_USER.email IS '�̸���';

COMMENT ON COLUMN MC_USER.address IS '�ּ�';

COMMENT ON COLUMN MC_USER.phone IS '����ó';

COMMENT ON COLUMN MC_USER.withdraw_flag IS 'Ż�� ����';

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

--SEQUENCE ����

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

--select count(�ߺ� ���̵� üũ)

SELECT count(user_id) cnt
  FROM MC_USER
 WHERE user_id = :user_id;



--update(ȸ�� ����)

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

--insert(ȸ������)

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





















