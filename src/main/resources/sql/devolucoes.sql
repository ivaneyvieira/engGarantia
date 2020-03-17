SELECT N.storeno,
       N.pdvno,
       N.xano,
       N.nfno                                                                AS nfDevolucao,
       N.nfse                                                                AS seDevolucao,
       IFNULL(CAST(CONCAT(N.nfno, '/', N.nfse) AS CHAR), '')                 AS numeroDevolucao,
       CAST(N.issuedate AS DATE)                                             AS dataDevolucao,
       IFNULL(E.nfname, '')                                                  AS nfRetorno,
       IFNULL(E.invse, '')                                                   AS seRetorno,
       IFNULL(CAST(CONCAT(E.nfname, '/', E.invse) AS CHAR), '')              AS numeroRetorno,
       CAST(E.date AS DATE)                                                  AS dataRetorno,
       IFNULL(CAST(TRIM(CONCAT(C.no, ' ', MID(C.name, 1, 15))) AS CHAR), '') AS cliente,
       N.cfo                                                                 AS cfop,
       IFNULL(N.base_calculo_ipi / 100, 0)                                   AS baseIcms,
       IFNULL(N.icms_amt / 100, 0)                                           AS valorIcms,
       IFNULL(N.baseIcmsSubst / 100, 0)                                      AS baseSt,
       IFNULL(N.icmsSubst / 100, 0)                                          AS valorSt,
       IFNULL(N.ipi_amt / 100, 0)                                            AS valorIpi,
       IFNULL(SUM(I.precoUnitario / 100), 0)                                 AS valorProdutos,
       IFNULL(N.grossamt / 100, 0)                                           AS valorNota,
       SUM(P.invno IS NOT NULL) <> 0                                         AS ProdutoOk
FROM sqldados.nf             AS N
  INNER JOIN sqldados.xaprd2 AS I
               USING (storeno, pdvno, xano)
  LEFT JOIN  sqldados.custp  AS C
               ON C.no = N.custno
/*  LEFT JOIN  sqldados.vend   AS V
               ON V.cgc = C.cpf_cgc*/
  LEFT JOIN  sqldados.inv    AS E
               ON N.storeno = E.storeno AND N.nfno = E.ordno AND E.invse = '66'
  LEFT JOIN  sqldados.iprd   AS P
               ON P.invno = E.invno AND P.prdno = I.prdno AND P.grade = I.grade
WHERE N.issuedate >= 20200101
  AND (N.remarks LIKE 'GA%' OR N.remarks LIKE 'G%TIA')
  AND N.tipo = 2
GROUP BY N.storeno, N.pdvno, N.xano