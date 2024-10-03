SELECT P.PRODUCT_ID, P.PRODUCT_NAME, SUM(O.AMOUNT * P.PRICE) AS TOTAL_SALES
  FROM FOOD_PRODUCT P
  JOIN FOOD_ORDER O
  ON P.PRODUCT_ID = O.PRODUCT_ID
  WHERE TO_CHAR(O.PRODUCE_DATE, 'YYYY-MM') = '2022-05'
  GROUP BY P.PRODUCT_ID, P.PRODUCT_NAME
  ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID