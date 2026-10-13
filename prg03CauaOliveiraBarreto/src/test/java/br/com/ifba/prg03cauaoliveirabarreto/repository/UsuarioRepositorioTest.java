package br.com.ifba.prg03cauaoliveirabarreto.repository;

import br.com.ifba.prg03cauaoliveirabarreto.entity.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioRepositorioTest {

    @Test
    void cadastrar_usuarioDeveAparecerEmListarTodos() {
        UsuarioRepositorio repositorio = new UsuarioRepositorio();
        Usuario usuario = new Usuario("Cauã", "111.111.111-11", "caua", "caua@email.com", "1234");

        repositorio.cadastrar(usuario);

        assertTrue(repositorio.listarTodos().contains(usuario));
        assertEquals(1, repositorio.listarTodos().size());
    }

    @Test
    void buscarPorLogin_comDoisUsuarios_devolveOCerto() {
        UsuarioRepositorio repositorio = new UsuarioRepositorio();
        Usuario caua = new Usuario("Cauã", "111.111.111-11", "caua", "caua@email.com", "1234");
        Usuario maria = new Usuario("Maria", "222.222.222-22", "maria", "maria@email.com", "senha123");
        repositorio.cadastrar(caua);
        repositorio.cadastrar(maria);

        assertEquals(maria, repositorio.buscarPorLogin("maria"));
        assertEquals(caua, repositorio.buscarPorLogin("caua"));
    }

    @Test
    void buscarPorLogin_loginInexistente_devolveNull() {
        UsuarioRepositorio repositorio = new UsuarioRepositorio();
        repositorio.cadastrar(new Usuario("Cauã", "111.111.111-11", "caua", "caua@email.com", "1234"));

        assertNull(repositorio.buscarPorLogin("naoexiste"));
    }

    @Test
    void doisUsuariosComMesmoLogin_saoIguaisParaAListaGracasAoEquals() {
        UsuarioRepositorio repositorio = new UsuarioRepositorio();
        Usuario original = new Usuario("Cauã", "111.111.111-11", "caua", "caua@email.com", "1234");
        Usuario outraInstanciaMesmoLogin = new Usuario("Outro Nome", "999.999.999-99", "caua", "outro@email.com", "outrasenha");

        repositorio.cadastrar(original);

        //Mesmo sendo um objeto diferente, com dados diferentes, o login é o
        //mesmo - e é o login que define igualdade aqui (ver Usuario.equals)
        assertTrue(repositorio.listarTodos().contains(outraInstanciaMesmoLogin));
    }
}
