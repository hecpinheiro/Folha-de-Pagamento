package empregado;

import java.util.UUID;

public class Empregado {
  private String id;
  private String nome;
  private String sobrenome;
  private String endereco;
  private boolean contribuiSindicato;
  private String pagamentoMetodo;
  private String idSindical;
  private double taxaSindical;
  private String agendaPagamento;
  
//metodo de pagamento, identificação sindical, taxa sindical
  public Empregado(String nome, String sobrenome, String endereco, boolean contribuiSindicato, String pagamentoMetodo, String idSindicato, double taxaSindical, String agendaPagamento) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.endereco = endereco;
    this.contribuiSindicato = contribuiSindicato;
    this.id = UUID.randomUUID().toString();
    this.pagamentoMetodo = pagamentoMetodo;
    this.idSindical = idSindicato;
    this.taxaSindical = taxaSindical;
    this.agendaPagamento = agendaPagamento;
  }

  public String getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public String getSobrenome() {
    return this.sobrenome;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public boolean getContribuiSindicato() {
    return this.contribuiSindicato;
  }

  public String getPagamentoMetodo() {
    return this.pagamentoMetodo;
  }

  public String getIdSindical() {
    return this.idSindical;
  }

  public double getTaxaSindical() {
    return this.taxaSindical;
  }

  public String getAgendaPagamento() {
    return this.agendaPagamento;
  }

  public void setAgendaPagamento(String agendaPagamento) {
    this.agendaPagamento = agendaPagamento;
  }

  public void setIdSindical(String idSindical) {
    this.idSindical = idSindical;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setPagamentoMetodo(String pagamentoMetodo) {
    this.pagamentoMetodo = pagamentoMetodo;
  }

  public void setTaxaSindical(double taxaSindical) {
    this.taxaSindical = taxaSindical;
  }

  public void setContribuiSindicato(boolean contribuiSindicato) {
    this.contribuiSindicato = contribuiSindicato;
  }

  @Override
  public String toString() {
    return "+--------------------------------------------+ \n" + 
      "\n Id: " + id + '\n' + 
      "Nome: "  + nome + '\n' +
      "Sobrenome: " + sobrenome + '\n' +
      "Contribui ao sindicato: " + this.getContribuiSindicato() + '\n' +
      "Endereco: " + endereco + '\n' + 
      "Método de pagamento: " + pagamentoMetodo + '\n' +
      "Taxa Sindical: " + taxaSindical + '\n' + 
      "Id sindicato: " + idSindical + '\n' + 
      "Agenda de Pagamento: " + agendaPagamento + '\n' +
      "+--------------------------------------------+ \n";
  }
}


// nome, endereço, tipo(horista, assalariado, assalariado comissionado)
// id