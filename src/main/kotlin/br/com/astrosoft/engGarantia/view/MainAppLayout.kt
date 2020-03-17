package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.framework.view.KAppLayoutRouterLayout
import com.github.appreciated.app.layout.component.applayout.LeftLayouts.LeftResponsiveHybrid
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo

@Theme(value = Lumo::class, variant = Lumo.DARK)
class MainAppLayout: KAppLayoutRouterLayout<LeftResponsiveHybrid>(LeftResponsiveHybrid::class) {
  init {
    layout("Devolução Garantia") {
      bar()
      menu("Menu", "1.0") {
        section("Garantia") {
          itemMenu(ViewDevolucaoFornecedor::class)
          itemMenu(ViewEditorNota::class)
        }
      }
    }
  }
}

