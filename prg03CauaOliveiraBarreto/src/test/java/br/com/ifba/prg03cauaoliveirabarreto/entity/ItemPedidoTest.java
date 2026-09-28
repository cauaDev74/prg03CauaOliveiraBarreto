package br.com.ifba.prg03cauaoliveirabarreto.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {

    @Test
    void construtor_devePreencherPrecoUnitario_apartirDoValorDoProduto() {
        Produto produto = new Produto(1, "Filtro de óleo", "Filtro de óleo automotivo", 45.90);

        ItemPedido item = new ItemPedido(produto, 3);

        assertEquals(45.90, item.getPrecoUnitario());
    }

    @Test
    void getProduto_deveRetornarOObjetoRelacionadoPeloGetter() {
        Produto produto = new Produto(2, "Pastilha de freio", "Jogo de pastilhas dianteiras", 120.00);

        ItemPedido item = new ItemPedido(produto, 1);

        assertEquals(produto, item.getProduto());
    }

    @Test
    void getSubtotal_deveMultiplicarQuantidadePeloPrecoUnitario() {
        Produto produto = new Produto(3, "Vela de ignição", "Vela de ignição avulsa", 25.00);

        ItemPedido item = new ItemPedido(produto, 4);

        assertEquals(100.00, item.getSubtotal());
    }
}
