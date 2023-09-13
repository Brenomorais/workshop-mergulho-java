package br.com.lab.mergulhojava.banco.modelo;

public class ContaInvestimento extends Conta{
    public ContaInvestimento(Pessoa titular, int agencia, int numero){
        super(titular,agencia,numero);
    }

    @Override
    public void debitarTarifaMensal() {
        if(getSaldo() < 10_000){
            sacar(9.99);
        }
    }

    public void creditarRendimento(double percentualJuros){
        double valorRendimentos = getSaldo() * percentualJuros / 100;
        depositar(valorRendimentos);
        //System.out.println("Valor do rendimento:"+valorRendimentos);
    }
}