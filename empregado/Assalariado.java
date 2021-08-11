package empregado;

public class Assalariado extends Empregado {
    private double salarioMensal; 

    public Assalariado(String nome, String sobrenome, String endereco, boolean contribuiSindicato, double salarioMensal, String pagamentoMetodo, String idSindicato, double taxaSindical, String agendaPagamento) {
        super(nome, sobrenome, endereco, contribuiSindicato, pagamentoMetodo, idSindicato, taxaSindical, agendaPagamento);
        this.salarioMensal = salarioMensal;
    }

    public double getSalarioMensal() {
      return this.salarioMensal;
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
      "Salario Mensal: " + this.salarioMensal + '\n' +
      "Agenda de Pagamento: " + this.getAgendaPagamento() + '\n';
  }
}
