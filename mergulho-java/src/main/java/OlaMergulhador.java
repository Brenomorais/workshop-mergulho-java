public class OlaMergulhador {
    public static void main(String[] args) {
        System.out.println("Olá Mundo!");

        String nomeCompleto;
        nomeCompleto = "breno lopes morais";

        System.out.println("Nome: " +nomeCompleto);

        //int tipo primitivo de inteiros positios e negativos suporta 32bits
        int minhaIdade = 28;

        System.out.println("Idade: " +minhaIdade);

        int a = 10;
        int b = 20;
        int soma = a + b;

        System.out.println("Totam da soma: " +soma);

        double meuPeso = 70.5;

        System.out.println("Meu peso " +meuPeso);

        float meuSalario = 1_294.93f;

        System.out.println("Meu Salario " +meuSalario);

        boolean entrada = false;

        System.out.println(entrada);

        System.out.println("Operador Maior:"+ (minhaIdade >= 18));

        System.out.println("Operador Menor:"+ (minhaIdade <= 18));

        System.out.println("Operador Igualdade:"+ (minhaIdade == 18));

        System.out.println("Operador Diferente:"+ (minhaIdade != 18));
    }
}
