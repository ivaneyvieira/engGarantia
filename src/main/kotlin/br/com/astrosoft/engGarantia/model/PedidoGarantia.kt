package br.com.astrosoft.engGarantia.model

import br.com.astrosoft.framework.util.toLocalDate
import java.util.*

data class PedidoGarantia(
  val storeno: Int,
  val ordno: Int,
  val numeroNota: String,
  val dataPedido: Date,
  val cliente: String,
  val valorProdutos: Double,
  val valorPedido: Double
                         ) {
  val localDataPedido
    get() = dataPedido.toLocalDate()
}