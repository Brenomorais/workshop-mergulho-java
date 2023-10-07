package br.com.lab.mergulhojava.banco.api.collection;

import br.com.lab.mergulhojava.banco.modelo.Conta;

import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntFunction;

public class NumeroContaFunction implements ToIntFunction<Conta> {

    @Override
    public int applyAsInt(Conta conta){
        return conta.getNumero();
    }
}
