package br.com.lab.mergulhojava.aula2;

public class Principal1 {
    public static void main(String[] args) {
        Conta1 minhaConta = new Conta1();
        minhaConta.nomeTitular = "breno";
        minhaConta.agencia = 1;
        minhaConta.numero = 123;
        minhaConta.saldo = 99.98;

        System.out.println("Numero conta: " + minhaConta.numero
                +" - Nome Titular: " + minhaConta.nomeTitular);

        Conta1 suaConta = new Conta1();
        suaConta.nomeTitular = "magda";
        suaConta.agencia = 1;
        suaConta.numero = 321;
        suaConta.saldo = 50.0;

        System.out.println("Numero conta: " + suaConta.numero
                +" - Nome Titular: " + suaConta.nomeTitular);
    }
}
