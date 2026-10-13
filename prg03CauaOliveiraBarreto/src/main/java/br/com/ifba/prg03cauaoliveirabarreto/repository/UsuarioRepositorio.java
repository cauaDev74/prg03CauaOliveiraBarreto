package br.com.ifba.prg03cauaoliveirabarreto.repository;

import br.com.ifba.prg03cauaoliveirabarreto.entity.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioRepositorio {
    //List<Usuario>, não List: é o generics dizendo ao compilador o que tem
    //dentro da coleção, sem precisar de cast toda vez que um objeto sai dela.
    private final List<Usuario> usuarios = new ArrayList<>();

    //Índice por login, alimentado junto com a lista a cada cadastro
    private final Map<String, Usuario> porLogin = new HashMap<>();

    public void cadastrar(Usuario usuario) {
        usuarios.add(usuario);
        porLogin.put(usuario.getLogin(), usuario);
    }

    public List<Usuario> listarTodos() {
        //Devolve uma cópia: quem chama não consegue alterar a lista interna por fora
        return new ArrayList<>(usuarios);
    }

    //Busca varrendo a List - O(n): no pior caso, compara com todo mundo até achar
    public Usuario buscarPorLoginVarrendoLista(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        return null;
    }

    //Busca via Map - O(1) em média: vai direto no balde certo pelo hash do login,
    //sem precisar passar pelos outros usuários
    public Usuario buscarPorLogin(String login) {
        return porLogin.get(login);
    }
}
