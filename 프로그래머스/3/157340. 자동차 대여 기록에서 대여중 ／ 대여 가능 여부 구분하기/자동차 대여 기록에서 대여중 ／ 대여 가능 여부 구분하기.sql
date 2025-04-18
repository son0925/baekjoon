SELECT DISTINCT H.CAR_ID,
       CASE
         WHEN C.CAR_ID IS NULL THEN '대여 가능'
         ELSE '대여중' 
       END AS AVAILABILITY
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
  LEFT OUTER JOIN (SELECT DISTINCT CAR_ID
                     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    WHERE TO_DATE('2022-10-16', 'YYYY-MM-DD') 
                      BETWEEN START_DATE AND END_DATE) C
  ON H.CAR_ID = C.CAR_ID
  ORDER BY CAR_ID DESC;
