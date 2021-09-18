package menu;

import service.interfaces.AcaoMenu;

public class MenuRemoverEmpregado implements AcaoMenu{
    @Override
    public void exibirMenu(){
        
        System.out.println("+--------------------------------------------+");
        System.out.println("|             REMOVER EMPREGADO              |");
        System.out.println("+--------------------------------------------+");
    
    }
}
