<!-- �ߺ� ���̵� üũ  -->
SELECT count(user_id) cnt
  FROM MC_USER
 where user_id = ?

<!-- ȸ������   -->
INSERT
INTO MC_USER
  (
    USER_NO,
    USER_ID,
    USER_PASSWORD,
    USER_DIV,
    USER_NAME,
    GENDER,
    AGE,
    EMAIL,
    ADDRESS,
    PHONE,
    WITHDRAW_FLAG
  )
  VALUES
  (
    SEQ_USER_NO.NEXTVAL,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?
  )
