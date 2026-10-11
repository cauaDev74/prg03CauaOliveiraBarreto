/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.prg03cauaoliveirabarreto.entity;
import br.com.ifba.prg03cauaoliveirabarreto.interfaces.Autenticavel;

/**
 *
 * @author Admin
 */
//Classe Usuário
public class Usuario implements Autenticavel {
    
    //Atributos
    private String nome;
    private String cpf;
    private String email;
    
    //Atributos de login
    private String login;
    private String senha;

    //Construtor


    public Usuario() {

    }

    public Usuario(String nome, String cpf, String login, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.email = email;
        this.senha = senha;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //Métodos
    
    //Método da interface java
    @Override
    public boolean autenticar(String login, String senha){
        //Compara os dados e retorna verdadeiro ou falso
        return this.login.equals(login) && this.senha.equals(senha);
    }

    //Método pensado pra ser sobrescrito pelas subclasses (Cliente, Admin).
    //Por padrão, um usuário genérico não tem permissão de administrador.
    public boolean isAdministrador() {
        return false;
    }
}
