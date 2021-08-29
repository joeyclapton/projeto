package entity;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Scanner;
import static java.nio.file.Files.readAllLines;

import entity.Usuario;
import entity.Aluno;
import entity.Professor;
import entity.Secretaria;
import utils.Teclado;

public class Menu {
    private ArrayList<Usuario> usuarios;
    private List<String> dadosUsuarios;

    public Menu() throws Exception {
        this.init();
    }

    private void init() throws Exception {
        Scanner teclado = new Scanner(System.in);
        this.usuarios = new ArrayList<>();
        this.popularDados();

        Usuario usuarioLogado = this.login(teclado, this.usuarios);
        System.out.println(usuarioLogado);
        menuLogin(usuarioLogado);
    }

    private Usuario login(Scanner teclado, ArrayList<Usuario> usuarios) {
        System.out.println("Fazer login");
        System.out.println("Digite sua matrícula: ");
        int matricula = teclado.nextInt();

        teclado.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = teclado.nextLine();

        Usuario usuarioLogado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.fazerLogin(matricula, senha)) {
                usuarioLogado = usuario;
            }
        }
        return usuarioLogado;
    }

    private void cadastrarUsuarios() {
        for (int i = 0; i < this.dadosUsuarios.size(); i++) {
            String dadoUsuario[] = this.dadosUsuarios.get(i).split(";");
            String tipo = dadoUsuario[0];
            String nome = dadoUsuario[1];
            int matricula = Integer.parseInt(dadoUsuario[2]);
            String senha = dadoUsuario[3];
            if (tipo.equals("ALUNO")) {
                this.usuarios.add(new Aluno(matricula, nome, senha, null));
            } else if (tipo.equals("PROFESSOR")) {
                this.usuarios.add(new Professor(matricula, nome, senha));
            } else {
                this.usuarios.add(new Secretaria(matricula, nome, senha));
            }
        }
    }

    private void popularDados() throws IOException {
        String pathUsuarios = ("implementacao/app/src/data/usuarios.txt");
        this.dadosUsuarios = readAllLines(Paths.get(pathUsuarios), Charset.defaultCharset());

        this.cadastrarUsuarios();
    }

    private int menuSecretaria(Scanner teclado) {
        System.out.println("Secretaria:");
        this.divisor();
        System.out.println("Digite sua opção: ");
        System.out.println("1- Gerar currículo semestral para curso");
        System.out.println("2- Adicionar novo aluno");
        System.out.println("0 - Sair");

        int opcao = teclado.nextInt();

        teclado.nextLine();

        return opcao;
    }

    private void divisor() {
        System.out.println("-----------------------------------------");
    }

    private void menuLogin(Usuario usuarioLogado) {
        Teclado.limparTela();

        Scanner teclado = new Scanner(System.in);
        if (usuarioLogado.getClass().equals(Secretaria.class)) {
            var opcao = 0;
            var secretaria = new Secretaria(usuarioLogado.getMatricula(), usuarioLogado.getNome(),
                    usuarioLogado.getSenha());
            do {
                opcao = menuSecretaria(teclado);

                if (opcao == 2) {
                    System.out.println("Digite a matricula do aluno: ");
                    var matricula = teclado.nextInt();

                    teclado.nextLine();

                    System.out.println("Digite o nome do aluno: ");
                    var nome = teclado.nextLine();

                    System.out.println("Digite a senha do aluno: ");
                    var senha = teclado.nextLine();

                    var aluno = secretaria.adicionarAluno(matricula, nome, senha);
                    this.usuarios.add(aluno);
                }

            } while (opcao != 0);
        }

    }
}
