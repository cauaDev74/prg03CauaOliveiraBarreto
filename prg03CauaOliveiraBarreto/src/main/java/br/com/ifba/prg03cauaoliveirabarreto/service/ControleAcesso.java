package br.com.ifba.prg03cauaoliveirabarreto.service;

import br.com.ifba.prg03cauaoliveirabarreto.entity.Usuario;

public class ControleAcesso {

    //Recebe o tipo geral (Usuario), nunca o tipo concreto (Cliente/Admin).
    //Não sabe qual classe chegou - quem decide a resposta é o próprio objeto,
    //através do isAdministrador() que cada um herda ou sobrescreve.
    public static boolean temAcessoAdministrativo(Usuario usuario) {
        return usuario.isAdministrador();
    }

    public static String descreverAcesso(Usuario usuario) {
        return usuario.getNome() + " - acesso administrativo: " + usuario.isAdministrador();
    }
}