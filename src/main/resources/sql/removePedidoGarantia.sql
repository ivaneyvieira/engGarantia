UPDATE sqldados.eord
SET auxShort4 = 0
WHERE storeno = :loja
  AND ordno = :numero
  AND auxString4 = ''