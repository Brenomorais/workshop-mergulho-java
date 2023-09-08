package br.com.lab.mergulhojava.poo;

import java.util.Objects;

public class Conta {
    //variaveis de instancia caracterista da classe

    //Relacionamento tem um 1:1, uma conta tem um titular
    Pessoa titular;
    int agencia;
    int numero;
    double saldo;

    Conta(){
    }

    Conta(Pessoa titular, int agencia, int numero){
        Objects.requireNonNull(titular);

        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    void depositar(double valor){
        checkValue(valor);
        saldo = saldo + valor;
    }

    private static void checkValue(double valor) {
        if(valor <= 0){
            throw  new IllegalArgumentException("Valor deve ser maior que 0.");
        }
    }

    void sacar(double valor){
        checkValue(valor);
        if(saldo - valor < 0){
            throw new IllegalThreadStateException("Saldo insuficiente.");
        }
        saldo = saldo - valor;
    };

    void sacar(double valor, double taxaSaque){
        //soma o valor do saque com a taxa virando um valor só a ser debitado da conta
        sacar(valor + taxaSaque);
    }
}