package br.com.ifba.prg03cauaoliveirabarreto.service;

import br.com.ifba.prg03cauaoliveirabarreto.entity.Admin;
import br.com.ifba.prg03cauaoliveirabarreto.entity.Cliente;
import br.com.ifba.prg03cauaoliveirabarreto.entity.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControleAcessoTest {

    @Test
    void cliente_naoTemAcessoAdministrativo() {
        //Tipo geral à esquerda: o método não sabe que é um Cliente
        Usuario pessoa = new Cliente("Cauã", "111.111.111-11", "caua@email.com", "caua", "1234", "Rua A, 123");

        assertFalse(ControleAcesso.temAcessoAdministrativo(pessoa));
    }

    @Test
    void admin_temAcessoAdministrativo() {
        //Mesmo método, mesmo tipo de parâmetro (Usuario) - resposta diferente
        Usuario pessoa = new Admin("Maria", "222.222.222-22", "maria@email.com", "maria", "senha123", 5);

        assertTrue(ControleAcesso.temAcessoAdministrativo(pessoa));
    }

    @Test
    void clienteEAdmin_devemGerarSaidasDiferentesParaOMesmoMetodo() {
        Usuario cliente = new Cliente("Cauã", "111.111.111-11", "caua@email.com", "caua", "1234", "Rua A, 123");
        Usuario admin = new Admin("Maria", "222.222.222-22", "maria@email.com", "maria", "senha123", 5);

        String saidaCliente = ControleAcesso.descreverAcesso(cliente);
        String saidaAdmin = ControleAcesso.descreverAcesso(admin);

        assertNotEquals(saidaCliente, saidaAdmin);
        assertEquals("Cauã - acesso administrativo: false", saidaCliente);
        assertEquals("Maria - acesso administrativo: true", saidaAdmin);
    }
}