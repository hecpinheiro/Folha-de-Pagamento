package generico;

import java.time.LocalDate;

public class Vendas {
  private String empregadoId;
  private LocalDate dia;
  private double valor;

  public Vendas(String empregadoId, LocalDate dia, double valor) {
    this.empregadoId = empregadoId;
    this.dia = dia;
    this.valor = valor;
  }

  public String getEmpregadoId() {
    return this.empregadoId;
  }

  public LocalDate getDia() {
    return this.dia;
  }

  public double getValor() {
    return this.valor;
  }

  @Override
  public String toString() {
    return "EmpregadoId: " + this.empregadoId + "\n" +
           "Dia: " + this.dia + "\n" +
           "Valor venda: " + this.valor + "\n";
  }
}
