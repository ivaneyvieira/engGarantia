package br.com.astrosoft.engGarantia.viewmodel

import br.com.astrosoft.engGarantia.model.NotaDevolucaoGarantia
import br.com.astrosoft.engGarantia.model.saci
import br.com.astrosoft.framework.viewmodel.IView
import br.com.astrosoft.framework.viewmodel.ViewModel
import kotlin.concurrent.thread

abstract class AbastractViewModelDevolucaoGarantia(view: IViewModelGarantia): ViewModel<IViewModelGarantia>(view) {
  abstract fun itensGrid(): List<NotaDevolucaoGarantia>
  
  fun updateGrid() {
    updateNotasGarantia()
    view.updateGrid(itensGrid())
  }
  
  companion object {
    fun updateNotasGarantia() {
      notasGarantia.clear()
      notasGarantia.addAll(saci.devolucaoGarantia())
    }
    
    val notasGarantia = mutableListOf<NotaDevolucaoGarantia>()
    val notasDevolucao
      get() = notasGarantia.filter {it.numeroRetorno == ""}
    val notasEditor
      get() = notasGarantia.filter {it.numeroRetorno != ""}
    val threadDados = thread(start = false) {
      while(true) {
        updateNotasGarantia()
        Thread.sleep(60*1000)
      }
    }
  }
}

interface IViewModelGarantia: IView {
  fun updateGrid(list: List<NotaDevolucaoGarantia>)
}