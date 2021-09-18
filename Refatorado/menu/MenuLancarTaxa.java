package menu;

import service.interfaces.AcaoMenu;

public class MenuLancarTaxa implements AcaoMenu{
    @Override
    public void exibirMenu(){
        
        System.out.println("+--------------------------------------------+");
        System.out.println("|         LANÇAR UM TAXA DE SERVIÇO          |");
        System.out.println("+--------------------------------------------+");
    
    }
}
