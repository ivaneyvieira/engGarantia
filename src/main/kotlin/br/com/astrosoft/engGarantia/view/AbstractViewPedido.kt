package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.engGarantia.model.PedidoGarantia
import br.com.astrosoft.engGarantia.viewmodel.AbastractViewModelPedidoGarantia
import br.com.astrosoft.engGarantia.viewmodel.IViewModelPedido
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

abstract class AbstractViewPedido<VM: AbastractViewModelPedidoGarantia>: IViewModelPedido, ViewLayout<VM>() {
  private var gridNotas: Grid<PedidoGarantia>
  private val dataProviderProdutos = ListDataProvider<PedidoGarantia>(mutableListOf())
  
  override fun updateGrid(list: List<PedidoGarantia>) {
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
      
      addColumnInt(PedidoGarantia::storeno) {
        setHeader("Loja")
      }
      addColumnInt(PedidoGarantia::ordno) {
        setHeader("Pedido")
      }
      addColumnString(PedidoGarantia::numeroNota) {
        setHeader("NF")
      }
      addColumnDate(PedidoGarantia::localDataPedido) {
        setHeader("Data")
      }
      addColumnString(PedidoGarantia::cliente) {
        setHeader("Cliente")
      }
      addColumnDouble(PedidoGarantia::valorProdutos) {
        setHeader("Valor Produtos")
      }
      addColumnDouble(PedidoGarantia::valorPedido) {
        setHeader("Valor Pedido")
      }
    }
  }
}