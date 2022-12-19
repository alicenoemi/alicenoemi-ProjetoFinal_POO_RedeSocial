package br.com.ada.redesocial.myExceptions;

public class UserNotFoundException extends Exception {
    public String getMessage() {
        return "Usuário nao encontrado. Tente novamente.";
    }
}
