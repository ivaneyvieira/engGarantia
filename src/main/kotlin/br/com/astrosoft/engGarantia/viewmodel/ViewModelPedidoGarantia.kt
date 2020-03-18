package br.com.astrosoft.engGarantia.viewmodel

class ViewModelPedidoGarantia(view: IViewModelPedido): AbastractViewModelPedidoGarantia(view) {
  override fun itensGrid() = pedidoGarantia
}