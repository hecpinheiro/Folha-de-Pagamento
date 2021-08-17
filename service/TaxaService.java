package service;

import generico.TaxaDeServico;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
//import java.util.ArrayList;
import java.util.List;

public class TaxaService {
 public TaxaDeServico criarTaxas(String empregadoId, String dia, double valor, String taxaNome) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    LocalDate diaEmData = LocalDate.parse(dia, formatter);

    return new TaxaDeServico(empregadoId, diaEmData, valor, taxaNome);
  }

  public double getValorTaxaDeServicoEntreDatasPorEmpregadoId(
    List<TaxaDeServico> taxas,
    LocalDate inicio,
    LocalDate fim,
    String empregadoId
  ) {
    List<TaxaDeServico> taxasDoEmpregado = taxas
    .stream()
    .filter(p -> p.getEmpregadoId().equals(empregadoId))
    .filter(p ->  p.getDia().equals(inicio) ||
                  p.getDia().equals(fim) ||
                  (p.getDia().isAfter(inicio) && p.getDia().isBefore(fim)))
    .collect(Collectors.toList());

    double taxasResultado = 0.0;
    for(TaxaDeServico servico : taxasDoEmpregado) {
      taxasResultado += servico.getValor();
    }

    return taxasResultado;
  }
}
