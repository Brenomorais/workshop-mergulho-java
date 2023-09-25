package br.com.lab.mergulhojava.banco.modelo.pagamento;

import br.com.lab.mergulhojava.banco.modelo.Pessoa;

import java.math.BigDecimal;

public class Holerite implements DocumentoPagavel{

    private Pessoa funcionario;
    private BigDecimal valorHora;
    private int quantidaHoras;
    private boolean pago;

    public Holerite(Pessoa funcionario, BigDecimal valorHora, int quantidaHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quantidaHoras = quantidaHoras;
    }

    @Override
    public BigDecimal getValorTotal() {
        return valorHora.multiply(new BigDecimal(quantidaHoras));
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }
}
