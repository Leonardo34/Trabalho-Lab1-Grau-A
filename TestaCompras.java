/**
 * Aluno: Leonardo Broch de Morais (leo_broch@hotmail.com) Trabalho A Lab 1     Prof. Aníbal 2016/2
 * 
 * @author (Leonardo Broch de Morais) 
 * @version (v1.0)
 */

public class TestaCompras
{
    private static Data AniversarioCliente, DataCompra1;
    private static Cliente cliente;
    private static Compra c1, c2, c3, c4, c5;
    
    public static void main(String[] args){
        AniversarioCliente = new Data(25, 4, 1997);
        cliente = new Cliente ("Leonardo", AniversarioCliente);
        DataCompra1 = new Data (05, 4, 2016);
        c1 = new Compra(cliente, DataCompra1, 100);
        c1.finalizaCompra();
        c1.exibeDadosCompra();
        c2 = new Compra (cliente, 21, 8, 2016, 200);
        c2.finalizaCompra();
        c2.exibeDadosCompra();
    }
}
