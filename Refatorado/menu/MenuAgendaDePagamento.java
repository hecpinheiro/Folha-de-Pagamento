package menu;

import service.interfaces.AcaoMenu;

public class MenuAgendaDePagamento implements AcaoMenu{
    @Override
    public void exibirMenu(){
        System.out.println("+--------------------------------------------+");
        System.out.println("|        ALTERAR AGENDA DE PAGAMENTO         |");
        System.out.println("+--------------------------------------------+");
        System.out.println("| Selecione qual a nova agenda de pagamento: |");
        System.out.println("+--------------------------------------------+");
        System.out.println("| (1) Mensalmente                            |");
        System.out.println("| (2) Semanalmente                           |");
        System.out.println("| (3) Bisemanalmente                         |");
        System.out.println("+--------------------------------------------+");
    }
}

 