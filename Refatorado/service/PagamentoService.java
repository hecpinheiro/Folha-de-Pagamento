package service;

import java.util.List;
import database.Database;
import java.time.LocalDate;
//import java.time.YearMonth;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import java.util.ArrayList;
import generico.HistoricoDeSalario;
import generico.CartaoDePonto;
import generico.TaxaDeServico;
import generico.Vendas;
import empregado.Empregado;
import empregado.Horista;
import empregado.Assalariado;
import empregado.Comissionado;


public class PagamentoService {
  private Database database = Database.obterInstancia();
  private CartaoDePontoService cartaoDePontoService = new CartaoDePontoService();
  private TaxaService taxasService = new TaxaService();
  private VendasService vendasService = new VendasService();

  public List<HistoricoDeSalario> calcularFolha(String dia) {
    List<HistoricoDeSalario> pagamentosFolha = new ArrayList<HistoricoDeSalario>();
    LocalDate data = this.toLocalDateFromString(dia);

    for(Empregado empregado : this.database.obterEmpregados()) {
      HistoricoDeSalario pagamento = null;
      if(empregado instanceof Horista) {
        pagamento = this.calcularFolhaHorista(data, empregado, this.database.obterCartoes(), this.database.obterTaxas());
      } else if(empregado instanceof Comissionado) {
        pagamento = this.calcularFolhaComissionado(data, empregado, this.database.obterVendas(), this.database.obterTaxas());
      } else if(empregado instanceof Assalariado) {
        pagamento = this.calcularFolhaAssalariado(data, empregado, this.database.obterTaxas());
      }

      if(pagamento != null) {
        pagamentosFolha.add(pagamento);
      }
    }

    return pagamentosFolha;
  }

  private LocalDate toLocalDateFromString(String data) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    return LocalDate.parse(data, formatter);
  }

  private HistoricoDeSalario calcularFolhaHorista(
    LocalDate data,
    Empregado empregado,
    List<CartaoDePonto> cartaoDePontos,
    List<TaxaDeServico> taxasDeServico
  ) {
    LocalDate dataInicio = null;
    boolean devePagar = false;

    if(empregado.getAgendaPagamento().equals("MENSALMENTE")) {
      dataInicio = this.dataInicioMensalmente(data);
      devePagar = this.ehMensalmente(data);
    } else if(empregado.getAgendaPagamento().equals("SEMANALMENTE")) {
      dataInicio = this.dataInicioSemanalmente(data);
      devePagar = this.ehSemanalmente(data);
    } else if(empregado.getAgendaPagamento().equals("BISEMANALMENTE")) {
      dataInicio = this.dataInicioBisemanalmente(data);
      devePagar = this.ehBisemanalmente(data);
    }
    
    if(devePagar) {
      Horista horista = (Horista) empregado;

      double horasNormais = this.cartaoDePontoService.getHorasTrabalhadasEntreDatasPorEmpregadoId(
        dataInicio,
        data,
        cartaoDePontos,
        empregado.getId()
      );

      double horasExtras = this.cartaoDePontoService.getHorasExtrasTrabalhadasEntreDatasPorEmpregadoId(
        dataInicio,
        data,
        cartaoDePontos,
        empregado.getId()
      );

      double valorHorasNormais = horasNormais * horista.getValorDaHora();
      double valorHorasExtras = horasExtras * 1.5 * horista.getValorDaHora();
      double taxasDeServicoTotal = this.taxasService.getValorTaxaDeServicoEntreDatasPorEmpregadoId(
        taxasDeServico,
        dataInicio,
        data,
        empregado.getId()
      );
      double taxaSindical = empregado.getTaxaSindical();

      double salario = valorHorasExtras + valorHorasNormais - taxasDeServicoTotal - taxaSindical;
      
      return new HistoricoDeSalario(empregado.getId(), data, empregado.getPagamentoMetodo(), salario);
    }

    return null;
  }

  private HistoricoDeSalario calcularFolhaAssalariado(
    LocalDate data,
    Empregado empregado,
    List<TaxaDeServico> taxasDeServico
  ) {
    LocalDate dataInicio = null;
    boolean devePagar = false;

    if(empregado.getAgendaPagamento().equals("MENSALMENTE")) {
      dataInicio = this.dataInicioMensalmente(data);
      devePagar = this.ehMensalmente(data);
    } else if(empregado.getAgendaPagamento().equals("SEMANALMENTE")) {
      dataInicio = this.dataInicioSemanalmente(data);
      devePagar = this.ehSemanalmente(data);
    } else if(empregado.getAgendaPagamento().equals("BISEMANALMENTE")) {
      dataInicio = this.dataInicioBisemanalmente(data);
      devePagar = this.ehBisemanalmente(data);
    }
    
    if(devePagar) {
      Assalariado assalariado = (Assalariado) empregado;

      double taxasDeServicoTotal = this.taxasService.getValorTaxaDeServicoEntreDatasPorEmpregadoId(
        taxasDeServico,
        dataInicio,
        data,
        empregado.getId()
      );
      double taxaSindical = empregado.getTaxaSindical();

      double salario = assalariado.getSalarioMensal() - taxaSindical - taxasDeServicoTotal;

      return new HistoricoDeSalario(empregado.getId(), data, empregado.getPagamentoMetodo(), salario);
    }

    return null;
  }

  public HistoricoDeSalario calcularFolhaComissionado(
    LocalDate data,
    Empregado empregado,
    List<Vendas> vendas,
    List<TaxaDeServico> taxasDeServico
  ) {
    LocalDate dataInicio = null;
    boolean devePagar = false;

    if(empregado.getAgendaPagamento().equals("MENSALMENTE")) {
      dataInicio = this.dataInicioMensalmente(data);
      devePagar = this.ehMensalmente(data);
    } else if(empregado.getAgendaPagamento().equals("SEMANALMENTE")) {
      dataInicio = this.dataInicioSemanalmente(data);
      devePagar = this.ehSemanalmente(data);
    } else if(empregado.getAgendaPagamento().equals("BISEMANALMENTE")) {
      dataInicio = this.dataInicioBisemanalmente(data);
      devePagar = this.ehBisemanalmente(data);
    }

    if(devePagar) {
      Comissionado comissionado = (Comissionado) empregado;

      double taxasDeServicoTotal = this.taxasService.getValorTaxaDeServicoEntreDatasPorEmpregadoId(
        taxasDeServico,
        dataInicio,
        data,
        empregado.getId()
      );
      double taxaSindical = empregado.getTaxaSindical();
      double vendasTotal = this.vendasService.getValorVendasEntreDatasPorEmpregadoId(
        dataInicio,
        data, 
        vendas, 
        empregado.getId()
      );
      double valorVendas = (comissionado.getPercentualVendas() / 100.0) * vendasTotal;
      double salario = valorVendas + comissionado.getSalarioMensal() - taxaSindical - taxasDeServicoTotal;
      return new HistoricoDeSalario(empregado.getId(), data, empregado.getPagamentoMetodo(), salario);
    }

    return null;
  }

  private boolean ehMensalmente(LocalDate data) {
    LocalDate ultimoDia = data.with(lastDayOfMonth());
    if(ultimoDia.equals(data)) return true;
    return false;
  }

  private boolean ehSemanalmente(LocalDate data) {
    if(data.getDayOfWeek() == DayOfWeek.FRIDAY) return true;
    return false;
  }

  private boolean ehBisemanalmente(LocalDate data) {
    LocalDate inicio = data.with(firstInMonth(DayOfWeek.FRIDAY));
    if(inicio.plusDays(7).equals(data) || inicio.plusDays(21).equals(data)) {
      return true;
    }
    return false;
  }

  private LocalDate dataInicioMensalmente(LocalDate data) {
    return data.withDayOfMonth(1);
  }

  private LocalDate dataInicioBisemanalmente(LocalDate data) {
    LocalDate inicio = data.with(firstInMonth(DayOfWeek.FRIDAY));
    return inicio.plusDays(7).equals(data) 
    ? inicio.plusDays(7)
    : inicio.plusDays(21);
  }

  private LocalDate dataInicioSemanalmente(LocalDate data) {
    return data.minusDays(7);
  }

}
