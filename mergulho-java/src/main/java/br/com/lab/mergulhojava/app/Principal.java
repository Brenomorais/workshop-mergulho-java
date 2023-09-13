package br.com.lab.mergulhojava.app;

import br.com.lab.mergulhojava.banco.modelo.*;

public class Principal {
    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("breno");
        titular1.setDocumento("123.456-00");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Magda");
        titular2.setDocumento("123.456-99");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1,123,987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 123,456,1_000);

        minhaConta.depositar(15_000);
        minhaConta.sacar(1000);
        minhaConta.creditarRendimento(0.8);
        minhaConta.debitarTarifaMensal();

        suaConta.depositar(5_000);
        suaConta.sacar(5_000);
        suaConta.debitarTarifaMensal();

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println("---------------------------------");
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
