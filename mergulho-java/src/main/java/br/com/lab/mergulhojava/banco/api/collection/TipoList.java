package br.com.lab.mergulhojava.banco.api.collection;

import br.com.lab.mergulhojava.banco.modelo.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class TipoList {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("João da Silva","111111");
        Pessoa pessoa2 = new Pessoa("Maria da Silva","222222");

        List<Pessoa> pessoas = new  ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        System.out.println(pessoas);

        //acesso aleatorio
        Pessoa pessoa3 = pessoas.get(1);
        System.out.println(pessoa3);

        //interações no list
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(pessoas.get(i).getNome());
        }

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
        }

        Pessoa pessoa4 = new Pessoa("João da Silva","111111");

        //contains verifica se objeto existe na lista, a verificação é no conteudo usando o equals da classe
        boolean existe = pessoas.contains(pessoa4);
        System.out.println(existe);

        //equals é para comprar o conteudo do objeto, propriedade dele
        System.out.println(pessoa1.equals(pessoa4));

        // O == compara se os duas intancias de  objetos
        System.out.println(pessoa1 == pessoa4);
    }
}
