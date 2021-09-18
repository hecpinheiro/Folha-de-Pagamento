package empregado;

public class Horista extends Empregado {
  private double valorDaHora;

  public Horista(String nome, String sobrenome, String endereco, boolean contribuiSindicato, double valorDaHora, String pagamentoMetodo, String idSindicato, double taxaSindical) {
    super(nome, sobrenome, endereco, contribuiSindicato, pagamentoMetodo, idSindicato, taxaSindical, "SEMANALMENTE");
    this.valorDaHora = valorDaHora;
  }

  public double getValorDaHora() {
    return this.valorDaHora;
  }

  @Override
  public String toString() {
    return "Id: " + this.getId() + '\n' + 
      "Nome: "  + this.getNome() + '\n' +
      "Sobrenome: " + this.getSobrenome() + '\n' +
      "Endereco: " + this.getEndereco() + '\n' + 
      "Contribui ao sindicato: " + this.getContribuiSindicato() + '\n' +
      "Método de pagamento: " + this.getPagamentoMetodo() + '\n' +
      "Taxa Sindical: " + this.getTaxaSindical() + '\n' + 
      "Id sindicato: " + this.getIdSindical() + '\n' +
      "Valor da hora: " + this.valorDaHora + '\n' +
      "Agenda de Pagamento: " + this.getAgendaPagamento() + '\n';
  }
}

//Eles recebem um salário por hora trabalhada. 
//Eles submetem "cartões de ponto" todo dia para informar o número de horas trabalhadas naquele dia. 
//Se um empregado trabalhar mais do que 8 horas, deve receber 1.5 a taxa normal durante as horas extras. 
//Eles são pagos toda sexta-feira.

