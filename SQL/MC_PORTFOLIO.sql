
drop table mc_portfolio cascade constraints;

/* MC_PORTFOLIO */
CREATE TABLE MC_PORTFOLIO (
	pf_id NUMBER(16) NOT NULL, /* ��Ʈ������ id */
	user_id VARCHAR2(16 byte) NOT NULL, /* ȸ�� id */
	tmp_no NUMBER(16) NOT NULL /* ���ø� ��ȣ */
);

COMMENT ON TABLE MC_PORTFOLIO IS 'MC_PORTFOLIO';

COMMENT ON COLUMN MC_PORTFOLIO.pf_id IS '��Ʈ������ id';

COMMENT ON COLUMN MC_PORTFOLIO.user_id IS 'ȸ�� id';

COMMENT ON COLUMN MC_PORTFOLIO.tmp_no IS '���ø� ��ȣ';

CREATE UNIQUE INDEX PK_MC_PORTFOLIO
	ON MC_PORTFOLIO (
		pf_id ASC
	);

ALTER TABLE MC_PORTFOLIO
	ADD
		CONSTRAINT PK_MC_PORTFOLIO
		PRIMARY KEY (
			pf_id
		);

--�ܷ�Ű ����

ALTER TABLE MC_PORTFOLIO
ADD CONSTRAINT fk_pf_user_id FOREIGN KEY(user_id)
REFERENCES mc_user(user_id);

ALTER TABLE MC_PORTFOLIO DROP CONSTRAINT fk_user_id;




CREATE SEQUENCE seq_pf_id
start with 0
increment by 1
MAXVALUE 99999999
MINVALUE 0;

--select 
SELECT
    pf_id,
    user_id,
    tmp_no
FROM
    mc_portfolio;


--selectOne
SELECT
    pf_id,
    user_id,
    tmp_no
FROM
    mc_portfolio
WHERE pf_id=:pf_id;

--select by user_id

SELECT
    pf_id,
    user_id,
    tmp_no
FROM
    mc_portfolio
WHERE user_id=:user_id;



--update

UPDATE mc_portfolio
    SET user_id =:user_id
        ,tmp_no =:tmp_no
WHERE pf_id =:pf_id;


--delete
       
DELETE FROM mc_portfolio 
WHERE pf_id =:pf_id;

--deleteAll
       
DELETE FROM mc_portfolio;


--insert

INSERT INTO mc_portfolio 
( 
    pf_id
    ,user_id
    ,tmp_no 
) 
VALUES 
(
    seq_pf_id.NEXTVAL
    ,:user_id
    ,:tmp_no
);











ALTER TABLE MC_BLOG_SETTING
ADD CONSTRAINT fk_bs_user_id FOREIGN KEY(user_id)
REFERENCES mc_user(user_id);










