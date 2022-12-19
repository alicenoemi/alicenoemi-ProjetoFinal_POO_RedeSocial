package br.com.ada.redesocial;

import br.com.ada.redesocial.myExceptions.EmptyFieldException;
import br.com.ada.redesocial.myExceptions.ExistingUserExceptions;
import br.com.ada.redesocial.myExceptions.InvalidPasswordException;
import br.com.ada.redesocial.myExceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class RedeSocial {
    private Scanner entrada = new Scanner(System.in);
    private ArrayList<Perfil> usuarios = new ArrayList<>();
    private ArrayList<Post> posts = new ArrayList<>();

    public void iniciar() {
        System.out.println("============== Seja Bem-Vindo A Rede Social ===========");
        System.out.println("");
        System.out.println("	^..^       /");
        System.out.println("	/_/\\_____/    #Dev-Makers2");
        System.out.println("	   /\\   /\\");
        System.out.println("	  /  \\ /  \\");
        System.out.println("			Esse é o makerzinho, o nosso mascote! o/");
        System.out.println("");
        menuInicial();
    }

    public void menuInicial(){
        try {
            System.out.println("==============    MENU INICIAL   ================");
            System.out.println("Qual operação você deseja realizar:\n"
                    + "C - Cadastrar perfil \n"
                    + "E - Entrar na sua conta \n"
                    + "L - Lista de usuarios \n"
                    + "S - Sair");

            String opcao = entrada.nextLine().toUpperCase();
            switch (opcao){
                case "C":
                    cadastrarUsuario();
                    menuInicial();
                    break;
                case "E":
                    fazerLogin();
                    break;
                case "L":
                    usersList();
                    menuInicial();
                    break;
                case "S":
                    sair();
                    break;
                default:
                    System.out.println("Operação inválida. Tente novamente.");
                    menuInicial();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Opss .. algo deu errado! Tente novamente.");
            menuInicial();
        }
    }

     private void cadastrarUsuario(){
        try {
            System.out.println("===== CADASTRO DE USUARIOS =====");
            System.out.print("Digite seu nome: ");
            String nome = entrada.nextLine();

            System.out.print("Crie seu login: ");
            String login = entrada.nextLine();
            for (Perfil p: usuarios) {
                if (p.getLogin().equals(login)) {
                    throw new ExistingUserExceptions();
                }
            }

            System.out.print("Crie sua senha: ");
            String senha = entrada.nextLine().toLowerCase();

            if (nome.isEmpty() || nome.isBlank() || login.isEmpty() || login.isBlank() || senha.isEmpty() || senha.isBlank()) {
                throw new EmptyFieldException();
            }

            Perfil p1 = new Perfil(nome, login, senha);
            usuarios.add(p1);
            System.out.println("Perfil criado com sucesso!!!");
            System.out.println("");

        } catch (ExistingUserExceptions e) {
            System.out.println(e.getMessage());
            menuInicial();
        } catch (EmptyFieldException e) {
            System.out.println(e.getMessage());
            cadastrarUsuario();
        }
    }

    private void fazerLogin() {
        try {
            Perfil perfil = new Perfil();
            if (usuarios.size() == 0) {
                System.out.println("Opss .. nenhum perfil cadastrado!");
                menuInicial();
            } else {
                System.out.println("===== LOGIN =====");
                System.out.println("Entre com seu login e senha para acessar a Rede Social.");
                System.out.print("Login: ");
                String login = entrada.next().toLowerCase();
                System.out.print("Senha: ");
                String senha = entrada.next().toLowerCase();

                for (int i = 0; i < usuarios.size(); i++) {
                    if(usuarios.get(i).getLogin().equals(login)) {
                        if(usuarios.get(i).getSenha().equals(senha)) {
                            System.out.println("Olha quem chegou!!");
                            System.out.println("	^..^       /");
                            System.out.println("	/_/\\_____/     Oi, " + usuarios.get(i).getNome() + "!!");
                            System.out.println("	   /\\   /\\");
                            System.out.println("	  /  \\ /  \\");
                            System.out.println("É um prazer te ver por aqui!");

                            perfil.menuUsuario();
                        } else {
                            throw new InvalidPasswordException();
                        }
                    }
                }
                throw new UserNotFoundException();
            }
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
            fazerLogin();
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            fazerLogin();
        } catch (Exception e) {
            System.out.println("Opss... algo deu errado por aqui.");
        }
    }

    private void usersList() {
        if (usuarios.size() == 0) {
            System.out.println("Opss .. nenhum perfil cadastrado!");
            menuInicial();
        } else {
            System.out.println("===== LISTA DE USUARIOS =====");
            System.out.println("Aqui esta a lista de usuarios:");
            for (int j = 0; j < usuarios.size(); j++) {
                System.out.printf("Nome: %s Login: %s \n", usuarios.get(j).getNome(), usuarios.get(j).getLogin());
            }
        }
    }

    public void sair() {
        System.out.println("Opa, já vai?? ");
        System.out.println("	^..^      /");
        System.out.println("	/_/\\_____/    #tchAUtchAU");
        System.out.println("	   /\\   /\\");
        System.out.println("	  /  \\ /  \\");
        System.out.println("			  Esperamos de te ver em breve! o/");
        System.exit(0);
    }
}

