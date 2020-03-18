package br.com.astrosoft.engGarantia.viewmodel

import br.com.astrosoft.abastecimento.model.saci
import br.com.astrosoft.engGarantia.model.PedidoGarantia
import br.com.astrosoft.framework.viewmodel.IView
import br.com.astrosoft.framework.viewmodel.ViewModel
import kotlin.concurrent.thread

abstract class AbastractViewModelPedidoGarantia(view: IViewModelPedido): ViewModel<IViewModelPedido>(view) {
  abstract fun itensGrid(): List<PedidoGarantia>
  
  fun updateGrid() {
    updatePedidoGarantia()
    view.updateGrid(itensGrid())
  }
  
  companion object {
    fun updatePedidoGarantia() {
      notasGarantia.clear()
      notasGarantia.addAll(saci.pedidoGarantia())
    }
    
    val notasGarantia = mutableListOf<PedidoGarantia>()
    val pedidoGarantia
      get() = notasGarantia.filter {it.numeroNota == ""}
    val pedidoEditor
      get() = notasGarantia.filter {it.numeroNota != ""}
    val threadDados = thread(start = false) {
      while(true) {
        updatePedidoGarantia()
        Thread.sleep(60 * 1000)
      }
    }
  }
}

interface IViewModelPedido: IView {
  fun updateGrid(list: List<PedidoGarantia>)
}