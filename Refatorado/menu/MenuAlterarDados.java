package menu;

import service.interfaces.AcaoMenu;

public class MenuAlterarDados implements AcaoMenu{
    @Override
    public void exibirMenu(){
        System.out.println("+--------------------------------------------------+");
        System.out.println("|          ALTERAR DADOS DE UM EMPREGADO           |");
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
    }
}
