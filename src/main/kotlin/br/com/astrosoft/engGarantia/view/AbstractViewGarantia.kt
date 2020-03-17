package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.engGarantia.model.NotaDevolucaoGarantia
import br.com.astrosoft.engGarantia.viewmodel.AbastractViewModelGarantia
import br.com.astrosoft.engGarantia.viewmodel.IViewModelGarantia
import br.com.astrosoft.framework.view.ViewLayout
import com.github.mvysny.karibudsl.v10.addColumnFor
import com.github.mvysny.karibudsl.v10.grid
import com.github.mvysny.karibudsl.v10.isExpand
import com.vaadin.flow.component.grid.ColumnTextAlign.END
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.grid.Grid.SelectionMode
import com.vaadin.flow.component.grid.GridVariant.LUMO_COMPACT
import com.vaadin.flow.data.provider.ListDataProvider
import com.vaadin.flow.data.renderer.LocalDateRenderer
import com.vaadin.flow.data.renderer.NumberRenderer
import java.text.DecimalFormat

abstract class AbstractViewGarantia<VM: AbastractViewModelGarantia>: IViewModelGarantia, ViewLayout<VM>() {
  private val formatNumber = DecimalFormat("#,##0.00")
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
      
      addColumnFor(NotaDevolucaoGarantia::storeno) {
        setHeader("Loja")
      }
      addColumnFor(NotaDevolucaoGarantia::numeroDevolucao) {
        setHeader("NDF")
      }
      addColumnFor(NotaDevolucaoGarantia::localDataDevolucao,
                   LocalDateRenderer(NotaDevolucaoGarantia::localDataDevolucao, "dd/MM/yyyy")) {
        setHeader("Emissão")
      }
      addColumnFor(NotaDevolucaoGarantia::numeroRetorno) {
        setHeader("Nota Ret")
      }
      addColumnFor(NotaDevolucaoGarantia::localDataRetorno,
                   LocalDateRenderer(NotaDevolucaoGarantia::localDataRetorno, "dd/MM/yyyy")) {
        setHeader("Emissão")
      }
      addColumnFor(NotaDevolucaoGarantia::fornecedor) {
        setHeader("For")
      }
      addColumnFor(NotaDevolucaoGarantia::cfop) {
        setHeader("CFOP")
      }
      addColumnFor(NotaDevolucaoGarantia::baseIcms, NumberRenderer(NotaDevolucaoGarantia::baseIcms, formatNumber)) {
        setHeader("Base ICMS")
        this.textAlign = END
      }
      addColumnFor(NotaDevolucaoGarantia::valorIcms, NumberRenderer(NotaDevolucaoGarantia::valorIcms, formatNumber)) {
        setHeader("Valor ICMS")
        this.textAlign = END
      }
      addColumnFor(NotaDevolucaoGarantia::baseSt, NumberRenderer(NotaDevolucaoGarantia::baseSt, formatNumber)) {
        setHeader("Base ST")
        this.textAlign = END
      }
      addColumnFor(NotaDevolucaoGarantia::valorSt, NumberRenderer(NotaDevolucaoGarantia::valorSt, formatNumber)) {
        setHeader("Valor ST")
        this.textAlign = END
      }
      addColumnFor(NotaDevolucaoGarantia::valorIpi, NumberRenderer(NotaDevolucaoGarantia::valorIpi, formatNumber)) {
        setHeader("Valor IPI")
        this.textAlign = END
      }
      addColumnFor(NotaDevolucaoGarantia::valorProdutos,
                   NumberRenderer(NotaDevolucaoGarantia::valorProdutos, formatNumber)) {
        setHeader("Valor Produto")
        this.textAlign = END
      }
      addColumnFor(NotaDevolucaoGarantia::valorNota, NumberRenderer(NotaDevolucaoGarantia::valorNota, formatNumber)) {
        setHeader("Valor Nota")
        this.textAlign = END
      }
    }
  }
}