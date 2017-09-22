<!-- 중복 아이디 체크  -->
SELECT count(user_id) cnt
  FROM MC_USER
 where user_id = ?

<!-- 회원가입   -->
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
