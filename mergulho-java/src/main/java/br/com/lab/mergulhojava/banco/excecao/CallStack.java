package br.com.lab.mergulhojava.banco.excecao;

public class CallStack {

    public static void main(String[] args) {
        metodo1();
        int a = 40;
    }
    static public void metodo1(){
        metodo2();
    }
    static public void metodo2(){
        throw  new IllegalArgumentException();
    }
}
