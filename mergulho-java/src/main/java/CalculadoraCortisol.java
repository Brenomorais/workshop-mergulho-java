public class CalculadoraCortisol {
    public static void main(String[] args) {
        double cortisol = 2;

        boolean resultadoNormal = cortisol >= 6.0 && cortisol <= 18.4;
       // boolean resultadoANormal = !resultadoNormal;
        boolean resultadoANormal = cortisol >= 6.0 || cortisol <= 18.4;

        System.out.println("Cortisol nomral: " +resultadoNormal);
        System.out.println("Cortisol Anomral: " +resultadoANormal);

        if(cortisol >= 6.0 && cortisol <= 18.4){
            System.out.println("Cortisol Nomral:");
        }else if(cortisol >= 18.4){
            System.out.println("Cortisol Alto: ");
        }else{
            System.out.println("Cortisol Baixo: ");
        }


    }
}
