package br.com.lab.mergulhojava.banco.api.collection;

import br.com.lab.mergulhojava.banco.modelo.Banco;
import br.com.lab.mergulhojava.banco.modelo.Conta;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class OrdenacaoDeList {

    public static void main(String[] args) {

        Banco banco = new Banco();

        //ordenação implementando ToIntFunction
        //banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));

        //essa expressão lambda tem a mesma funcionalidade que a chamda acima mas sem precisar implementar classe.
        ToIntFunction<Conta> function = (Conta conta) -> {
            return  conta.getNumero();
        };

        //passando como parametro a função expressão lambda function feita accima
        //banco.getContas().sort(Comparator.comparingInt(function));

        //1º Forma: criando expressão lambda direto no parametro
       /* banco.getContas().sort(Comparator.comparingInt((Conta conta) -> {
            return  conta.getNumero();
        })); */

        //2º Forma, se a função só possui um bloco não precisa abrir o bloco pode fazer direto omitindo o return
        //banco.getContas().sort(Comparator.comparingInt((Conta conta) -> conta.getNumero()));

        //3º Forma: Method Reeferencere, faz ferencia direta, no cabo referencia o getNumero que o valor usado para ordenacao
        banco.getContas().sort(Comparator.comparingInt(Conta::getNumero));

        for(Conta conta : banco.getContas()){
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }

        //interação usando lambda
        banco.getContas().forEach(conta -> System.out.println(conta.getTitular().getNome()));

    }
}
