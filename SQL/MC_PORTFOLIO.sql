
/* MC_PORTFOLIO */
CREATE TABLE ��Ʈ������ ���̺� (
	pf_id NUMBER(16) NOT NULL, /* ��Ʈ������ id */
	user_no NUMBER(16) NOT NULL, /* ȸ�� ��ȣ */
	tmp_no NUMBER(16) NOT NULL /* ���ø� ��ȣ */
);

COMMENT ON TABLE ��Ʈ������ ���̺� IS 'MC_PORTFOLIO';

COMMENT ON COLUMN ��Ʈ������ ���̺�.pf_id IS '��Ʈ������ id';

COMMENT ON COLUMN ��Ʈ������ ���̺�.user_no IS 'ȸ�� ��ȣ';

COMMENT ON COLUMN ��Ʈ������ ���̺�.tmp_no IS '���ø� ��ȣ';

CREATE UNIQUE INDEX PK_��Ʈ������ ���̺�
	ON ��Ʈ������ ���̺� (
		pf_id ASC
	);

ALTER TABLE ��Ʈ������ ���̺�
	ADD
		CONSTRAINT PK_��Ʈ������ ���̺�
		PRIMARY KEY (
			pf_id
		);

CREATE SEQUENCE seq_pf_id
start with 0
increment by 1
MAXVALUE 99999999
MINVALUE 0;

--select 
SELECT
    pf_id,
    user_no,
    tmp_no
FROM
    mc_portfolio;


--selectOne
SELECT
    pf_id,
    user_no,
    tmp_no
FROM
    mc_portfolio
WHERE pf_id=:pf_id;

--select by user_no

SELECT
    pf_id,
    user_no,
    tmp_no
FROM
    mc_portfolio
WHERE user_no=:user_no;



--update

UPDATE mc_portfolio
    SET user_no =:user_no
        ,tmp_no =:tmp_no
WHERE pf_id =:pf_id;


--delete
       
DELETE FROM mc_portfolio 
WHERE pf_id =:pf_id;

--insert

INSERT INTO mc_portfolio 
( 
    pf_id
    ,user_no
    ,tmp_no 
) 
VALUES 
(
    seq_pf_id.NEXTVAL
    ,:user_no
    ,:tmp_no
);






















