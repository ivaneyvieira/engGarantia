package br.com.astrosoft.engGarantia.viewmodel

class ViewModelPedidoEditor(view: IViewModelPedido): AbastractViewModelPedidoGarantia(view) {
  override fun itensGrid() = pedidoEditor
}