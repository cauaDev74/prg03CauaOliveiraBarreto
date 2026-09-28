package br.com.ifba.prg03cauaoliveirabarreto.entity;

import br.com.ifba.prg03cauaoliveirabarreto.enums.StatusPedido;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;
    private String data;
    private StatusPedido status;
    private Usuario usuario;
    private final List<ItemPedido> itens;

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
        this.status = StatusPedido.ABERTO;
        this.itens = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    //Adiciona um item à lista sem expor a lista original para fora da classe
    public void adicionarItem(ItemPedido item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }
        this.itens.add(item);
    }

    //Retorna uma cópia da lista, para que ninguém consiga alterar
    //os itens do pedido diretamente por fora da classe
    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }

    public double getValorTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }
}
