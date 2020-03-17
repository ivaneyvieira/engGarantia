package br.com.astrosoft.engGarantia.model

import br.com.astrosoft.framework.util.toLocalDate
import java.util.*

data class NotaDevolucaoGarantia(
  val storeno: Int,
  val pdvno: Int,
  val xano: Int,
  val nfDevolucao: Int,
  val seDevolucao: String,
  val numeroDevolucao: String,
  val dataDevolucao: Date,
  val nfRetorno: String,
  val seRetorno: String,
  val numeroRetorno: String,
  val dataRetorno: Date,
  val fornecedor: String,
  val cfop: Int,
  val baseIcms: Double,
  val valorIcms: Double,
  val baseSt: Double,
  val valorSt: Double,
  val valorIpi: Double,
  val valorProdutos: Double,
  val valorNota: Double,
  val ProdutoOk: Boolean
                                ) {
  val localDataDevolucao
    get() = dataDevolucao.toLocalDate()
  val localDataRetorno
    get() = dataRetorno.toLocalDate()
}