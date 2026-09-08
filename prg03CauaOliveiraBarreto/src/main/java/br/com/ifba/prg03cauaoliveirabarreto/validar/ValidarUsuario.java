package br.com.ifba.prg03cauaoliveirabarreto.validar;

public class ValidarUsuario {
    public static boolean contemPalavraProibida(String texto){
        String[] array = {"admin", "teste", "senha123", "root"};

        for(String palavra : array){
            if(texto.contains(palavra)){
                return true;
            }
        }

        return false;
    }
}
