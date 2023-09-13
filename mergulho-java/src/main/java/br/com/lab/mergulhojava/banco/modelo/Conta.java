package br.com.lab.mergulhojava.banco.modelo;

import java.util.Objects;

public abstract class Conta {
    //variaveis de instancia caracterista da classe

    //Relacionamento tem um 1:1, uma conta tem um titular
    private Pessoa titular;
    private int agencia;
    private  int numero;
    private double saldo;

    Conta(){
    }

    public Conta(Pessoa titular, int agencia, int numero){
        Objects.requireNonNull(titular);

        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(double valor){
        checkValue(valor);
        saldo = saldo + valor;
    }

    private static void checkValue(double valor) {
        if(valor <= 0){
            throw  new IllegalArgumentException("Valor deve ser maior que 0.");
        }
    }

    public void sacar(double valor){
        checkValue(valor);
        if(saldoDisponivel() - valor < 0){
            throw new IllegalThreadStateException("Saldo insuficiente.");
        }
        saldo = saldo - valor;
    };

    public void sacar(double valor, double taxaSaque){
        //soma o valor do saque com a taxa virando um valor só a ser debitado da conta
        sacar(valor + taxaSaque);
    }

    public abstract void debitarTarifaMensal();

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double saldoDisponivel(){
        return  getSaldo();
    }
}