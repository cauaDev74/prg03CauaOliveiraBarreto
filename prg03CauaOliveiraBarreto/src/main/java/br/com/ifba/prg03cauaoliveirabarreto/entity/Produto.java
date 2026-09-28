package br.com.ifba.prg03cauaoliveirabarreto.entity;

public class Produto {

    private Integer codigo;
    private String nome;
    private String descricao;
    private Double valorUnitario;

    public Produto(Integer codigo, String nome, String descricao, Double valorUnitario) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
