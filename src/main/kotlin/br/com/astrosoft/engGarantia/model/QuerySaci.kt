package br.com.astrosoft.engGarantia.model

import br.com.astrosoft.framework.model.QueryDB
import br.com.astrosoft.framework.util.DB

class QuerySaci: QueryDB(driver, url, username, password) {
  fun devolucaoGarantia(): List<NotaDevolucaoGarantia> {
    val sql = "/sql/devolucoes.sql"
    return query(sql) {q ->
      q.executeAndFetch(NotaDevolucaoGarantia::class.java)
    }
  }
  
  fun pedidoGarantia(): List<PedidoGarantia> {
    val sql = "/sql/pedido.sql"
    return query(sql) {q ->
      q.executeAndFetch(PedidoGarantia::class.java)
    }
  }
  
  fun addPedido(loja: Int, numero: Int) {
    val sql = "/sql/addPedido.sql"
    script(sql) {q ->
      q.addParameter("loja", loja)
      q.addParameter("numero", numero)
      q.executeUpdate()
    }
  }
  
  fun addNota(loja: Int, numero: Int, nota: String) {
    val sql = "/sql/addNota.sql"
    script(sql) {q ->
      q.addParameter("loja", loja)
      q.addParameter("numero", numero)
      q.addParameter("nota", nota)
      q.executeUpdate()
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