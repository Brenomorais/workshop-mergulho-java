package br.com.lab.mergulhojava.app;

import br.com.lab.mergulhojava.banco.modelo.*;
import br.com.lab.mergulhojava.banco.modelo.atm.CaixaEletronico;
import br.com.lab.mergulhojava.banco.modelo.pagamento.Boleto;
import br.com.lab.mergulhojava.banco.modelo.pagamento.DocumentoPagavel;
import br.com.lab.mergulhojava.banco.modelo.pagamento.Holerite;

public class Principal {
    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("breno");
        titular1.setDocumento("123.456-00");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Magda");
        titular2.setDocumento("123.456-99");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1,123,987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 123,456,1_000);

        minhaConta.depositar(15_000);
        minhaConta.sacar(1000);
        minhaConta.creditarRendimento(0.8);
        minhaConta.debitarTarifaMensal();

        suaConta.depositar(15_000);
        suaConta.sacar(15_000);
        suaConta.debitarTarifaMensal();
        caixaEletronico.imprimirSaldo(suaConta);

        //polimorfismo em ação: como Holerite é um DocumentoPagabel, documento pagavel pode receber um Holerite
        DocumentoPagavel salarioFuncionario = new Holerite(titular1,100,120);
        System.out.println("Holerite valor: " + salarioFuncionario.getValorTotal());
        System.out.println("Holerite pago: " + salarioFuncionario.estaPago());
        caixaEletronico.pagar(salarioFuncionario, minhaConta);
        System.out.println("Holerite pago: " + salarioFuncionario.estaPago());

        System.out.println("---------------------------------");

        Boleto boletoEscola = new Boleto(titular2,200);

        caixaEletronico.imprimirSaldo(minhaConta);

        System.out.println("Boleto pago: " + boletoEscola.estaPago());
        caixaEletronico.pagar(boletoEscola, minhaConta);
        boletoEscola.imprimirRecibo();
        System.out.println("Boleto pago: " + boletoEscola.estaPago());

        caixaEletronico.imprimirSaldo(minhaConta);
        caixaEletronico.estonarPagamento(boletoEscola, minhaConta);

        caixaEletronico.imprimirSaldo(minhaConta);
    }
}
