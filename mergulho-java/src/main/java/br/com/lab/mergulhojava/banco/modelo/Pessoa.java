package br.com.lab.mergulhojava.banco.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private String documento;

    private BigDecimal rendimentoAnual;

    private TipoPessoa tipo = TipoPessoa.FISICA;

    private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();

    public Pessoa(){
    }

    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public BigDecimal getRendimentoAnual() {
        return rendimentoAnual;
    }

    public void setRendimentoAnual(BigDecimal rendimentoAnual) {
        this.rendimentoAnual = rendimentoAnual;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipo=" + tipo +
                '}'+
                "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass() ) return false;

        // cast de obj para Pessoa
        Pessoa pessoa = (Pessoa) obj;

        //a verificação nesse caso aqui está sendo pelo documento
        return  documento.equals(pessoa.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
