package br.com.lab.mergulhojava.banco.modelo;

public class ContaInvestimento extends Conta{
    public ContaInvestimento(Pessoa titular, int agencia, int numero){
        super(titular,agencia,numero);
    }

    public void creditarRendimento(double percentualJuros){
        double valorRendimentos = getSaldo() * percentualJuros / 100;
        depositar(valorRendimentos);
        //System.out.println("Valor do rendimento:"+valorRendimentos);
    }
}