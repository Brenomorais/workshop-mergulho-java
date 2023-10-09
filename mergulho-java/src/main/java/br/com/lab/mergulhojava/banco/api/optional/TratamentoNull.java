package br.com.lab.mergulhojava.banco.api.optional;

import br.com.lab.mergulhojava.banco.modelo.Banco;
import br.com.lab.mergulhojava.banco.modelo.Conta;
import br.com.lab.mergulhojava.banco.modelo.Pessoa;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

public class TratamentoNull {
    public static void main(String[] args) {
        Banco banco  = new Banco();

        //Conta existe
        Conta contaEncontrada = banco.buscar(123,222);
        System.out.println(contaEncontrada.getNumero());

        //Conta não existe
        Conta contaNaoEncontrada = banco.buscar(123,333);
        //System.out.println(contaNaoEncontrada.getNumero()); //NullPointerException

        //maneira tradicional
        if(contaNaoEncontrada != null){
            System.out.println(contaEncontrada.getNumero());
        }

        //Usando optinoal
        Optional<Conta> contaOptional = banco.buscarConta(123,333);
        if(contaOptional.isPresent()){
            Conta conta = contaOptional.get();
            System.out.println("Optional: " + conta.getNumero());
        }

        //optional com expresão lambda
        contaOptional.ifPresent(conta -> System.out.println(conta.getSaldo()));

        //chamada encadeada
        banco.buscarConta(123,22 2)
                .ifPresent(conta -> System.out.println(conta.getSaldo()));

        Conta conta = banco.buscarConta(123,222)
                .orElseThrow(() -> new IllegalArgumentException("conta não encontrada"));

        BigDecimal saldo = banco.buscarConta(123,222)
                .map(conta1 -> conta.getSaldo())
                .orElse(BigDecimal.ZERO); //retona um bigdecimal se tiver saldo retorna saldo senão retonar 0

        System.out.println("Saldo:" +saldo);

        //ofNullable retorna um optinoal vazio caso  o retorno da consulta seja null
        //se existir a possibilidade da criação de um Optional vazio, utilize o método ofNullable
        Optional<Integer>  num = Optional.ofNullable(9455);
        System.out.println(num);

        Conta conta1 = banco.getContas().get(0);

        Optional<Conta> contaOptional1 = Optional.ofNullable(conta1);
        System.out.println(">>"+contaOptional1);

        Pessoa pessoa = new Pessoa();
        Optional<Pessoa> pessoaOptional = Optional.ofNullable(pessoa);
        System.out.println(pessoa);

        Stream<Conta> contaStream = banco.getContas().stream();
        Optional<Double> pessoaOfNullable = Optional
                .ofNullable(contaStream
                        .mapToDouble(c -> c.getSaldo().doubleValue()).min().getAsDouble());
        System.out.println("Maior saldo:"+pessoaOfNullable);
    }
}
