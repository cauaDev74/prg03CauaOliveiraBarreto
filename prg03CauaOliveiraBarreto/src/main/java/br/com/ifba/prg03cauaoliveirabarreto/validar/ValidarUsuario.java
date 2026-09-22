package br.com.ifba.prg03cauaoliveirabarreto.validar;

public class ValidarUsuario {

    private static final int TAMANHO_CPF = 11;
    private static final int TAMANHO_MINIMO_SENHA = 6;
    private static final String[] PALAVRAS_PROIBIDAS = {"admin", "teste", "senha123", "root"};

    //Método para verificar o preechimento dos campos
    public static boolean camposPreenchidos(String nome, String cpf, String email,
            String login, String senha, String confirmaSenha) {
        return nome != null && !nome.isEmpty()
                && cpf != null && !cpf.isEmpty()
                && email != null && !email.isEmpty()
                && login != null && !login.isEmpty()
                && senha != null && !senha.isEmpty()
                && confirmaSenha != null && !confirmaSenha.isEmpty();
    }
    
    //Método para validar o cpf
    public static boolean cpfValido(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }
        return cpf.matches("\\d{" + TAMANHO_CPF + "}");
    }
    
    //Método para analisar a força da senha
    public static boolean senhaForte(String senha) {
        return senha != null && senha.length() >= TAMANHO_MINIMO_SENHA;
    }
    //Método para comparar as senhas
    public static boolean senhasConferem(String senha, String confirmaSenha) {
        return senha != null && senha.equals(confirmaSenha);
    }
    //Método para procurar palavras proibidas
    public static boolean contemPalavraProibida(String texto) {
        if (texto == null) {
            return false;
        }
        for (String palavra : PALAVRAS_PROIBIDAS) {
            if (texto.contains(palavra)) {
                return true;
            }
        }
        return false;
    }
}