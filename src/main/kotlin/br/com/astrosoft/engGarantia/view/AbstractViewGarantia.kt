package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.engGarantia.model.NotaDevolucaoGarantia
import br.com.astrosoft.engGarantia.viewmodel.AbastractViewModelGarantia
import br.com.astrosoft.engGarantia.viewmodel.IViewModelGarantia
import br.com.astrosoft.framework.view.ViewLayout
import br.com.astrosoft.framework.view.addColumnDate
import br.com.astrosoft.framework.view.addColumnDouble
import br.com.astrosoft.framework.view.addColumnInt
import br.com.astrosoft.framework.view.addColumnString
import com.github.mvysny.karibudsl.v10.grid
import com.github.mvysny.karibudsl.v10.isExpand
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.grid.Grid.SelectionMode
import com.vaadin.flow.component.grid.GridVariant.LUMO_COMPACT
import com.vaadin.flow.data.provider.ListDataProvider

abstract class AbstractViewGarantia<VM: AbastractViewModelGarantia>: IViewModelGarantia, ViewLayout<VM>() {
  private var gridNotas: Grid<NotaDevolucaoGarantia>
  private val dataProviderProdutos = ListDataProvider<NotaDevolucaoGarantia>(mutableListOf())
  
  override fun updateGrid(list: List<NotaDevolucaoGarantia>) {
    dataProviderProdutos.items.clear()
    dataProviderProdutos.items.addAll(viewModel.itensGrid())
    dataProviderProdutos.refreshAll()
  }
  
  init {
    gridNotas = grid(dataProvider = dataProviderProdutos) {
      isExpand = true
      isMultiSort = true
      addThemeVariants(LUMO_COMPACT)
      setSelectionMode(SelectionMode.SINGLE)
  
      addColumnInt(NotaDevolucaoGarantia::storeno) {
        setHeader("Loja")
      }
      addColumnString(NotaDevolucaoGarantia::numeroDevolucao) {
        setHeader("NDF")
      }
      addColumnDate(NotaDevolucaoGarantia::localDataDevolucao) {
        setHeader("Emissão")
      }
      addColumnString(NotaDevolucaoGarantia::numeroRetorno) {
        setHeader("Nota Ret")
      }
      addColumnDate(NotaDevolucaoGarantia::localDataRetorno) {
        setHeader("Emissão")
      }
      addColumnString(NotaDevolucaoGarantia::cliente) {
        setHeader("Cliente")
      }
      addColumnInt(NotaDevolucaoGarantia::cfop) {
        setHeader("CFOP")
      }
      addColumnDouble(NotaDevolucaoGarantia::baseIcms) {
        setHeader("Base ICMS")
      }
      addColumnDouble(NotaDevolucaoGarantia::valorIcms) {
        setHeader("Valor ICMS")
      }
      addColumnDouble(NotaDevolucaoGarantia::baseSt) {
        setHeader("Base ST")
      }
      addColumnDouble(NotaDevolucaoGarantia::valorSt) {
        setHeader("Valor ST")
      }
      addColumnDouble(NotaDevolucaoGarantia::valorIpi) {
        setHeader("Valor IPI")
      }
      addColumnDouble(NotaDevolucaoGarantia::valorProdutos) {
        setHeader("Valor Produto")
      }
      addColumnDouble(NotaDevolucaoGarantia::valorNota) {
        setHeader("Valor Nota")
      }
    }
  }
}