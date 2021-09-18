package generico;

import java.time.LocalDate;

public class HistoricoDeSalario {
  private String empregadoId;
  private LocalDate diaDoPagamento;
  private double valor;
  private String metodoDePagamento;

  public HistoricoDeSalario(String empregadoId, LocalDate diaDoPagamento, String metodoDePagamento, double valor) {
    this.empregadoId = empregadoId;
    this.diaDoPagamento = diaDoPagamento;
    this.valor = valor;
    this.metodoDePagamento = metodoDePagamento;
  }

  public String getEmpregadoId() {
    return this.empregadoId;
  }

  public LocalDate getDiaDoPagamento() {
    return this.diaDoPagamento;
  }

  public double getValor() {
    return this.valor;
  }

  public String getMetodoDePagamento() {
    return this.metodoDePagamento;
  }

  @Override
  public String toString() {
    return "Empregado ID: " + this.getEmpregadoId() + '\n' +
      "Dia do pagamento: " + this.getDiaDoPagamento() + '\n' + 
      "Valor pago: " + this.getValor() + '\n' + 
      "Metodo de pagamento: " + this.getValor() + '\n';
  }
}
