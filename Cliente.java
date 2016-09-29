
/**
 * Aluno: Leonardo Broch de Morais (leo_broch@hotmail.com) Trabalho A Lab 1     Prof. Aníbal 2016/2
 * 
 * @author (Leonardo Broch de Morais) 
 * @version (v1.0)
 */
public class Cliente
{
    private String nome;
    private Data DataNascimento;
    private double ValorUltimaCompra;
    private double ValorPenultimaCompra;
    private double saldoDevedor;
    
    public Cliente (String n, Data d) {
        nome = n;
        DataNascimento = d;
        saldoDevedor = 0;
    }
    
    public void fazCompra (double ValorCompra) {
        ValorPenultimaCompra = ValorUltimaCompra;
        ValorUltimaCompra = ValorCompra;
    }

    public void fazCompra (double v, double valorTotalDevido) { 
        saldoDevedor = saldoDevedor + valorTotalDevido;
        this.fazCompra (v);
    }
    
    public void pagaParcela (double ValorParcela) {
        saldoDevedor = saldoDevedor - ValorParcela;
    }
    
    public void exibeDados () {
        System.out.println ("Nome: " + nome);
        System.out.println ("Data de nascimento: " + DataNascimento.obtemDataPadraoComZeros());
        System.out.println ("Valor da ultima compra: " + ValorUltimaCompra);
        System.out.println ("Valor da penultima compra: " + ValorPenultimaCompra);
        System.out.println ("Total devido: " + saldoDevedor);
    }
    
    public String getNome () {return nome;}
    public double getValorUltimaCompra () {return ValorUltimaCompra;}
    public double getValorPenultimaCompra () {return ValorPenultimaCompra;}
    public Data getData () {return DataNascimento;}
}
