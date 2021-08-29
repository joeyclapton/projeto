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
import commons.ClassificacaoDisciplinaEnum;
import utils.Teclado;

public class Menu {
    private ArrayList<Usuario> usuarios;
    private List<String> dadosUsuarios;

    private ArrayList<Disciplina> disciplinas;
    private List<String> dadosDisciplinas;

    public Menu() throws Exception {
        this.init();
    }

    private void init() throws Exception {
        Scanner teclado = new Scanner(System.in);
        this.usuarios = new ArrayList<>();
        this.disciplinas = new ArrayList<>();

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

    private void cadastrarDisciplinas() {
        for (int i = 0; i < this.dadosDisciplinas.size(); i++) {
            String dadoDisciplina[] = this.dadosDisciplinas.get(i).split(";");
            String nome = dadoDisciplina[0];
            int num_creditos = Integer.parseInt(dadoDisciplina[1]);
            String tipo = dadoDisciplina[2];

            if (tipo.equals("OBRIGATORIA")) {
                this.disciplinas
                        .add(new Disciplina(nome, num_creditos, ClassificacaoDisciplinaEnum.OBRIGATORIA, null, null));
            } else {
                this.disciplinas
                        .add(new Disciplina(nome, num_creditos, ClassificacaoDisciplinaEnum.OPTATIVA, null, null));
            }
        }
    }

    private void popularDados() throws IOException {
        String pathUsuarios = ("implementacao/app/src/data/usuarios.txt");
        String pathDisciplinas = ("implementacao/app/src/data/disciplinas.txt");

        this.dadosUsuarios = readAllLines(Paths.get(pathUsuarios), Charset.defaultCharset());
        this.dadosDisciplinas = readAllLines(Paths.get(pathDisciplinas), Charset.defaultCharset());

        this.cadastrarUsuarios();
        this.cadastrarDisciplinas();
    }

    private int menuSecretaria(Scanner teclado) {
        System.out.println("Sistema secretaria");
        this.divisor();
        System.out.println("Digite sua opção: ");
        System.out.println("1- Gerar currículo semestral para curso");
        System.out.println("2- Adicionar novo aluno");
        System.out.println("0 - Sair");

        int opcao = teclado.nextInt();
        teclado.nextLine();

        return opcao;
    }

    private int menuProfessor(Scanner teclado) {
        System.out.println("Sistema professor");
        this.divisor();
        System.out.println("Digite sua opção: ");
        System.out.println("1- Listar alunos");
        System.out.println("0 - Sair");

        int opcao = teclado.nextInt();
        teclado.nextLine();

        return opcao;
    }

    private int menuAluno(Scanner teclado) {
        System.out.println("Sistema aluno");
        this.divisor();
        System.out.println("Digite sua opção: ");
        System.out.println("1- Cadastrar disciplina");
        System.out.println("0- Sair");

        int opcao = teclado.nextInt();
        teclado.nextLine();

        return opcao;
    }

    private void listarDisciplinas(int opcao) {
        Teclado.limparTela();
        var disciplinaSelecionada = null;

        for (int i = 0; i < this.disciplinas.size(); i++) {
            var disciplina = this.disciplinas.get(i);

            this.divisor();

            System.out.println((i + 1) + "- " + disciplina.getNome() + " - " + disciplina.getTipo());
        }
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
        } else if (usuarioLogado.getClass().equals(Aluno.class)) {
            var opcao = 0;

            do {
                opcao = menuAluno(teclado);

                switch (opcao) {
                    case 1:
                        System.out.println("Digite a matéria escolhida: ");
                        var materia = teclado.nextInt();

                        this.listarDisciplinas(materia);
                        break;
                }

            } while (opcao != 0);
        }

    }
}
