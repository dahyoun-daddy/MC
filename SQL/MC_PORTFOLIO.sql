
/* MC_PORTFOLIO */
CREATE TABLE 포트폴리오 테이블 (
	pf_id NUMBER(16) NOT NULL, /* 포트폴리오 id */
	user_no NUMBER(16) NOT NULL, /* 회원 번호 */
	tmp_no NUMBER(16) NOT NULL /* 템플릿 번호 */
);

COMMENT ON TABLE 포트폴리오 테이블 IS 'MC_PORTFOLIO';

COMMENT ON COLUMN 포트폴리오 테이블.pf_id IS '포트폴리오 id';

COMMENT ON COLUMN 포트폴리오 테이블.user_no IS '회원 번호';

COMMENT ON COLUMN 포트폴리오 테이블.tmp_no IS '템플릿 번호';

CREATE UNIQUE INDEX PK_포트폴리오 테이블
	ON 포트폴리오 테이블 (
		pf_id ASC
	);

ALTER TABLE 포트폴리오 테이블
	ADD
		CONSTRAINT PK_포트폴리오 테이블
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






















