package br.com.lab.mergulhojava.banco.modelo.pagamento;

import br.com.lab.mergulhojava.banco.modelo.Pessoa;

public class Boleto  implements DocumentoPagavel, DocumentoEstornavel{

    private Pessoa beneficiario;
    private double valor;
    private boolean pago;

    public Boleto(Pessoa beneficiario, double valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
    }

    @Override
    public double getValorTotal() {
        return valor;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void estonarPagamento() {
        pago = false;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }

}
