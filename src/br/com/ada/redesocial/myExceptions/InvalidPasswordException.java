package br.com.ada.redesocial.myExceptions;

public class InvalidPasswordException extends Exception {
    public String getMessage() {
        return "Senha inválida. Tente novamente.";
    }
}
