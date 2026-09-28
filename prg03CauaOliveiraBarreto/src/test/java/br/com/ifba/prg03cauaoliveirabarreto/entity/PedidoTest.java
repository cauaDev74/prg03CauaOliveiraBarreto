package br.com.ifba.prg03cauaoliveirabarreto.entity;

import br.com.ifba.prg03cauaoliveirabarreto.enums.StatusPedido;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Usuario criarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Cauã");
        usuario.setLogin("caua");
        usuario.setSenha("1234");
        return usuario;
    }

    @Test
    void pedidoRecemCriado_deveNascerComStatusAberto() {
        Pedido pedido = new Pedido(criarUsuario());

        assertEquals(StatusPedido.ABERTO, pedido.getStatus());
    }

    @Test
    void adicionarItem_deveAumentarOTamanhoDaLista() {
        Pedido pedido = new Pedido(criarUsuario());
        Produto produto = new Produto(1, "Óleo 5W30", "Óleo sintético", 60.00);

        assertEquals(0, pedido.getItens().size());

        pedido.adicionarItem(new ItemPedido(produto, 2));

        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void getUsuario_deveRetornarOObjetoRelacionadoPeloGetter() {
        Usuario usuario = criarUsuario();
        Pedido pedido = new Pedido(usuario);

        assertEquals(usuario, pedido.getUsuario());
    }

    @Test
    void getItens_naoDeveExporALitaInternaDoPedido() {
        Pedido pedido = new Pedido(criarUsuario());
        Produto produto = new Produto(1, "Óleo 5W30", "Óleo sintético", 60.00);
        pedido.adicionarItem(new ItemPedido(produto, 1));

        //Tenta alterar a lista retornada pelo getter
        pedido.getItens().clear();

        //A lista interna do pedido não pode ter sido afetada
        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void adicionarItem_deveLancarExcecao_quandoItemForNulo() {
        Pedido pedido = new Pedido(criarUsuario());

        assertThrows(IllegalArgumentException.class, () -> pedido.adicionarItem(null));
    }
}
