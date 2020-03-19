package br.com.astrosoft.engGarantia.view

import br.com.astrosoft.engGarantia.model.PedidoGarantia
import br.com.astrosoft.engGarantia.viewmodel.ViewModelPedidoGarantia
import com.github.appreciated.app.layout.annotations.Caption
import com.github.appreciated.app.layout.annotations.Icon
import com.github.mvysny.karibudsl.v10.button
import com.github.mvysny.karibudsl.v10.onLeftClick
import com.github.mvysny.karibudsl.v10.textField
import com.vaadin.flow.component.icon.VaadinIcon.EDIT
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.component.textfield.TextFieldVariant
import com.vaadin.flow.router.Route
import org.claspina.confirmdialog.ButtonOption.caption
import org.claspina.confirmdialog.ButtonOption.closeOnClick
import org.claspina.confirmdialog.ConfirmDialog

@Route(value = "pedidoGarantia", layout = MainAppLayout::class)
@Caption("Pedido Garantia")
@Icon(EDIT)
class ViewPedidoGarantia: AbstractViewPedido<ViewModelPedidoGarantia>() {
  override val viewModel: ViewModelPedidoGarantia = ViewModelPedidoGarantia(this)
  
  init {
    viewModel.updateGrid()
    toolbar {
      button("Adicionar pedido") {
        onLeftClick {
          confirmPedido {loja, numero ->
            viewModel.addPedido(loja, numero)
          }
        }
      }
      button("Nota Fiscal") {
        onLeftClick {
          val pedido = gridNotas.selectedItems?.firstOrNull()
          if(pedido == null)
            showError("Não há pedido selecioad")
          else
            confirmNota(pedido) {numero ->
              viewModel.addNota(pedido, numero)
            }
        }
      }
    }
  }
  
  fun confirmPedido(confirm: (Int?, Int?) -> Unit) {
    val formPedido = FormPedido()
    ConfirmDialog.createQuestion()
      .withCaption("Pedido")
      .withMessage(formPedido)
      .withCloseButton(Runnable {
        confirm(formPedido.loja, formPedido.numero)
      }, caption("Salva"), closeOnClick(true))
      .withCancelButton(caption("Cancela"), closeOnClick(true))
      .open()
  }
  
  fun confirmNota(pedido: PedidoGarantia, confirm: (String?) -> Unit) {
    val formNota = FormNota()
    ConfirmDialog.createQuestion()
      .withCaption("Pedido: ${pedido.storeno} ${pedido.ordno}")
      .withMessage(formNota)
      .withCloseButton(Runnable {
        confirm(formNota.numero)
      }, caption("Salva"), closeOnClick(true))
      .withCancelButton(caption("Cancela"), closeOnClick(true))
      .open()
  }
}

class FormPedido: VerticalLayout() {
  private val edtLoja: TextField = textField("Loja") {
    isAutofocus = true
    isAutoselect = true
    addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT)
  }
  private val edtNumero: TextField = textField("Número") {
    isAutofocus = true
    isAutoselect = true
    addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT)
  }
  val loja
    get() = edtLoja.value?.toIntOrNull()
  val numero
    get() = edtNumero.value?.toIntOrNull()
  
  init {
    edtLoja.focus()
  }
}

class FormNota: VerticalLayout() {
  private val edtNumero: TextField = textField("Número") {
    isAutofocus = true
    isAutoselect = true
  }
  val numero
    get() = edtNumero.value
  
  init {
    edtNumero.focus()
  }
}