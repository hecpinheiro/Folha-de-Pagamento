package generico;

import java.time.LocalDate;

public class TaxaDeServico {
  private String empregadoId;
  private LocalDate dia;
  private String taxaNome;
  private double valor;

  public TaxaDeServico(String empregadoId, LocalDate dia, double valor, String taxaNome) {
    this.empregadoId = empregadoId;
    this.dia = dia;
    this.valor = valor;
    this.taxaNome = taxaNome;
  }

  public double getValor() {
    return this.valor;
  }

  public String getEmpregadoId() {
    return this.empregadoId;
  }

  public LocalDate getDia() {
    return this.dia;
  }

  @Override
  public String toString() {
    return "EmpregadoId: " + this.empregadoId + "\n" +
           "Dia: " + this.dia + "\n" +
           "Descrição da Taxa: " + this.taxaNome + "\n" +
           "Valor da Taxa: " + this.valor + "\n";
  }
}
