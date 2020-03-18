package br.com.astrosoft.engGarantia.viewmodel

class ViewModelDevolucaoFornecedor(view: IViewModelGarantia): AbastractViewModelDevolucaoGarantia(view) {
  override fun itensGrid() = notasDevolucao
}