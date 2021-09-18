package service;

import java.util.List;
import java.util.Scanner;
import database.Database;
import java.util.Optional;
import generico.CartaoDePonto;
import generico.TaxaDeServico;
import generico.Vendas;
import menu.MenuFactory;
import service.interfaces.AcaoMenu;
import generico.HistoricoDeSalario;
import empregado.Empregado;
import empregado.Horista;
import empregado.Assalariado;
import empregado.Comissionado;

public class MainService {
  private Database database = Database.obterInstancia();

  private Scanner input = new Scanner(System.in);
  private CartaoDePontoService cartaoDePontoService = new CartaoDePontoService();
  private VendasService vendasService = new VendasService();
  private TaxaService taxaService = new TaxaService();
  private EmpregadoService empregadoService = new EmpregadoService();
  private PagamentoService pagamentoService = new PagamentoService();

  public void listarEmpregados() {
    for(Empregado x : this.database.obterEmpregados()) {
      System.out.println(x);
    }
  }

  private void listarPagamentos() {
    for(HistoricoDeSalario x : this.database.obterHistoricoDeSalarios()) {
      System.out.println(x);
      System.out.println("----------------------------------------------");
    }
  }

  public void alterarAgendaPagamento() {
    String id = obterEmpregadoId();
    if(id.equals("NOT_FOUND")) return;
    Empregado empregado = empregadoService.getEmpregadoPorId(id);

    AcaoMenu menu = new MenuFactory().create("agendaPagamento");
    menu.exibirMenu();
    

    int novaAgenda = Integer.parseInt(input.nextLine());
    switch(novaAgenda) {
      case 1:
        empregado.setAgendaPagamento("MENSALMENTE");
        System.out.println("+--------------------------------------------+");
        System.out.println("| Agenda de pagamente modificada             |");
        System.out.println("+--------------------------------------------+");
        break;
      case 2:
        empregado.setAgendaPagamento("SEMANALMENTE");
        System.out.println("+--------------------------------------------+");
        System.out.println("| Agenda de pagamente modificada             |");
        System.out.println("+--------------------------------------------+");
        break;
      case 3:
        empregado.setAgendaPagamento("BISEMANALMENTE");
        System.out.println("+--------------------------------------------+");
        System.out.println("| Agenda de pagamente modificada             |");
        System.out.println("+--------------------------------------------+");
        break;
      default:
      System.out.println("+--------------------------------------------+");
      System.out.println("| Agenda de pagamente inválida               |");
      System.out.println("+--------------------------------------------+");
        break;
    }
  }

  public void alterarDados() {
        

    String id = obterEmpregadoId();
    if(id.equals("NOT_FOUND")) return;
    Empregado empregado = empregadoService.getEmpregadoPorId(id);


    AcaoMenu menu = new MenuFactory().create("alterarDados");
    menu.exibirMenu();

    System.out.print("> ");

    int opcaoalterar = Integer.parseInt(input.nextLine());
    
    switch(opcaoalterar){
        case 1:
            System.out.print("| Novo nome: ");
            String novoNome = input.nextLine();
            empregado.setNome(novoNome);
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Alteração concluída!                             |");
            System.out.println("+--------------------------------------------------+");
            break;
        case 2:
            System.out.print("| Novo sobrenome: ");
            String novoSobrenome = input.nextLine();
            empregado.setSobrenome(novoSobrenome);
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Alteração concluída!                             |");
            System.out.println("+--------------------------------------------------+");       
            break;             
        case 3:
            System.out.println("| Novo método de pagamento: ");
            System.out.println("| (1) Cheque pelos correios ");
            System.out.println("| (2) Cheque em mãos ");
            System.out.println("| (3) Depósito em conta bancária ");
            
            String pagamentoMetodo = "";
            int opcaoPagamento;
            boolean executar = true;
            
            while(executar){
                opcaoPagamento = Integer.parseInt(input.nextLine());
                switch(opcaoPagamento){
                    case 1:
                        pagamentoMetodo = "Cheque pelos correios";
                        executar = false;
                        break;
                    case 2:
                        pagamentoMetodo = "Cheque em mãos";
                        executar = false;
                        break;
                    case 3:
                        pagamentoMetodo = "Depósito em conta bancária";
                        executar = false;
                        break;
                    default:
                        System.out.print("Digite uma opção válida! \n");
                        break;
                }
            }
            empregado.setPagamentoMetodo(pagamentoMetodo);
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Alteração concluída!                             |");
            System.out.println("+--------------------------------------------------+");
            break;
        case 4:
            System.out.print("Novo tipo de funcinário: ");

            break;
        case 5:
            System.out.print("| Novo ID sindical: ");
            String novoIdSindical = input.nextLine();
            empregado.setIdSindical(novoIdSindical);
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Alteração concluída!                             |");
            System.out.println("+--------------------------------------------------+");
            break;             
        case 6:
            System.out.print("| Novo vínculo com o sindicato (S ou N): ");
            String novoVinculoSindical = input.nextLine();
            boolean temSindicato = novoVinculoSindical.equals("S") ? true : false;
            empregado.setContribuiSindicato(temSindicato);
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Alteração concluída!                             |");
            System.out.println("+--------------------------------------------------+");
            break;
        case 7:
            System.out.print("| Nova taxa sindical: ");
            double novaTaxaSindical = Double.parseDouble(input.nextLine());
            empregado.setTaxaSindical(novaTaxaSindical);
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Alteração concluída!                             |");
            System.out.println("+--------------------------------------------------+");
            break;
        default:
            break;   
      }   
  }

  public void lancarVenda() {
    
    String id = obterEmpregadoId();
    if(id.equals("NOT_FOUND")) return;

    AcaoMenu menu = new MenuFactory().create("lancarVendas");
    menu.exibirMenu();

    System.out.println("| Data da venda (dd/mm/yyyy):                |");
    System.out.print("> ");
    String data = input.nextLine();

    System.out.println("| Valor da venda:                            |");
    System.out.print("> ");
    double vendaValor = Double.parseDouble(input.nextLine());

    Vendas venda = vendasService.criarVendas(id, data, vendaValor);
    this.database.addVendas(venda);
    System.out.println("| Venda adicionada!                          |");
  }

  public void lancarTaxaServico() {
    
    String id = obterEmpregadoId();
    if(id.equals("NOT_FOUND")) return;

    AcaoMenu menu = new MenuFactory().create("lancarTaxa");
    menu.exibirMenu();

    System.out.println("| Data à adicionar a taxa de serviço (dd/mm/yyyy): |");
    System.out.print("> ");
    String dia = input.nextLine();

    System.out.println("| Descrição da Taxa de Serviço:              |");
    System.out.print("> ");
    String taxaNome = input.nextLine();

    System.out.println("| Valor da taxa de serviço:                  |");
    System.out.print("> ");
    double taxaValor = Double.parseDouble(input.nextLine());

    TaxaDeServico taxaDeServico = taxaService.criarTaxas(id, dia, taxaValor, taxaNome);
    this.database.addTaxas(taxaDeServico);
    System.out.println("| Lançamento concluído!                      |");
  }

  private String obterEmpregadoId() {
    System.out.print("ID do Empregado: ");
    String id = input.nextLine().trim();
    Optional<Empregado> optionalEmpregado = this.database.obterEmpregados().stream().filter(empregado -> (empregado.getId().equals(id))).findFirst();

    if(!optionalEmpregado.isPresent()) {
      System.out.println("Empregado com ID: " + id + " não existe!");
      return "NOT_FOUND";
    }
    return id;
  }

  public void lancarCartaoPonto() {

    String id = obterEmpregadoId();
    if(id.equals("NOT_FOUND")) return;

    AcaoMenu menu = new MenuFactory().create("lancarCartao");
    menu.exibirMenu();

    System.out.println("| Dia trabalhado (dd/mm/yyyy):               |");
    System.out.print("> ");
    String dia = input.nextLine();

    System.out.println("| Horas trabalhadas:                         | ");
    System.out.print("> ");
    double horasTrabalhadas = Double.parseDouble(input.nextLine());

    CartaoDePonto cartaoDePonto = cartaoDePontoService.criarCartaoPonto(id, dia, horasTrabalhadas);
    this.database.addCartao(cartaoDePonto);
    System.out.println("| Lançamento concluído!                      |");
  }

  public void executarFolhaDePagamento(){

    AcaoMenu menu = new MenuFactory().create("executarFolhaDePagamento");
    menu.exibirMenu();

    System.out.println("| Dia para executar a Folha de pagamento (dd/mm/yyyy): ");
    System.out.print("> ");    
    String dia = input.nextLine();

    List<HistoricoDeSalario> lancamentos = pagamentoService.calcularFolha(dia);
    System.out.println("+--------------------------------------------+");  
    System.out.println("Folha de pagamento executada com sucesso. \nForam feitos " + lancamentos.size() + " lancamentos.");
    
    this.database.addHistoricoDeSalarios(lancamentos);
    this.listarPagamentos();
  }

  public void removerEmpregado() {

    AcaoMenu menu = new MenuFactory().create("removerEmpregado");
    menu.exibirMenu();

    System.out.println("| ID do Empregado que à ser removido:        |");
    System.out.print("> ");
 

    String id = input.nextLine().trim();
    
    boolean result = this.database.removerEmpregado(id);

    if(result) {
      System.out.println("+--------------------------------------------+");  
      System.out.println("| Empregado com ID: " + id + " removido!");
      return;
    }
    System.out.println("+--------------------------------------------+");  
    System.out.println("| Empregado com ID: " + id + " não existe!");
    
  }

  public void adicionarEmpregadoHorista() {
    Empregado dadosBase = obterEmpregado();

    System.out.println("| Valor da hora:                             |");
    System.out.print("> ");
    double valorDaHora = Double.parseDouble(input.nextLine());
    

    Horista empregado = new Horista(dadosBase.getNome(), 
                                    dadosBase.getSobrenome(), 
                                    dadosBase.getEndereco(), 
                                    dadosBase.getContribuiSindicato(), 
                                    valorDaHora,
                                    dadosBase.getPagamentoMetodo(),
                                    dadosBase.getIdSindical(),
                                    dadosBase.getTaxaSindical());
    this.database.addEmpregado(empregado);

    System.out.println("+--------------------------------------------+");
    System.out.println("| Empregado adicionado!                      |");
  }

  public void adicionarEmpregadoAssalariado() {
    Empregado dadosBase = obterEmpregado();
    System.out.println("| Salário mensal:                            |");
    System.out.print("> ");
    double salarioMensal = Double.parseDouble(input.nextLine());

    Assalariado empregado = new Assalariado.Builder()
                                .comNome(dadosBase.getNome())
                                .comSobrenome(dadosBase.getSobrenome())
                                .comEndereco(dadosBase.getEndereco())
                                .comContribuicaoSindical(dadosBase.getContribuiSindicato())
                                .comSalarioMensal(salarioMensal)
                                .comPagamentoMetodo(dadosBase.getPagamentoMetodo())
                                .comIdSindicato(dadosBase.getIdSindical())
                                .comTaxaSindical(dadosBase.getTaxaSindical())
                                .comAgendaPagamento("MENSALMENTE")
                                .build();
                                

    this.database.addEmpregado(empregado);

    System.out.println("+--------------------------------------------+");
    System.out.println("| Empregado adicionado!                      |");

    
  }

  public void adicionarEmpregadoComissionado() {
    Empregado dadosBase = obterEmpregado();

    System.out.println("| Salário mensal:                            |");
    System.out.print("> ");
    double salarioMensal = Double.parseDouble(input.nextLine());

    System.out.println("| Percentual comissão:                       |");
    System.out.print("> ");
    double percentualComissao = Double.parseDouble(input.nextLine());

    Comissionado empregado = new Comissionado(dadosBase.getNome(), 
                                              dadosBase.getSobrenome(), 
                                              dadosBase.getEndereco(), 
                                              dadosBase.getContribuiSindicato(), 
                                              salarioMensal, 
                                              percentualComissao,
                                              dadosBase.getPagamentoMetodo(),
                                              dadosBase.getIdSindical(),
                                              dadosBase.getTaxaSindical());
    this.database.addEmpregado(empregado);

    System.out.println("+--------------------------------------------+");
    System.out.println("| Empregado adicionado!                      |");
  }

  private Empregado obterEmpregado() {
    System.out.println("| Nome do empregado:                         |");
    System.out.print("> ");
    String nome = input.nextLine();
    //System.out.println();

    System.out.println("| Sobrenome do empregado:                    |");
    System.out.print("> ");
    String sobrenome = input.nextLine();
    //System.out.println();

    System.out.println("| Endereço do empregado:                     |");
    System.out.print("> ");
    String endereco = input.nextLine();
    //System.out.println();

    System.out.println("| Contribui ao sindicato? (S) ou (N):        |");
    System.out.print("> ");
    String contribuiSindicato = input.nextLine();
    //System.out.println();

    System.out.println("+--------------------------------------------+");
    System.out.print("| Escolha o tipo de pagamento:             |\n");
    System.out.println("+--------------------------------------------+");
    System.out.print("| (1) Cheque pelos correios                |\n");
    System.out.print("| (2) Cheque em mãos                       |\n");
    System.out.print("| (3) Depósito em conta bancária           |\n");
    System.out.println("+--------------------------------------------+");
    String pagamentoMetodo = "";
    int opcaoPagamento;
    boolean executar = true;

    while(executar){
        opcaoPagamento = Integer.parseInt(input.nextLine());
        switch(opcaoPagamento){
            case 1:
                pagamentoMetodo = "Cheque pelos correios";
                executar = false;
                break;
            case 2:
                pagamentoMetodo = "Cheque em mãos";
                executar = false;
                break;
            case 3:
                pagamentoMetodo = "Depósito em conta bancária";
                executar = false;
                break;
            default:
                System.out.print("| Digite uma opção válida.                 |\n");
                System.out.println("+--------------------------------------------+");
                break;
        }
    }

    System.out.println();

    String idSindical = "";
    double taxaSindical = 0;

    boolean temSindicato = contribuiSindicato.equals("S") ? true : false;
    if(temSindicato){
        System.out.println("| Digite o seu ID sindical:                  |");
        idSindical = input.nextLine();
        System.out.println();
    
        System.out.println("| Valor da taxa sindical:                    |");
        taxaSindical = Double.parseDouble(input.nextLine());
        System.out.println();
    }
    return new Empregado(nome, sobrenome, endereco, temSindicato, pagamentoMetodo, idSindical, taxaSindical, "teste");
  }
 
}
