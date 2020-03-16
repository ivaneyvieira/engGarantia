package br.com.astrosoft.engGarantia.view

import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode
import com.vaadin.flow.component.orderedlayout.HorizontalLayout

abstract class AbstractView: HorizontalLayout() {
  abstract val viewName: String
  
  init {
    val layout = HorizontalLayout()
    layout.setSizeFull()
    layout.isMargin = false
    layout.add(Label("< $viewName >"))
    layout.alignItems = CENTER
    layout.justifyContentMode = JustifyContentMode.CENTER
    add(layout)
    isMargin = false
    setSizeFull()
    element
      .style["overflow"] = "auto"
  }
}