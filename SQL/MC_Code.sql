
<�ڵ� ���̺� MST_CD_ID�� �˻��Ͽ� ����¡,ī�װ� ����>

SELECT MST_CD_ID,
  DTL_CD_ID,
  MST_CD_NM,
  DTL_CD_NM,
  SEQ,
  SUP_MST_CD_ID,
  USE_YN
FROM MC_CODE
where MST_CD_ID = ?


