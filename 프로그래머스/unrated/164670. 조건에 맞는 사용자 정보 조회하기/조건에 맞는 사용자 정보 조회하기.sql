SELECT USER_ID, 
       NICKNAME,
       CONCAT(CITY, " ", STREET_ADDRESS1, " ", STREET_ADDRESS2) AS 전체주소,
       CONCAT(SUBSTR(TLNO, 1, 3), '-', SUBSTR(TLNO, 4, 4), '-', SUBSTR(TLNO, 8, 4)) AS 전화번호 
       
FROM USED_GOODS_USER A
JOIN (
    SELECT WRITER_ID, COUNT(WRITER_ID) AS COUNT
    FROM USED_GOODS_BOARD
    GROUP BY WRITER_ID
    HAVING COUNT(WRITER_ID) >= 3
) B ON A.USER_ID = B.WRITER_ID
ORDER BY USER_ID DESC
