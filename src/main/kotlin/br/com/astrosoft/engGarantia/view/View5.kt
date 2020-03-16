package br.com.astrosoft.engGarantia.view

import com.github.appreciated.app.layout.annotations.Caption
import com.github.appreciated.app.layout.annotations.Icon
import com.vaadin.flow.component.icon.VaadinIcon.MENU
import com.vaadin.flow.router.Route

@Route(value = "view5", layout = MainAppLayout::class)
@Caption("Menu")
@Icon(MENU)
class View5: AbstractView() {
  override val viewName: String
    get() = javaClass.name
}