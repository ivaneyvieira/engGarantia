package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.engGarantia.viewmodel.ViewModelPedidoGarantia
import com.github.appreciated.app.layout.annotations.Caption
import com.github.appreciated.app.layout.annotations.Icon
import com.vaadin.flow.component.icon.VaadinIcon.EDIT
import com.vaadin.flow.router.Route

@Route(value = "pedidoGarantia", layout = MainAppLayout::class)
@Caption("Pedido Garantia")
@Icon(EDIT)
class ViewPedidoGarantia: AbstractViewPedido<ViewModelPedidoGarantia>() {
  override val viewModel: ViewModelPedidoGarantia = ViewModelPedidoGarantia(this)
  
  init {
    viewModel.updateGrid()
  }
}