
/**
 * Aluno: Leonardo Broch de Morais (leo_broch@hotmail.com) Trabalho A Lab 1     Prof. Aníbal 2016/2
 * 
 * @author (Leonardo Broch de Morais) 
 * @version (v1.0)
 */
public class Parcela
{
    
    private Cliente cliente;
    private Data DataDeVencimento;
    private double ValorOriginal;
    private double ValorFinal;
    private char situacao; 

    public Parcela(Cliente c, Data d, double valor)
    {
        cliente = c;
        DataDeVencimento = d; 
        ValorOriginal = valor;
        situacao = 'N'; 
    }
    
    public boolean registraAtraso () {
        Data DataHoje = new Data();
            if (DataHoje.obtemDataInvertida() > DataDeVencimento.obtemDataInvertida() && situacao=='N') {
                situacao = 'A';
                return true;
            }
            else {
                return false;
            }
    }
    
    public double paga (Data dataPagamento) {
        if (dataPagamento.obtemDataInvertida() <= DataDeVencimento.obtemDataInvertida()) {
            ValorFinal = ValorOriginal;
            situacao = 'Q';
            //Registrar venda no Objeto Cliente
            cliente.pagaParcela(ValorOriginal);
            return ValorFinal - ValorOriginal;
        }
        else {
            int diasDeAtraso = dataPagamento.diasDeOutraData(DataDeVencimento);
            
                if (diasDeAtraso <= 5) {
                    double x; 
                    x = (ValorOriginal*1)/100;
                    ValorFinal = ValorOriginal + x;
                    situacao = 'Q';
                    //Registrar venda no Objeto Cliente
                    cliente.pagaParcela(ValorOriginal);
                    return x;
                } 
                
                else if (diasDeAtraso > 5 && diasDeAtraso <= 15) {
                    double x;
                    x = (ValorOriginal*1.5)/100;
                    ValorFinal = ValorOriginal + x;
                    situacao = 'Q';
                    //Registrar venda no Objeto Cliente
                    cliente.pagaParcela(ValorOriginal);
                    return x;
                }
                
                else {
                    double x;
                    x = (ValorOriginal*2.5)/100;
                    ValorFinal = ValorOriginal + x;
                    situacao = 'Q';
                    //Registrar venda no Objeto Cliente
                    cliente.pagaParcela(ValorOriginal);
                    return x;
                }                
        }
    }
    
    public String Situacao () {
        if (situacao == 'N') {
            return "Não Venceu ainda";
        }
        else if (situacao == 'A') {
            return "Em atraso";
        }
        else if (situacao == 'Q') {
            return "Quitada";
        }
        else {
            return "Erro 404";
        }
    }
    
    public void exibeDados (int numeroParcela) {
        System.out.println (numeroParcela + " " + cliente.getNome() + " " + DataDeVencimento.obtemDataPadraoComZeros() + " " + ValorOriginal + " " + this.Situacao());
    }
    
    public void setDataVencimento (Data d) {
        DataDeVencimento = d;
    } 
    
    public void setValor (double v) {
        ValorOriginal = v;
    }
    
    public Data getDataVencimento () {return DataDeVencimento;}
    
    public double getValor () {return ValorOriginal;}
    
    public double getValorComJuros () {return ValorFinal;}
    
}
