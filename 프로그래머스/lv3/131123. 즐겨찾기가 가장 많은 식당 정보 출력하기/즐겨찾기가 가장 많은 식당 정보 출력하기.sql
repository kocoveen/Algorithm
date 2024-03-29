SELECT A.FOOD_TYPE, A.REST_ID, A.REST_NAME, A.FAVORITES
FROM REST_INFO A
JOIN (
        SELECT FOOD_TYPE, MAX(FAVORITES) AS MAX_FAVORITES
        FROM REST_INFO
        GROUP BY FOOD_TYPE
        HAVING MAX(FAVORITES)
    ) B
ON A.FOOD_TYPE = B.FOOD_TYPE
WHERE B.MAX_FAVORITES = A.FAVORITES
ORDER BY FOOD_TYPE DESC


# SELECT FOOD_TYPE, REST_ID, REST_NAME
# FROM REST_INFO
# WHERE (
#         SELECT FOOD_TYPE, MAX(FAVORITES) AS MAX_FAVORITES
#         FROM REST_INFO
#         GROUP BY FOOD_TYPE
#         HAVING MAX(FAVORITES)
#     )
# ORDER BY FOOD_TYPE DESC

# MAX(FAVORITES) AS FAVORITES