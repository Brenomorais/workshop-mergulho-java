package br.com.lab.mergulhojava.aula1;

public class CalculadoraJurosCompostoMeta {
    public static void main(String[] args) {
        double vaorAcumulado = 10000;
        double valorMeta = 20000;
        double taxaJurosMensal = 0.8;
        int mes = 0;

        while (vaorAcumulado < valorMeta){
            mes++;

            vaorAcumulado += vaorAcumulado * taxaJurosMensal / 100;

            System.out.println("Mês" + mes + " = " + vaorAcumulado);
        }
    }
}
