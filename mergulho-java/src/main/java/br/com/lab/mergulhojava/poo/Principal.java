package br.com.lab.mergulhojava.poo;

public class Principal {
    public static void main(String[] args) {
        Conta minhaConta = new Conta();
        Pessoa titular1 = new Pessoa();
        titular1.nome = "breno";
        titular1.documento = "111111111";

        minhaConta.titular = titular1;
        minhaConta.agencia = 1;
        minhaConta.numero = 123;
        minhaConta.saldo = 99.98;

        System.out.println("Numero conta: " + minhaConta.numero
                +" - Nome Titular: " + minhaConta.titular.nome
                +" - Documento: " + minhaConta.titular.documento);

        Conta suaConta = new Conta();

        suaConta.titular = new Pessoa();
        suaConta.titular.nome = "magda";
        suaConta.titular.documento = "22222222222222";
        suaConta.agencia = 1;
        suaConta.numero = 321;
        suaConta.saldo = 50.0;

        System.out.println("Numero conta: " + suaConta.numero
                +" - Nome Titular: " + suaConta.titular.nome
                +" - Documento: " + suaConta.titular.documento);
    }
}
