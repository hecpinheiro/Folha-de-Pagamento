package service;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;
import generico.CartaoDePonto;
import generico.TaxaDeServico;
import generico.Vendas;
import generico.HistoricoDeSalario;
import empregado.Empregado;
import empregado.Horista;
import empregado.Assalariado;
import empregado.Comissionado;

public class MainService {
  private List<Empregado> empregados = new ArrayList<Empregado>();
  private List<CartaoDePonto> cartoesDePonto = new ArrayList<CartaoDePonto>();
  private List<Vendas> vendas = new ArrayList<Vendas>();
  private List<TaxaDeServico> taxaDeServicos = new ArrayList<TaxaDeServico>();
  private List<HistoricoDeSalario> historicoSalario = new ArrayList<HistoricoDeSalario>();

  private Scanner input = new Scanner(System.in);
  private CartaoDePontoService cartaoDePontoService = new CartaoDePontoService();
  private VendasService vendasService = new VendasService();
  private TaxaService taxaService = new TaxaService();
  private EmpregadoService empregadoService = new EmpregadoService();
  private PagamentoService pagamentoService = new PagamentoService();

  public void listarEmpregados() {
    for(Empregado x : empregados) {
      System.out.println(x);
    }
  }

  private void listarPagamentos() {
    for(HistoricoDeSalario x : historicoSalario) {
      System.out.println(x);
      System.out.println("----------------------------------------------");
    }
  }

  public void alterarAgendaPagamento() {
    String id = obterEmpregadoId();
    if(id.equals("NOT_FOUND")) return;
    Empregado empregado = empregadoService.getEmpregadoPorId(empregados, id);

    System.out.println("+--------------------------------------------+");
    System.out.println("|        ALTERAR AGENDA DE PAGAMENTO         |");
    System.out.println("+--------------------------------------------+");
    System.out.println("| Selecione qual a nova agenda de pagamento: |");
    System.out.println("+--------------------------------------------+");
    System.out.println("| (1) Mensalmente                            |");
    System.out.println("| (2) Semanalmente                           |");
    System.out.println("| (3) Bisemanalmente                         |");
    System.out.println("+--------------------------------------------+");
    

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
        
    System.out.println("+--------------------------------------------------+");
    System.out.println("|          ALTERAR DADOS DE UM EMPREGADO           |");
    System.out.println("+--------------------------------------------------+");

    String id = obterEmpregadoId();
    if(id.equals("NOT_FOUND")) return;
    Empregado empregado = empregadoService.getEmpregadoPorId(empregados, id);


    System.out.println("+--------------------------------------------------+");
    System.out.println("| Selecione qual dado do empregado deseja alterar? |");
    System.out.println("+--------------------------------------------------+");
    System.out.println("| (1) Alterar nome                                 |");
    System.out.println("| (2) Alterar endereço                             |");
    System.out.println("| (3) Alterar Método de pagamento                  |");
    System.out.println("| (4) Alterar tipo de funcionário                  |");
    System.out.println("| (5) Alterar ID sindical                          |");
    System.out.println("| (6) Alterar vínculo com o sindicato              |");
    System.out.println("| (7) Alterar taxa sindical                        |");
    System.out.println("+--------------------------------------------------+");
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
    
    System.out.println("+--------------------------------------------+");
    System.out.println("|        LANÇAR UM RESULTADO DE VENDA        |");
    System.out.println("+--------------------------------------------+");
    
    String id = obterEmpregadoId();
    if(id.equals("NOT_FOUND")) return;

    System.out.println("| Data da venda (dd/mm/yyyy):                |");
    System.out.print("> ");
    String data = input.nextLine();

    System.out.println("| Valor da venda:                            |");
    System.out.print("> ");
    double vendaValor = Double.parseDouble(input.nextLine());

    Vendas venda = vendasService.criarVendas(id, data, vendaValor);
    vendas.add(venda);
    System.out.println("| Venda adicionada!                          |");
  }

  public void lancarTaxaServico() {
    
    System.out.println("+--------------------------------------------+");
    System.out.println("|         LANÇAR UM TAXA DE SERVIÇO          |");
    System.out.println("+--------------------------------------------+");

    String id = obterEmpregadoId();
    if(id.equals("NOT_FOUND")) return;

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
    taxaDeServicos.add(taxaDeServico);
    System.out.println("| Lançamento concluído!                      |");
  }

  private String obterEmpregadoId() {
    System.out.print("ID do Empregado: ");
    String id = input.nextLine().trim();
    Optional<Empregado> optionalEmpregado = empregados.stream().filter(empregado -> (empregado.getId().equals(id))).findFirst();

    if(!optionalEmpregado.isPresent()) {
      System.out.println("Empregado com ID: " + id + " não existe!");
      return "NOT_FOUND";
    }
    return id;
  }

  public void lancarCartaoPonto() {

    System.out.println("+--------------------------------------------+");
    System.out.println("|         LANÇAR UM CARTÃO DE PONTOS         |");
    System.out.println("+--------------------------------------------+");

    String id = obterEmpregadoId();
    if(id.equals("NOT_FOUND")) return;

    System.out.println("| Dia trabalhado (dd/mm/yyyy):               |");
    System.out.print("> ");
    String dia = input.nextLine();

    System.out.println("| Horas trabalhadas:                         | ");
    System.out.print("> ");
    double horasTrabalhadas = Double.parseDouble(input.nextLine());

    CartaoDePonto cartaoDePonto = cartaoDePontoService.criarCartaoPonto(id, dia, horasTrabalhadas);
    cartoesDePonto.add(cartaoDePonto);
    System.out.println("| Lançamento concluído!                      |");
  }

  public void executarFolhaDePagamento(){
    System.out.println("+--------------------------------------------+");
    System.out.println("|        EXECUTAR A FOLHA DE PAGAMENTO       |");
    System.out.println("+--------------------------------------------+");

    System.out.println("| Dia para executar a Folha de pagamento (dd/mm/yyyy): ");
    System.out.print("> ");    
    String dia = input.nextLine();

    List<HistoricoDeSalario> lancamentos = pagamentoService.calcularFolha(
      dia,
      empregados,
      vendas,
      cartoesDePonto,
      taxaDeServicos
    );

   
    System.out.println("+--------------------------------------------+");  
    System.out.println("Folha de pagamento executada com sucesso. \nForam feitos " + lancamentos.size() + " lancamentos.");
    
    historicoSalario.addAll(lancamentos);
    this.listarPagamentos();
  }

  public void removerEmpregado() {
    System.out.println("+--------------------------------------------+");
    System.out.println("|             REMOVER EMPREGADO              |");
    System.out.println("+--------------------------------------------+");

    System.out.println("| ID do Empregado que à ser removido:        |");
    System.out.print("> ");
    //System.out.println("+--------------------------------------------+");

    String id = input.nextLine().trim();
    
    boolean result = empregados.removeIf(empregado -> (empregado.getId().equals(id)));

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
    empregados.add(empregado);

    System.out.println("+--------------------------------------------+");
    System.out.println("| Empregado adicionado!                      |");
  }

  public void adicionarEmpregadoAssalariado() {
    Empregado dadosBase = obterEmpregado();

    System.out.println("| Salário mensal:                            |");
    System.out.print("> ");
    double salarioMensal = Double.parseDouble(input.nextLine());

    Assalariado empregado = new Assalariado(dadosBase.getNome(), 
                                            dadosBase.getSobrenome(), 
                                            dadosBase.getEndereco(), 
                                            dadosBase.getContribuiSindicato(), 
                                            salarioMensal,
                                            dadosBase.getPagamentoMetodo(),
                                            dadosBase.getIdSindical(),
                                            dadosBase.getTaxaSindical(),
                                            "MENSALMENTE");
    empregados.add(empregado);

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
    empregados.add(empregado);

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
