package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.engGarantia.viewmodel.ViewModelDevolucaoEditorNota
import com.github.appreciated.app.layout.annotations.Caption
import com.github.appreciated.app.layout.annotations.Icon
import com.vaadin.flow.component.icon.VaadinIcon.EDIT
import com.vaadin.flow.router.Route

@Route(value = "editor", layout = MainAppLayout::class)
@Caption("Editor de Notas")
@Icon(EDIT)
class ViewEditorNota: AbstractViewGarantia<ViewModelDevolucaoEditorNota>() {
  override val viewModel: ViewModelDevolucaoEditorNota = ViewModelDevolucaoEditorNota(this)
  
  init {
    viewModel.updateGrid()
  }
}