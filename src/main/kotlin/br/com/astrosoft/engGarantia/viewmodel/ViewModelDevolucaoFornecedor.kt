package br.com.astrosoft.engGarantia.viewmodel

class ViewModelDevolucaoFornecedor(view: IViewModelGarantia): AbastractViewModelGarantia(view) {
  override fun itensGrid() = notasDevolucao
}