/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.prg03cauaoliveirabarreto.entity;

//específico de quem compra na loja.
public class Cliente extends Usuario {

    //Atributo específico do Cliente
    private String enderecoEntrega;

    //Construtor: preenche os dados herdados de Usuario através do método super()
    public Cliente(String nome, String cpf, String email, String login, String senha, String enderecoEntrega) {
        super(nome, cpf, login, email, senha);
        this.enderecoEntrega = enderecoEntrega;
    }

    //Getter e Setter
    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    //Cliente não sobrescreve isAdministrador(): usa o "false" padrão herdado de Usuario
}
