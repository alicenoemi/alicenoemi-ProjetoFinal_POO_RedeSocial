package br.com.ada.redesocial.myExceptions;

public class EmptyFieldException extends Exception {
    public String getMessage() {

        return "Favor preencher todos os campos.";
    }
}
