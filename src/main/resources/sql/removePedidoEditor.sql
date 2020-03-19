UPDATE sqldados.eord
SET auxString4 = ''
WHERE storeno = :loja
  AND ordno = :numero
  AND auxShort4 = 1