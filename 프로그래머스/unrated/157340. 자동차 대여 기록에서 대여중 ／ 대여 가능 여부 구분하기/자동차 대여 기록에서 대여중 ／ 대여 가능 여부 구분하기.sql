WITH IS_RENTAL AS (SELECT CAR_ID
                   FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                   WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE)


SELECT CAR_ID,
    CASE
        WHEN CAR_ID IN (SELECT CAR_ID FROM IS_RENTAL) THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;

# SELECT CAR_ID, MAX(START_DATE) AS CUR_START_DATE, MAX(END_DATE) AS CUR_END_DATE