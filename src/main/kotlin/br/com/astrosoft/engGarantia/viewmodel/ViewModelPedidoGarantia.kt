package br.com.astrosoft.engGarantia.viewmodel

import br.com.astrosoft.engGarantia.model.PedidoGarantia
import br.com.astrosoft.engGarantia.model.saci
import br.com.astrosoft.framework.viewmodel.fail

class ViewModelPedidoGarantia(view: IViewModelPedido): AbastractViewModelPedidoGarantia(view) {
  override fun itensGrid() = pedidoGarantia
  
  fun addPedido(loja: Int?, numero: Int?) = exec {
    loja ?: fail("Loja inválida")
    numero ?: fail("Número de pedido inválido")
    saci.addPedido(loja, numero)
    updateGrid()
  }
  
  fun addNota(pedido: PedidoGarantia?, nota: String?) = exec {
    nota ?: fail("Número de nota inválido")
    pedido ?: fail("Pedido não selecionado")
    val loja = pedido.storeno
    val numero = pedido.ordno
    saci.addNota(loja, numero, nota)
    updateGrid()
  }
  
  fun removePedido(pedido: PedidoGarantia) {
    val loja = pedido.storeno
    val numero = pedido.ordno
    saci.removePedidoGarantia(loja, numero)
    updateGrid()
  }
}