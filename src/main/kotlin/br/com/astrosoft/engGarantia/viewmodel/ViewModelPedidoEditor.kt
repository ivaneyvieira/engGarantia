package br.com.astrosoft.engGarantia.viewmodel

import br.com.astrosoft.engGarantia.model.PedidoGarantia
import br.com.astrosoft.engGarantia.model.saci

class ViewModelPedidoEditor(view: IViewModelPedido): AbastractViewModelPedidoGarantia(view) {
  override fun itensGrid() = pedidoEditor
  
  fun removePedido(pedido: PedidoGarantia) {
    val loja = pedido.storeno
    val numero = pedido.ordno
    saci.removePedidoEditor(loja, numero)
    updateGrid()
  }
}