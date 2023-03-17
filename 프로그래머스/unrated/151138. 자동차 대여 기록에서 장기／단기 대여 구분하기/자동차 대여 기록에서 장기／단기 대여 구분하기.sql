SELECT HISTORY_ID,
       CAR_ID,
       DATE_FORMAT(START_DATE, "%Y-%m-%d"),
       DATE_FORMAT(END_DATE, "%Y-%m-%d"),
    CASE
        WHEN (DATEDIFF(end_date, start_date) >= 29) THEN "장기 대여"
        ELSE "단기 대여"
    END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE MONTH(start_date) = 9
ORDER BY HISTORY_ID DESC;