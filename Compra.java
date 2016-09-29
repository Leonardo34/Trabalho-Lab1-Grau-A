
/**
 * Aluno: Leonardo Broch de Morais (leo_broch@hotmail.com) Trabalho A Lab 1     Prof. Aníbal 2016/2
 * 
 * @author (Leonardo Broch de Morais) 
 * @version (v1.0)
 */
public class Compra
{
    private int modalidade;
    private Cliente cliente;
    private Data DataCompra;
    private double PrecoOriginal;
    private double PrecoFinal;
    private Parcela p1, p2, p3;
    
    public Compra (Cliente c, Data d, double p) {
        cliente = c;
        DataCompra = d;
        PrecoOriginal = p;
        this.escolheModalidade();
    }
    
    public Compra (Cliente c, int d, int m, int a, double p) {
        cliente = c;
        DataCompra = new Data(d, m, a);
        PrecoOriginal = p;
        this.escolheModalidade(); 
    }
    
    public void escolheModalidade () {
        Teclado t = new Teclado();
        System.out.println("Digite a modalidade de compra, ");
        int escolha = t.leInt();
            if (escolha == 1) {
                modalidade = escolha;
            }
            else if (escolha == 2) {
                modalidade = escolha;
            }
            else if (escolha == 3) {
                modalidade = escolha;
            }
            else {
                modalidade = 1;
            }
    }
    
    private boolean ultimasCrescente (double compra) {
        if (compra > cliente.getValorUltimaCompra() && cliente.getValorUltimaCompra() > cliente.getValorPenultimaCompra()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void finalizaCompra () {
        Data d1, d2, d3;
        switch (modalidade) {
            
            case 1:
                if (DataCompra.getMes() == cliente.getData().getMes()) {
                    double x;
                    x = (PrecoOriginal*20)/100;
                    PrecoFinal = PrecoOriginal - x;
                    cliente.fazCompra(PrecoFinal);
                    break;
                }
                 if (this.ultimasCrescente(PrecoOriginal)) {
                    double x;
                    x = (PrecoOriginal*8)/100;
                    PrecoFinal = PrecoOriginal - x;
                    cliente.fazCompra(PrecoFinal);
                    break;
                }
                if (!this.ultimasCrescente(PrecoOriginal) && !(DataCompra.getMes() == cliente.getData().getMes())) {
                    double x;
                    x = (PrecoOriginal*5)/100;
                    PrecoFinal = PrecoOriginal - x;
                    cliente.fazCompra(PrecoFinal);
                    break;
                }
                
            case 2:
                //Corrigido Bug do saldo Devedor
                double x;
                x = (PrecoOriginal*3.5)/100;
                PrecoFinal = PrecoOriginal - x;
                cliente.fazCompra(PrecoFinal, PrecoFinal);
                p1 = new Parcela(cliente, DataCompra, PrecoFinal/2);
                p1.paga(DataCompra);
                d1 = calculaVencimentoData(DataCompra);
                p2 = new Parcela (cliente, d1, PrecoFinal/4);
                d2 = calculaVencimentoData (d1);
                p3 = new Parcela (cliente, d2, PrecoFinal/4);
                break;
                
            case 3:
                //Corrigido Bug do saldo devedor
                PrecoFinal = PrecoOriginal;
                d1 = calculaVencimentoData (DataCompra);
                p1 = new Parcela(cliente, d1, PrecoFinal/3);
                d2 = calculaVencimentoData (d1);
                p2 = new Parcela(cliente, d2, PrecoFinal/3);
                d3 = calculaVencimentoData (d2);
                p3 = new Parcela(cliente, d3, PrecoFinal/3);
                cliente.fazCompra (PrecoFinal, PrecoFinal);
                break;
                
            default: 
                System.out.println ("Debug");
                break;
        }
    }
    
    public Data calculaVencimentoData (Data d) {
        Data proxParcela;
        int m = d.getMes();
        int a = d.getAno();
        m++;
        if (m>12) {
            m=1;
            a++;
        }
        proxParcela = new Data(28, m, a);
        return proxParcela;
    }
    
    public void exibeDadosCompra () {
        System.out.println("Modalidade: " + modalidade);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Data da Compra: " + DataCompra.obtemDataPadrao());
        System.out.println("Preço Original: " + PrecoOriginal);
        System.out.println("Preco Final com descontos: " + PrecoFinal);
    }
}
