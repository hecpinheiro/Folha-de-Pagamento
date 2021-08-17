package service;

import generico.CartaoDePonto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
//import java.util.ArrayList;
import java.util.List;

public class CartaoDePontoService {
  public CartaoDePonto criarCartaoPonto(String empregadoId, String dia, double horasTrabalhadas) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    LocalDate diaEmData = LocalDate.parse(dia, formatter);

    return new CartaoDePonto(empregadoId, diaEmData, horasTrabalhadas);
  }

  public double getHorasTrabalhadasEntreDatasPorEmpregadoId(
    LocalDate inicio,
    LocalDate fim,
    List<CartaoDePonto> cartaoDePonto, 
    String empregadoId
  ) {
    List<CartaoDePonto> pontoDoEmpregado = cartaoDePonto
      .stream()
      .filter(p -> p.getEmpregadoId().equals(empregadoId))
      .filter(p ->  p.getDia().equals(inicio) ||
                    p.getDia().equals(fim) ||
                    (p.getDia().isAfter(inicio) && p.getDia().isBefore(fim)))
      .collect(Collectors.toList());

    double horasTrabalhadas = 0.0;
    for(CartaoDePonto ponto : pontoDoEmpregado) {
      if(ponto.getHorasTrabalhadas() >= 8) {
        horasTrabalhadas += 8.0;
      } else {
        horasTrabalhadas += ponto.getHorasTrabalhadas();
      }
    }
    return horasTrabalhadas;
  }

  public double getHorasExtrasTrabalhadasEntreDatasPorEmpregadoId(
    LocalDate inicio,
    LocalDate fim,
    List<CartaoDePonto> cartaoDePonto, 
    String empregadoId
  ) {
    List<CartaoDePonto> pontoDoEmpregado = cartaoDePonto
      .stream()
      .filter(p -> p.getEmpregadoId().equals(empregadoId))
      .filter(p ->  p.getDia().equals(inicio) ||
                    p.getDia().equals(fim) ||
                    (p.getDia().isAfter(inicio) && p.getDia().isBefore(fim)))
      .collect(Collectors.toList());

    double horasTrabalhadas = 0.0;
    for(CartaoDePonto ponto : pontoDoEmpregado) {
      if(ponto.getHorasTrabalhadas() > 8) {
        horasTrabalhadas += ponto.getHorasTrabalhadas() - 8.0;
      }
    }
    return horasTrabalhadas;
  }
}
