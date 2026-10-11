package br.com.ifba.prg03cauaoliveirabarreto.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioHierarquiaTest {

    //--- Comportamento herdado: Cliente/Admin usando método pronto de Usuario ---

    @Test
    void cliente_deveUsarGetNomeHerdadoDeUsuario() {
        Cliente cliente = new Cliente(
                "Cauã",
                "111.111.111-11",
                "caua@email.com",
                "caua", "1234",
                "Rua A, 123"
        );

        //getNome() não é sobrescrito em Cliente: é o método herdado de Usuario
        assertEquals("Cauã", cliente.getNome());
    }

    @Test
    void admin_deveUsarGetEmailHerdadoDeUsuario() {
        Admin admin = new Admin(
                "Maria",
                "222.222.222-22",
                "maria@email.com",
                "maria",
                "senha123",
                5
        );

        //getEmail() também não é sobrescrito: vem direto da classe mãe
        assertEquals("maria@email.com", admin.getEmail());
    }

    @Test
    void cliente_deveUsarAutenticarHerdadoDeUsuario() {
        Cliente cliente = new Cliente(
                "Cauã",
                "111.111.111-11", "caua@email.com",
                "caua",
                "1234",
                "Rua A, 123"
        );

        //autenticar() também é herdado, sem nenhuma sobrescrita em Cliente
        assertTrue(cliente.autenticar("caua", "1234"));
        assertFalse(cliente.autenticar("caua", "senhaErrada"));
    }

    //--- Comportamento sobrescrito: cada classe devolvendo seu próprio resultado ---

    @Test
    void cliente_naoSobrescreveIsAdministrador_deveRetornarFalse() {
        Cliente cliente = new Cliente(
                "Cauã",
                "111.111.111-11",
                "caua@email.com",
                "caua",
                "1234",
                "Rua A, 123");

        //Cliente não sobrescreve: usa o comportamento padrão herdado de Usuario
        assertFalse(cliente.isAdministrador());
    }

    @Test
    void admin_deveSobrescreverIsAdministrador_paraRetornarTrue() {
        Admin admin = new Admin(
                "Maria",
                "222.222.222-22",
                "maria@email.com",
                "maria",
                "senha123",
                5);

        //Admin sobrescreve isAdministrador() com seu próprio resultado
        assertTrue(admin.isAdministrador());
    }

    @Test
    void clienteEAdmin_devemRetornarResultadosDiferentesParaIsAdministrador() {
        Cliente cliente = new Cliente(
                "Cauã",
                "111.111.111-11",
                "caua@email.com",
                "caua",
                "1234",
                "Rua A, 123"
        );
        Admin admin = new Admin(
                "Maria",
                "222.222.222-22",
                "maria@email.com",
                "maria",
                "senha123",
                5
        );

        assertNotEquals(cliente.isAdministrador(), admin.isAdministrador());
    }

    //--- Bônus: Cliente e Admin podem ser tratados como Usuario (polimorfismo) ---

    @Test
    void clienteEAdmin_saoUmUsuario_gracasAHeranca() {
        Usuario usuarioCliente = new Cliente(
                "Cauã",
                "111.111.111-11",
                "caua@email.com",
                "caua",
                "1234",
                "Rua A, 123"
        );
        Usuario usuarioAdmin = new Admin(
                "Maria",
                "222.222.222-22",
                "maria@email.com",
                "maria",
                "senha123",
                5
        );

        //Cliente e Admin podem ser tratados como Usuario (polimorfismo)
        assertTrue(usuarioCliente instanceof Usuario);
        assertTrue(usuarioAdmin instanceof Usuario);
        assertFalse(usuarioCliente.isAdministrador());
        assertTrue(usuarioAdmin.isAdministrador());
    }
}
