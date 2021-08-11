package main;

import java.util.Scanner;
import service.MainService;

class Menu {
  public void mainMenu() {

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

			System.out.println("+--------------------------------------+");
			System.out.println("|          FOLHA DE PAGAMENTO          |");
			System.out.println("+--------------------------------------+");
			System.out.println("| Selecione uma das opções abaixo      |");
			System.out.println("+--------------------------------------+");
			System.out.println("| (1) Adicionar um empregado           |");
			System.out.println("| (2) Remover empregado                |");
			System.out.println("| (3) Listar empregados                |");
			System.out.println("| (4) Lançar um cartão de pontos       |");
			System.out.println("| (5) Lançar um resultado de venda     |");
			System.out.println("| (6) Lançar uma taxa de serviço       |");
			System.out.println("| (7) Alterar detalhes de um empregado |");
			System.out.println("| (8) Executar folha de pagamento      |");
			System.out.println("| (9) Alterar agenda de pagamento      |");
			System.out.println("| (0) Sair                             |");
			System.out.println("+--------------------------------------+");
			System.out.print("> ");

      opcao = input.nextInt();
      switch(opcao) {
        case 1: 	
			System.out.println("+--------------------------------------------+");
			System.out.println("|           ADICIONAR UM EMPREGADO           |");
			System.out.println("+--------------------------------------------+");
			System.out.println("| Selecione o tipo de empregado à adicionar: |");
			System.out.println("+--------------------------------------------+");
			System.out.println("| (1) Horista                                |");
			System.out.println("| (2) Comissionado                           |");
			System.out.println("| (3) Assalariado                            |");
			System.out.print("> ");

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
				case 0:
					executar = false;
					break;
        default:
          break;
      }
    }
    input.close();
  } 
}