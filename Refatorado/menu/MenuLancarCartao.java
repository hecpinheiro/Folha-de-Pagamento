package menu;

import service.interfaces.AcaoMenu;

public class MenuLancarCartao implements AcaoMenu{
    @Override
    public void exibirMenu(){
        
        System.out.println("+--------------------------------------------+");
        System.out.println("|         LANÇAR UM CARTÃO DE PONTOS         |");
        System.out.println("+--------------------------------------------+");
    
    }
}
