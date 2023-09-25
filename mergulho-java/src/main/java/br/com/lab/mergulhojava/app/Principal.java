package br.com.lab.mergulhojava.app;

import br.com.lab.mergulhojava.banco.excecao.SaldoInsuficienteException;
import br.com.lab.mergulhojava.banco.modelo.*;
import br.com.lab.mergulhojava.banco.modelo.atm.CaixaEletronico;
import br.com.lab.mergulhojava.banco.modelo.pagamento.Boleto;
import br.com.lab.mergulhojava.banco.modelo.pagamento.DocumentoPagavel;
import br.com.lab.mergulhojava.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("breno");
        titular1.setDocumento("123.456-00");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);

        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-09-27T00:48:00"));
        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Magda");
        titular2.setDocumento("123.456-99");
        //autoboxing do valor 10_000d
        titular1.setRendimentoAnual(new BigDecimal("10000"));

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1,123,987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 123,456,new BigDecimal("10000"));
        try {
            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("1000"));
            minhaConta.creditarRendimento(new BigDecimal("0.8"));
            minhaConta.debitarTarifaMensal();

            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("500"));
            suaConta.debitarTarifaMensal();
            caixaEletronico.imprimirSaldo(suaConta);

            //polimorfismo em ação: como Holerite é um DocumentoPagabel, documento pagavel pode receber um Holerite
            DocumentoPagavel salarioFuncionario = new Holerite(titular1, new BigDecimal("100"), 120);
            System.out.println("Holerite valor: " + salarioFuncionario.getValorTotal());
            System.out.println("Holerite pago: " + salarioFuncionario.estaPago());
            caixaEletronico.pagar(salarioFuncionario, minhaConta);
            System.out.println("Holerite pago: " + salarioFuncionario.estaPago());

            System.out.println("---------------------------------");

            Boleto boletoEscola = new Boleto(titular2, new BigDecimal("8000"));

            caixaEletronico.imprimirSaldo(minhaConta);

            System.out.println("Boleto pago: " + boletoEscola.estaPago());
            caixaEletronico.pagar(boletoEscola, minhaConta);
            boletoEscola.imprimirRecibo();
            System.out.println("Boleto pago: " + boletoEscola.estaPago());

            caixaEletronico.imprimirSaldo(minhaConta);
            caixaEletronico.estonarPagamento(boletoEscola, minhaConta);

            caixaEletronico.imprimirSaldo(minhaConta);
        } catch (SaldoInsuficienteException e){
            System.out.println("Erro ao execução operação na conta: " + e.getMessage());
        }

    }
}
