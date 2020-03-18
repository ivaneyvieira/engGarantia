package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.engGarantia.viewmodel.ViewModelPedidoEditor
import com.github.appreciated.app.layout.annotations.Caption
import com.github.appreciated.app.layout.annotations.Icon
import com.vaadin.flow.component.icon.VaadinIcon.EDIT
import com.vaadin.flow.router.Route

@Route(value = "pedidoEditor", layout = MainAppLayout::class)
@Caption("Editor de Pedidos")
@Icon(EDIT)
class ViewPedidoEditor: AbstractViewPedido<ViewModelPedidoEditor>() {
  override val viewModel: ViewModelPedidoEditor = ViewModelPedidoEditor(this)
  
  init {
    viewModel.updateGrid()
  }
}