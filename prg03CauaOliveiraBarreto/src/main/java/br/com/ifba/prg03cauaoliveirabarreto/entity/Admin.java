package br.com.ifba.prg03cauaoliveirabarreto.entity;

//específico de quem administra o sistema.
public class Admin extends Usuario {

    //Atributo específico do Admin
    private int nivelAcesso;

    //Construtor: preenche os dados herdados de Usuario através do método super
    public Admin(String nome, String cpf, String email, String login, String senha, int nivelAcesso) {
        super(nome, cpf, login, email, senha);
        this.nivelAcesso = nivelAcesso;
    }

    //Getter e Setter
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    //Sobrescreve o comportamento padrão de Usuario: um Admin sempre tem permissão
    @Override
    public boolean isAdministrador() {
        return true;
    }
}
