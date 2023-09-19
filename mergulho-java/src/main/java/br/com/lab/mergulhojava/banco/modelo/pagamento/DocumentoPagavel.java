package br.com.lab.mergulhojava.banco.modelo.pagamento;

public interface DocumentoPagavel {
    public abstract  double getValorTotal();
    boolean estaPago();
    void quitarPagamento();
    default  void imprimirRecibo(){
        System.out.println("-------------------------------");
        System.out.println("            RECIBO:            ");
        System.out.println("-------------------------------");
        System.out.println("Valor total: " + getValorTotal());
        System.out.println("Pago: " + estaPago());
    }
}
