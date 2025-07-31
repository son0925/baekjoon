SELECT
  b.category,
  SUM(bs.sales) as total_sales
FROM
  book b
JOIN
  book_sales bs
  ON b.book_id = bs.book_id
WHERE
  bs.sales_date BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY
  b.category
ORDER BY
  b.category