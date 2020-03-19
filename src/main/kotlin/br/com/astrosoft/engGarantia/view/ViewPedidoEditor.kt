package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.engGarantia.viewmodel.ViewModelPedidoEditor
import com.github.appreciated.app.layout.annotations.Caption
import com.github.appreciated.app.layout.annotations.Icon
import com.github.mvysny.karibudsl.v10.button
import com.github.mvysny.karibudsl.v10.onLeftClick
import com.vaadin.flow.component.icon.VaadinIcon.EDIT
import com.vaadin.flow.router.Route

@Route(value = "pedidoEditor", layout = MainAppLayout::class)
@Caption("Editor de Pedidos")
@Icon(EDIT)
class ViewPedidoEditor: AbstractViewPedido<ViewModelPedidoEditor>() {
  override val viewModel: ViewModelPedidoEditor = ViewModelPedidoEditor(this)
  
  init {
    viewModel.updateGrid()
  
    toolbar {
      button("Remove") {
        onLeftClick {
          val pedido = gridNotas.selectedItems?.firstOrNull()
          if(pedido == null)
            showError("Não há pedido selecionado")
          else
            showQuestion("O produto será removido dessa lista e voltará a lista anterior. Tem certeza?") {
              viewModel.removePedido(pedido)
            }
        }
      }
    }
  }
  
  
}