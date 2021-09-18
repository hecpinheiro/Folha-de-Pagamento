package generico;

import java.time.LocalDate;

public class CartaoDePonto {
  private String empregadoId;
  private LocalDate dia;
  private double horasTrabalhadas;

  public CartaoDePonto(String empregadoId, LocalDate dia, double horasTrabalhadas) {
    this.empregadoId = empregadoId;
    this.dia = dia;
    this.horasTrabalhadas = horasTrabalhadas;
  }

  public String getEmpregadoId() {
    return this.empregadoId;
  }
  
  public double getHorasTrabalhadas() {
    return this.horasTrabalhadas;
  }

  public LocalDate getDia() {
    return this.dia;
  }

  @Override
  public String toString() {
    return "EmpregadoId: " + this.empregadoId + "\n" +
           "Dia: " + this.dia + "\n" +
           "Horas Trabalhadas: " + this.horasTrabalhadas + "\n";
  }
}