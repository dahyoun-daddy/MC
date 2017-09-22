
<코드 테이블 MST_CD_ID로 검색하여 페이징,카테고리 설정>

SELECT MST_CD_ID,
  DTL_CD_ID,
  MST_CD_NM,
  DTL_CD_NM,
  SEQ,
  SUP_MST_CD_ID,
  USE_YN
FROM MC_CODE
where MST_CD_ID = ?


