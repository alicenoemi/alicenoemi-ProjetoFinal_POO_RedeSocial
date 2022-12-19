package br.com.ada.redesocial;

public class Post {
    private String data;
    private String hora;
    private String conteudo;

    public Post (String data, String hora, String conteudo) {
        this.data = data;
        this.hora = hora;
        this.conteudo = conteudo;
    }

    public Post() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;    }

    public void setHora(String hora) {
        this.hora = hora;    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}