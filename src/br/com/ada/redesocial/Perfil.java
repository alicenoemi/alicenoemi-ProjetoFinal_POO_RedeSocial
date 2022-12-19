package br.com.ada.redesocial;

import br.com.ada.redesocial.myExceptions.EmptyFieldException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perfil {

    private String nome;
    private String login;
    private String senha;
    private Scanner entrada = new Scanner(System.in);
    private List<Post> posts = new ArrayList<>();

    public Perfil(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Perfil() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void menuUsuario(){
        try {
            RedeSocial rede = new RedeSocial();
            System.out.println("===== MENU DO USUARIO =====");
            System.out.println("O que deseja fazer?");
            System.out.println("P - Postar");
            System.out.println("T - Timeline");
            System.out.println("L - Logout");
            System.out.println("S - Sair");
            String opcao = entrada.next().toUpperCase();
            switch (opcao){
                case "P":
                    postar();
                    menuUsuario();
                    break;
                case "T":
                    timeline();
                    menuUsuario();
                    break;
                case "L":
                    System.out.println("Você se desconectou e será redirecionado para o Menu Inicial.");
                    System.out.println("");
                    rede.menuInicial();
                    break;
                case "S":
                    rede.sair();
                    break;
                default:
                    System.out.printf("Opss... Operação inválida. \n");
                    menuUsuario();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Opss .. algo deu errado. Tente novamente.");
            menuUsuario();
        }
    }

    protected void postar() {
        try {
            System.out.println("===== CRIANDO UM POST =====");
            System.out.print("");
            String pularLinha = entrada.nextLine();
            System.out.print("Digite a data (dd/mm/yyyy): ");
            String data = entrada.nextLine();
            System.out.print("Digite a hora (hh:mm): ");
            String hora = entrada.nextLine();
            System.out.print("Deixe aqui sua mensagem: ");
            String conteudo = entrada.nextLine();

            if (data.isEmpty() || data.isBlank() || hora.isEmpty() || hora.isBlank() || conteudo.isEmpty() || conteudo.isBlank()) {
                throw new EmptyFieldException();
            }

            Post post = new Post(data, hora, conteudo);
            posts.add(post);
            System.out.println("Post criado com sucesso!");
            System.out.println("");


        } catch (EmptyFieldException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void timeline() {
        System.out.println("===== TIMELINE =====");
        if (posts.size() == 0) {
            System.out.println("Opss .. você ainda não criou nenhum post!");
            menuUsuario();
        } else {
            System.out.println("Aqui estão suas últimas postagens:");
            for (int j = 0; j < posts.size() ; j++) {
                System.out.printf("%s às %s - '%s' \n", posts.get(j).getData(), posts.get(j).getHora(), posts.get(j).getConteudo());
            }
        }
    }
}
