package br.com.astrosoft.engGarantia.view

import com.github.appreciated.app.layout.annotations.Caption
import com.github.appreciated.app.layout.annotations.Icon
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.icon.VaadinIcon.SPLINE_CHART
import com.vaadin.flow.router.Route

@Route(value = "view2", layout = MainAppLayout::class)
@Caption("Charts")
@Icon(SPLINE_CHART)
class View2: AbstractView() {
  override val viewName: String
    get() = javaClass.name
  
  init {
    add(Button("SubContent"))
  }
}