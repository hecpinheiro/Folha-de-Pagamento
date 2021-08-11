package main;

import java.util.Scanner;
import service.MainService;

class Menu {
  public void mainMenu() {
    System.out.println("Menu - Folha de Pagamento");
    System.out.println("Selecione uma das opções");
    System.out.println("(1) Adicionar empregado");
    System.out.println("(2) Remover empregado");
    System.out.println("(3) Listar empregados");
		System.out.println("(4) Lançar um cartão de pontos");
		System.out.println("(5) Lançar um resultado de venda");
		System.out.println("(6) Lançar uma taxa de serviço");
		System.out.println("(7) Alterar detalhes de um empregado");
		System.out.println("(8) Executar folha de pagamento");
		System.out.println("(9) Alterar agenda de pagamento");
		System.out.println("(20) Sair");
  }
}

public class Main {

  public static void main(String[] args) {
    
		Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    MainService service = new MainService();
    int opcao;
		boolean executar = true;

		menu.mainMenu();
    
    while(executar) {
      opcao = input.nextInt();
      switch(opcao) {
        case 1: 
          System.out.println("Selecione o tipo de empregado à adicionar:");
					System.out.println("(1) Horista");
					System.out.println("(2) Comissionado");
					System.out.println("(3) Assalariado");

          int opcao1 = input.nextInt();

					switch (opcao1) {
						case 1:
							service.adicionarEmpregadoHorista();
							break;
						case 2:
							service.adicionarEmpregadoComissionado();
							break;
						case 3:
							service.adicionarEmpregadoAssalariado();
							break;
						default:
							break;
					}
        	break;
        case 2:
          service.removerEmpregado();
          break;
        case 3:
					service.listarEmpregados();
          break;
				case 4:
					service.lancarCartaoPonto();
          break;
				case 5:
					service.lancarVenda();
       	 	break;	
				case 6:
					service.lancarTaxaServico();
        	break;
				case 7:
					service.alterarDados();
					break;	
				case 8:
					service.executarFolhaDePagamento();
					break;
				case 9:
					service.alterarAgendaPagamento();
					break;
				case 20:
					executar = false;
					break;
        default:
          break;
      }
    }
    input.close();
  } 
}