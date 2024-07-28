SELECT mcdp_cd AS "진료과코드", COUNT(apnt_ymd) AS "5월예약건수"
  FROM appointment
  WHERE TO_CHAR(apnt_ymd, 'YYYY-MM') = '2022-05'
  GROUP BY mcdp_cd
  ORDER BY "5월예약건수", mcdp_cd;