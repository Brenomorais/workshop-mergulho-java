package br.com.lab.mergulhojava.banco.modelo.atm;

import br.com.lab.mergulhojava.banco.modelo.Conta;
import br.com.lab.mergulhojava.banco.modelo.pagamento.DocumentoEstornavel;
import br.com.lab.mergulhojava.banco.modelo.pagamento.DocumentoPagavel;

import java.util.Objects;

/**
 * Classe com baixo aclopamento o caixa eletronico não tem depdencia direta com o tipo de pagamento
 *  veja que não import dos tipos de pagamento.
 */
public class CaixaEletronico {

    public void imprimirSaldo(Conta conta){
        Objects.requireNonNull(conta);

        System.out.println("Conta: " + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo Disponivel:" + conta.saldoDisponivel());
    }

    //polimorfismo em ação, DocumentoPagavel é generico aceita qualquer objeto que implemente DocumentoPagavel
    public void pagar(DocumentoPagavel documento, Conta conta){
        if(documento.estaPago()){
            throw new IllegalArgumentException("Documento já está pago!");
        }
        conta.sacar(documento.getValorTotal());
        documento.quitarPagamento();
    }

    public void estonarPagamento(DocumentoEstornavel documento, Conta conta){
        if(!documento.estaPago()){
            throw  new IllegalArgumentException("Documetno não está pago!");
        }
        conta.depositar(documento.getValorTotal());
        documento.estonarPagamento();
    }
}
