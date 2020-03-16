package br.com.astrosoft.engGarantia.view

import com.github.appreciated.app.layout.component.applayout.LeftLayouts.LeftResponsiveHybrid
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo

@Theme(value = Lumo::class, variant = Lumo.DARK)
class MainAppLayout: KAppLayoutRouterLayout<LeftResponsiveHybrid>(LeftResponsiveHybrid::class) {
  init {
    layout("App Layout") {
      bar()
      menu("Menu", "1.0") {
        section("Sub Menu") {
          itemMenu(View3::class)
          itemMenu(View4::class)
          itemMenu(View5::class)
        }
        
        section("Sub Menu 2") {
          itemMenu(View1::class)
          itemMenu(View2::class)
        }
      }
    }
  }
}

