package br.com.lab.mergulhojava.poo;

public class Principal {
    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.nome = "breno";
        titular1.documento = "123.456-00";

        Conta minhaConta = new Conta(titular1,123,987);
        minhaConta.depositar(15_000);
        minhaConta.sacar(1000, 1.99);

        System.out.println("Numero MINHA conta: " + minhaConta.numero
                +" - Nome Titular: " + minhaConta.titular.nome
                +" - Documento: " + minhaConta.titular.documento
                +" - Saldo: " +minhaConta.saldo);

        Conta suaConta = new Conta();

        suaConta.titular = new Pessoa();
        suaConta.titular.nome = "magda";
        suaConta.titular.documento = "123.456-99";
        suaConta.agencia = 1;
        suaConta.numero = 321;
        suaConta.depositar(30_000);
        suaConta.sacar(1000);

        System.out.println("Numero SUA conta: " + suaConta.numero
                +" - Nome Titular: " + suaConta.titular.nome
                +" - Documento: " + suaConta.titular.documento
                +" - Saldo: " +suaConta.saldo);
    }
}