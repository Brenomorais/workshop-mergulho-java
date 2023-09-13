package br.com.lab.mergulhojava.app;

import br.com.lab.mergulhojava.banco.modelo.Conta;
import br.com.lab.mergulhojava.banco.modelo.ContaEspecial;
import br.com.lab.mergulhojava.banco.modelo.ContaInvestimento;
import br.com.lab.mergulhojava.banco.modelo.Pessoa;

public class Principal {
    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("breno");
        titular1.setDocumento("123.456-00");

        //Conta minhaConta = new Conta(titular1,123,987);
        ContaInvestimento minhaConta = new ContaInvestimento(titular1,123,987);

        minhaConta.depositar(15_000);
        minhaConta.sacar(1000);
        minhaConta.creditarRendimento(0.8);

        System.out.println("Numero MINHA conta: " + minhaConta.getNumero()
                +" - Nome Titular: " + minhaConta.getTitular().getNome()
                +" - Documento: " + minhaConta.getTitular().getDocumento()
                +" - Saldo: " +minhaConta.getSaldo());

        Pessoa titular2 = new Pessoa();
        titular1.setNome("Magda");
        titular1.setDocumento("123.456-99");

        //Conta suaConta = new Conta(titular2, 123,456);
        ContaEspecial suaConta = new ContaEspecial(titular2, 123,456,1_000);

        suaConta.depositar(5_000);
        suaConta.sacar(6_000);

        System.out.println("Numero SUA conta: " + suaConta.getNumero()
                +" - Nome Titular: " + suaConta.getTitular().getNome()
                +" - Documento: " + suaConta.getTitular().getDocumento()
                +" - Saldo: " +suaConta.getSaldo());
    }
}