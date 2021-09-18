package database;

import java.util.List;
import java.util.ArrayList;
import generico.CartaoDePonto;
import generico.TaxaDeServico;
import generico.Vendas;
import generico.HistoricoDeSalario;
import empregado.Empregado;


public final class Database {
    private static final Database instancia = new Database();
    private Database(){}
    public static Database obterInstancia(){
        return instancia;
    }

    private List<Empregado> empregados = new ArrayList<Empregado>();
    private List<CartaoDePonto> cartoesDePonto = new ArrayList<CartaoDePonto>();
    private List<Vendas> vendas = new ArrayList<Vendas>();
    private List<TaxaDeServico> taxaDeServicos = new ArrayList<TaxaDeServico>();
    private List<HistoricoDeSalario> historicoSalario = new ArrayList<HistoricoDeSalario>();

    public List<Empregado> obterEmpregados(){
        return this.empregados;
    }
    public void addEmpregado(Empregado empregado){
        this.empregados.add(empregado);
    }

    public List<CartaoDePonto> obterCartoes(){
        return this.cartoesDePonto;
    }
    public void addCartao(CartaoDePonto cartaoDePonto){
        this.cartoesDePonto.add(cartaoDePonto);
    }

    public List<Vendas> obterVendas(){
        return this.vendas;
    }
    public void addVendas(Vendas vendas){
        this.vendas.add(vendas);
    }

    public List<TaxaDeServico> obterTaxas(){
        return this.taxaDeServicos;
    }
    public void addTaxas(TaxaDeServico taxas){
        this.taxaDeServicos.add(taxas);
    }

    public List<HistoricoDeSalario> obterHistoricoDeSalarios(){
        return this.historicoSalario;
    }
    public void addHistoricoDeSalarios(List<HistoricoDeSalario> historicoSalario){
        this.historicoSalario.addAll(historicoSalario);
    }

    public boolean removerEmpregado(String id){
        return this.empregados.removeIf(empregado -> (empregado.getId().equals(id)));
    }
}



