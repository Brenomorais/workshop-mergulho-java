package br.com.lab.mergulhojava.banco.modelo.pagamento;

// herança para usar atributos valorTotal e estaPago de DocumentoPagavel
public interface DocumentoEstornavel extends  DocumentoPagavel {
    void estonarPagamento();
}
