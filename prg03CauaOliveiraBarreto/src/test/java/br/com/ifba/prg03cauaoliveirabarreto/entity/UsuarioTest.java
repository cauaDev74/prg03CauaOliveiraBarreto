package br.com.ifba.prg03cauaoliveirabarreto.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void autenticar_deveRetornarTrue_paraCredenciaisCorretas() {
        Usuario usuario = new Usuario();
        usuario.setLogin("caua");
        usuario.setSenha("1234");

        assertTrue(usuario.autenticar("caua", "1234"));
    }

    @Test
    void autenticar_deveRetornarFalse_paraSenhaIncorreta() {
        Usuario usuario = new Usuario();
        usuario.setLogin("caua");
        usuario.setSenha("1234");

        assertFalse(usuario.autenticar("caua", "senhaErrada"));
    }
}