package empregado;

public class Assalariado extends Empregado {
    
    public static class Builder{
      
     private String nome;
     private String sobrenome; 
     private String endereco;
     private boolean contribuiSindicato;
     private double salarioMensal;
     private String pagamentoMetodo;
     private String idSindicato;
     private double taxaSindical;
     private String agendaPagamento;

     public Builder comNome(String nome){
       this.nome = nome;
       return this;
     }
     public Builder comSobrenome(String sobrenome){
       this.sobrenome = sobrenome;
       return this;
     }
     public Builder comEndereco(String endereco){
      this.endereco = endereco;
      return this;
     }
     public Builder comContribuicaoSindical(boolean contribuiSindicato){
      this.contribuiSindicato = contribuiSindicato;
      return this;
     }
     public Builder comSalarioMensal(double salarioMensal){
      this.salarioMensal = salarioMensal;
      return this;
     }
     public Builder comPagamentoMetodo(String pagamentoMetodo){
      this.pagamentoMetodo = pagamentoMetodo;
      return this;
     }
     public Builder comIdSindicato(String idSindicato){
      this.idSindicato = idSindicato;
      return this;
     }
     public Builder comTaxaSindical(double taxaSindical){
      this.taxaSindical = taxaSindical;
      return this;
     }
     public Builder comAgendaPagamento(String agendaPagamento){
      this.agendaPagamento = agendaPagamento;
      return this;
     }

     public Assalariado build(){
       Assalariado assalariado = new Assalariado(this.nome, this.sobrenome, this.endereco, this.contribuiSindicato, 
                                                this.salarioMensal, this.pagamentoMetodo, this.idSindicato, 
                                                this.taxaSindical, this.agendaPagamento);
        return assalariado;   
     } 
    }
    
    

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
