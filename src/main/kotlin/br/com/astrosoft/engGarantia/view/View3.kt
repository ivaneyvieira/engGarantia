package br.com.astrosoft.engGarantia.view

import com.github.appreciated.app.layout.annotations.Caption
import com.github.appreciated.app.layout.annotations.Icon
import com.vaadin.flow.component.icon.VaadinIcon.CONNECT
import com.vaadin.flow.router.Route

@Route(value = "view3", layout = MainAppLayout::class)
@Caption("Contact")
@Icon(CONNECT)
class View3: AbstractView() {
  override val viewName: String
    get() = javaClass.name
}