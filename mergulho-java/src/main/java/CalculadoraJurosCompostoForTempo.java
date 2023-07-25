public class CalculadoraJurosCompostoForTempo {
    public static void main(String[] args) {
        double vaorAcumulado = 10000;
        double taxaJurosMensal = 0.8;
        int periodoEmMeses = 12;

        //iniciacao, condição, incremento
        for(int mes = 1; mes <= periodoEmMeses; mes++){
            //vaorAcumulado += vaorAcumulado * taxaJurosMensal / 100;
            vaorAcumulado = vaorAcumulado + (vaorAcumulado * taxaJurosMensal / 100);

            System.out.println("Mês" + mes + " = " + vaorAcumulado);
        }

    }
}
