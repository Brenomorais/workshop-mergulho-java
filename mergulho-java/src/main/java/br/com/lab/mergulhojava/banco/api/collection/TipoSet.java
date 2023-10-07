package br.com.lab.mergulhojava.banco.api.collection;

import br.com.lab.mergulhojava.banco.modelo.Pessoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TipoSet {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("João da Silva","111111");
        Pessoa pessoa2 = new Pessoa("Maria da Silva","222222");

        //HashSet: não garante a ordem dentro do conjunto, a ordem não é a mesma na inserção
        Set<Pessoa> pessoas = new HashSet<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        System.out.println(pessoas);

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
        }

        Pessoa pessoa4 = new Pessoa("João da Silva","111111");

        //contains a busca do set é diferente do list, é preciso implemenar o hasCode
        boolean existe = pessoas.contains(pessoa4);
        System.out.println(existe);

        //equals é para comprar o conteudo do objeto,as propriedade dele
        System.out.println(pessoa1.equals(pessoa4));

        // O == compara se os duas intancias de  objetos
        System.out.println(pessoa1 == pessoa4);
    }
}
