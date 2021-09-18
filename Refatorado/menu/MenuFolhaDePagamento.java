package menu;

import service.interfaces.AcaoMenu;

public class MenuFolhaDePagamento implements AcaoMenu{
    @Override
    public void exibirMenu(){
        
        System.out.println("+--------------------------------------------+");
        System.out.println("|        EXECUTAR A FOLHA DE PAGAMENTO       |");
        System.out.println("+--------------------------------------------+");
    
    }
}
