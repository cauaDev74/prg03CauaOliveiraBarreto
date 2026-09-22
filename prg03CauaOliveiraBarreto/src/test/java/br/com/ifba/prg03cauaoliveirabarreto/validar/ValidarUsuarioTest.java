package br.com.ifba.prg03cauaoliveirabarreto.validar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidarUsuarioTest {

    @Test
    void camposPreenchidos_deveRetornarTrue_quandoTudoPreenchido() {
        assertTrue(ValidarUsuario.camposPreenchidos("Cauã", "12345678901", "a@a.com", "caua", "123456", "123456"));
    }

    @Test
    void camposPreenchidos_deveRetornarFalse_quandoCampoVazio() {
        assertFalse(ValidarUsuario.camposPreenchidos("", "12345678901", "a@a.com", "caua", "123456", "123456"));
    }

    @Test
    void camposPreenchidos_deveRetornarFalse_quandoCampoNulo() {
        assertFalse(ValidarUsuario.camposPreenchidos(null, "12345678901", "a@a.com", "caua", "123456", "123456"));
    }

    @Test
    void cpfValido_deveRetornarTrue_paraCpfComOnzeDigitos() {
        assertTrue(ValidarUsuario.cpfValido("12345678901"));
    }

    @Test
    void cpfValido_deveRetornarFalse_paraCpfVazio() {
        assertFalse(ValidarUsuario.cpfValido(""));
    }

    @Test
    void cpfValido_deveRetornarFalse_paraCpfComLetras() {
        assertFalse(ValidarUsuario.cpfValido("123abc78901"));
    }

    @Test
    void cpfValido_deveRetornarFalse_paraCpfNulo() {
        assertFalse(ValidarUsuario.cpfValido(null));
    }

    @Test
    void senhaForte_deveRetornarTrue_paraSenhaComTamanhoMinimo() {
        assertTrue(ValidarUsuario.senhaForte("123456"));
    }

    @Test
    void senhaForte_deveRetornarFalse_paraSenhaMenorQueMinimo() {
        assertFalse(ValidarUsuario.senhaForte("123"));
    }

    @Test
    void senhaForte_deveRetornarFalse_paraSenhaNula() {
        assertFalse(ValidarUsuario.senhaForte(null));
    }
}