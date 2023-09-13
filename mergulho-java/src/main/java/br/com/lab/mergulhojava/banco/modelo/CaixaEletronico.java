package br.com.lab.mergulhojava.banco.modelo;

import java.util.Objects;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta){
        Objects.requireNonNull(conta);

        System.out.println("Conta: " + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo Disponivel:" + conta.saldoDisponivel());
    }
}
