package br.com.lab.mergulhojava.banco.modelo.pagamento;

import java.math.BigDecimal;

public interface DocumentoPagavel {
    public abstract BigDecimal getValorTotal();
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
