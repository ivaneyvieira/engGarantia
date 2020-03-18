SELECT N.storeno,
       N.ordno,
       N.auxString4                                                          AS numeroNota,
       CAST(N.date AS DATE)                                                  AS dataPedido,
       IFNULL(CAST(TRIM(CONCAT(C.no, ' ', MID(C.name, 1, 15))) AS CHAR), '') AS cliente,
       IFNULL(SUM(I.price * I.qtty / (100 * 1000)), 0)                       AS valorProdutos,
       IFNULL(N.amount / 100, 0)                                             AS valorPedido
FROM sqldados.eord             N
  INNER JOIN sqldados.eoprd AS I
               USING (storeno, ordno)
  LEFT JOIN  sqldados.custp AS C
               ON C.no = N.custno
WHERE N.date >= 20200101
  AND (N.auxShort4 <> 0)
GROUP BY N.storeno, N.ordno