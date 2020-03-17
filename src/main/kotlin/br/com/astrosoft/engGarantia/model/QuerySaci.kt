package br.com.astrosoft.abastecimento.model

import br.com.astrosoft.engGarantia.model.NotaDevolucaoGarantia
import br.com.astrosoft.framework.model.QueryDB
import br.com.astrosoft.framework.util.DB

class QuerySaci: QueryDB(driver, url, username, password) {
  fun devolucaoGarantia(): List<NotaDevolucaoGarantia> {
    val sql = "/sql/devolucoes.sql"
    return query(sql) {q ->
      q.executeAndFetch(NotaDevolucaoGarantia::class.java)
    }
  }
  
  companion object {
    private val db = DB("saci")
    internal val driver = db.driver
    internal val url = db.url
    internal val username = db.username
    internal val password = db.password
    internal val test = db.test
    val ipServer =
      url.split("/")
        .getOrNull(2)
  }
}

val saci = QuerySaci()