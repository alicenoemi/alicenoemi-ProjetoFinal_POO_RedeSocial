package br.com.ada.redesocial.myExceptions;

public class ExistingUserExceptions extends Exception{
    public String getMessage() {
        return "Usuário existente. Tente novamente.";
    }
}
