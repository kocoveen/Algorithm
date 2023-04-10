-- 코드를 입력하세요
SELECT B.TITLE, BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS,
DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD AS B JOIN USED_GOODS_REPLY AS R USING(BOARD_ID)
WHERE MONTH(B.CREATED_DATE) = 10
ORDER BY R.CREATED_DATE ASC, B.TITLE ASC