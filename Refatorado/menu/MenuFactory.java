package menu;

import service.interfaces.AbstractFactory;
import service.interfaces.AcaoMenu;

public class MenuFactory implements AbstractFactory<AcaoMenu>{
    @Override 
    public AcaoMenu create(String menu){
        switch(menu){
            case "agendaPagamento":
                return new MenuAgendaDePagamento();
            case "alterarDados":
                return new MenuAlterarDados();
            case "lancarVendas":
                return new MenuLancarVendas(); 
            case "lancarTaxa":
                return new MenuLancarTaxa();
            case "lancarCartao":
                return new MenuLancarCartao();
            case "executarFolhaDePagamento":
                return new MenuFolhaDePagamento();
            case "removerEmpregado":
                return new MenuRemoverEmpregado();
            default : return null;
            }
            
    }
}