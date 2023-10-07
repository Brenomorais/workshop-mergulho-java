package br.com.lab.mergulhojava.banco.api.stream;

import br.com.lab.mergulhojava.banco.modelo.Banco;
import br.com.lab.mergulhojava.banco.modelo.Conta;
import br.com.lab.mergulhojava.banco.modelo.Pessoa;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {

        Banco banco1 = new Banco();
        Banco banco2 = new Banco();
        Banco banco3 = new Banco();
        Banco banco4 = new Banco();
        Banco banco5 = new Banco();
        Banco banco6 = new Banco();

        pipeline1(banco1);

        pipeline2(banco2);

        pipeline3(banco3);

        pipeline4(banco4);

        pipeline5(banco5);

        pipeline6(banco6);

    }

    // Configurando stream de maneira mais declarativas em varios encadeamentos e fazendo a invoação no final com forEach
    public static void pipeline1(Banco banco){
        //configuração da pipeline, operação intermediaria
        Stream<Conta> stream = banco.getContas().stream();

        Stream<Conta> stream2 = stream.filter(
                conta -> conta.getSaldo().compareTo(new BigDecimal("130")) > 0);

        //Fitro por conta
        //Stream<Conta> stream3 = stream.filter(conta -> conta.getNumero() > 300);

        //iterações com stream e lambda: Executa a pipeline pois forEach é uma operação terminal
        stream2.forEach(conta ->{
            conta.depositar(new BigDecimal("10"));
            System.out.println(conta.getNumero() + "/"
                    +conta.getTitular().getNome() + "= " + conta.getSaldo());
        });
    }

    //Simplificando em apenas uma declaração a configuração e execução da Stream
    public static void pipeline2(Banco banco){
        banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("130"))>0)
                .filter(conta -> conta.getNumero() > 200)
                .sorted(Comparator.comparingInt(Conta::getNumero)) //essa ordenação  naõ ordena a fonte de dados apenas a execucao
                .filter(conta -> conta.getNumero()  > 300).forEach(conta ->{
                    System.out.println(conta.getNumero() + "/"
                            +conta.getTitular().getNome() + "= " + conta.getSaldo());
                });
    }

    //aplicando transformação na stream com .map, stream que retorna outra stream
    public static void pipeline3(Banco banco){
        Stream<Pessoa> stream = banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("130"))>0)
                .filter(conta -> conta.getNumero() > 200)
                .map(conta -> conta.getTitular());  //retonra uma nova stream do tipo pessoa

    }

    //retoran os titulares não duplicados
    public static void pipeline4(Banco banco){
         banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50"))>0)
                .filter(conta -> conta.getNumero() > 200)
                .map(Conta::getTitular)  //retonra uma nova stream do tipo pessoa
                 .distinct() //retorna um stream sem duplicados
                .forEach(titular -> {
                    System.out.println(titular);
         });
    }

    //operação de redução produz um resultado final a partir da sequencia de um stream
    //faz a soma de todos os saldos
    public static void pipeline5(Banco banco) {
        BigDecimal saldoTotal = banco.getContas().stream()
                .map(Conta::getSaldo)  //retorna um stream de bigdecimal
                //.reduce(BigDecimal.ZERO,BigDecimal::add) //maneira simplificada da instruação abaixo
                .reduce(BigDecimal.ZERO, (subtotal, valor) -> subtotal.add(valor)); //operação de soma

        //reduce indica para quando precisa agredar um resultdo final

        System.out.println("Saldo de todas as contas: " + saldoTotal);
    }

    //Convert do fluxo de uma stream em uma nova colecao com o collect
    private static void pipeline6(Banco banco6) {
        List<Pessoa> titulares =  banco6.getContas().stream()
                .map(Conta::getTitular)
                .distinct() //retorna uma stream pessoa
                .collect(Collectors.toList()); //retorna um lista de pessoa

        //collect é usado para acumular elementos do stream em um container que depois pode ser coletados.

        System.out.println(titulares);
    }
}
