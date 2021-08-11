package empregado;

public class Comissionado extends Assalariado {
    private double percentualVendas;

    public Comissionado(String nome, String sobrenome, String endereco, boolean contribuiSindicato, double salarioMensal, double percentualVendas, String pagamentoMetodo, String idSindicato, double taxaSindical) {
        super(nome, sobrenome, endereco, contribuiSindicato, salarioMensal, pagamentoMetodo, idSindicato, taxaSindical, "BISEMANALMENTE");
        this.percentualVendas = percentualVendas;
    }

    public double getPercentualVendas() {
      return this.percentualVendas;
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
      "Salario Mensal: " + this.getSalarioMensal() + '\n' + 
      "Percentual vendas: " + this.percentualVendas + '\n' +
      "Agenda de Pagamento: " + this.getAgendaPagamento() + '\n';
  }
}

//recebem uma comissão, um percentual das vendas que realizam. 
//Eles submetem resultados de vendas que informam a data e valor da venda. 
//O percentual de comissão varia de empregado para empregado. 
//Eles são pagos a cada 2 sextas-feiras; neste momento, devem receber o equivalente de 2 semanas de salário fixo mais as comissões do período

