package br.com.lab.mergulhojava.poo;

public class Principal {
    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("breno");
        titular1.setDocumento("123.456-00");

        Conta minhaConta = new Conta(titular1,123,987);

        minhaConta.depositar(15_000);
        minhaConta.sacar(1000, 1.99);

        System.out.println("Numero MINHA conta: " + minhaConta.getNumero()
                +" - Nome Titular: " + minhaConta.getTitular().getNome()
                +" - Documento: " + minhaConta.getTitular().getDocumento()
                +" - Saldo: " +minhaConta.getSaldo());

        Pessoa titular2 = new Pessoa();
        titular1.setNome("Magda");
        titular1.setDocumento("123.456-99");

        Conta suaConta = new Conta(titular2, 123,456);

        suaConta.depositar(30_000);
        suaConta.sacar(1000);

        System.out.println("Numero SUA conta: " + suaConta.getNumero()
                +" - Nome Titular: " + suaConta.getTitular().getNome()
                +" - Documento: " + suaConta.getTitular().getDocumento()
                +" - Saldo: " +suaConta.getSaldo());
    }
}