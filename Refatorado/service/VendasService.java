package service;

import generico.Vendas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
//import java.util.ArrayList;
import java.util.List;

public class VendasService {
  public Vendas criarVendas(String empregadoId, String dia, double valorVenda) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    LocalDate diaEmData = LocalDate.parse(dia, formatter);

    return new Vendas(empregadoId, diaEmData, valorVenda);
  }

  public double getValorVendasEntreDatasPorEmpregadoId(
    LocalDate inicio,
    LocalDate fim,
    List<Vendas> vendas, 
    String empregadoId
  ) {
    List<Vendas> vendasDoEmpregado = vendas
    .stream()
    .filter(p -> p.getEmpregadoId().equals(empregadoId))
    .filter(p ->  p.getDia().equals(inicio) ||
                  p.getDia().equals(fim) ||
                  (p.getDia().isAfter(inicio) && p.getDia().isBefore(fim)))
    .collect(Collectors.toList());

    double valorTotal = 0.0;
    for(Vendas venda : vendasDoEmpregado) {
      valorTotal = venda.getValor();
    }

    return valorTotal;
  }
}
