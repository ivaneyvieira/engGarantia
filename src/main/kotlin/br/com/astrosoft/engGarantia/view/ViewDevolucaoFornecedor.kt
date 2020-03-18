package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.engGarantia.viewmodel.ViewModelDevolucaoFornecedor
import com.github.appreciated.app.layout.annotations.Caption
import com.github.appreciated.app.layout.annotations.Icon
import com.vaadin.flow.component.icon.VaadinIcon.TRUCK
import com.vaadin.flow.router.Route

@Route(value = "fornecedor", layout = MainAppLayout::class)
@Caption("Devolução Fornecedor")
@Icon(TRUCK)
class ViewDevolucaoFornecedor: AbstractViewGarantia<ViewModelDevolucaoFornecedor>() {
  override val viewModel: ViewModelDevolucaoFornecedor = ViewModelDevolucaoFornecedor(this)
  
  init {
    viewModel.updateGrid()
  }
}