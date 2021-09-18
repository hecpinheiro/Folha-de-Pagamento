package menu;

import service.interfaces.AcaoMenu;

public class MenuLancarVendas implements AcaoMenu{
    @Override
    public void exibirMenu(){
        System.out.println("+--------------------------------------------+");
        System.out.println("|        LANÇAR UM RESULTADO DE VENDA        |");
        System.out.println("+--------------------------------------------+");
        
    }
}
