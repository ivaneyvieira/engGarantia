package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.framework.view.KAppLayoutLeftLayout
import com.vaadin.flow.component.page.Push
import com.vaadin.flow.router.BeforeEnterEvent
import com.vaadin.flow.router.BeforeEnterObserver
import com.vaadin.flow.server.PWA
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo

@Theme(value = Lumo::class, variant = Lumo.DARK)
@Push
@PWA(name = "Notas de garantia",
     shortName = "Garantia",
     iconPath = "icons/logo.png")
class MainAppLayout: KAppLayoutLeftLayout(), BeforeEnterObserver {
  init {
    layout("Devolução Garantia", "icons/logo.png") {
      bar()
      menu("Menu", "1.0") {
        section("Pedido") {
          itemMenu(ViewPedidoGarantia::class)
          itemMenu(ViewPedidoEditor::class)
        }
        section("Garantia") {
          itemMenu(ViewDevolucaoFornecedor::class)
          itemMenu(ViewEditorNota::class)
        }
      }
    }
  }
  
  override fun beforeEnter(event: BeforeEnterEvent?) {
    if(event?.navigationTarget == ViewEmpty::class.java)
      event.forwardTo(ViewDevolucaoFornecedor::class.java)
  }
}

