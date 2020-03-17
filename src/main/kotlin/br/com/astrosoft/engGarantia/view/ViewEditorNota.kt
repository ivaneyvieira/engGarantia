package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.engGarantia.viewmodel.ViewModelEditorNota
import com.github.appreciated.app.layout.annotations.Caption
import com.github.appreciated.app.layout.annotations.Icon
import com.vaadin.flow.component.icon.VaadinIcon.TRUCK
import com.vaadin.flow.router.Route

@Route(value = "editor", layout = MainAppLayout::class)
@Caption("Editor de Notas")
@Icon(TRUCK)
class ViewEditorNota: AbstractViewGarantia<ViewModelEditorNota>() {
  override val viewModel: ViewModelEditorNota = ViewModelEditorNota(this)
  
  init {
    viewModel.updateGrid()
  }
}