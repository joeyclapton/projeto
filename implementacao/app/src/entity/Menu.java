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

import entity.*;
import utils.*;
import commons.*;

public class Menu {

    Sistema sistema;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Curso> cursos;

    public Menu() throws Exception {
        this.init();
    }

    private void init() throws Exception {
        this.sistema = new Sistema();

        this.disciplinas = this.sistema.getDisciplinas();
        this.usuarios = this.sistema.getUsuarios();
        this.cursos = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);

        Usuario usuarioLogado = null;
        menuLogin(usuarioLogado);
    }

    private int menuSecretaria(Scanner teclado) {
        System.out.println("Sistema secretaria");
        this.divisor();
        System.out.println("Digite sua opção: ");
        System.out.println("1- Cadastrar aluno");
        System.out.println("2- Cadastrar professor");
        System.out.println("3- Cadastrar curso");
        System.out.println("0 - Sair");
        this.divisor();

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
        this.divisor();

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
        this.divisor();

        int opcao = teclado.nextInt();
        teclado.nextLine();

        return opcao;
    }

    private void listarDisciplinas() {
        Teclado.limparTela();

        for (int i = 0; i < this.disciplinas.size(); i++) {
            var disciplina = this.disciplinas.get(i);

            this.divisor();

            System.out.println(disciplina.getId() + "- " + disciplina.getNome() + " - " + disciplina.getTipo());
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

                switch (opcao) {
                    case 1: {
                        System.out.println("Digite a matricula do aluno: ");
                        var matricula = teclado.nextInt();

                        teclado.nextLine();

                        System.out.println("Digite o nome do aluno: ");
                        var nome = teclado.nextLine();

                        System.out.println("Digite a senha do aluno: ");
                        var senha = teclado.nextLine();

                        var aluno = secretaria.adicionarAluno(matricula, nome, senha);
                        this.usuarios.add(aluno);
                        break;
                    }

                    case 2: {
                        System.out.println("Digite a matricula do professor: ");
                        var matricula = teclado.nextInt();

                        teclado.nextLine();

                        System.out.println("Digite o nome do professor: ");
                        var nome = teclado.nextLine();

                        System.out.println("Digite a senha do professor: ");
                        var senha = teclado.nextLine();

                        var professor = secretaria.adicionarProfessor(matricula, nome, senha);
                        this.usuarios.add(professor);
                        break;
                    }

                    case 3: {
                        System.out.println("Digite o id do curso: ");
                        var id = teclado.nextInt();

                        teclado.nextLine();

                        System.out.println("Digite o nome do curso: ");
                        var nome = teclado.nextLine();

                        System.out.println("Digite o número de creditos do curso");
                        var numCreditos = teclado.nextInt();

                        var curso = secretaria.adicionarCurso(id, nome, numCreditos);
                        this.cursos.add(curso);
                        System.out.println(this.cursos.size());
                        break;
                    }

                    default:
                        break;
                }

            } while (opcao != 0);

        } else if (usuarioLogado.getClass().equals(Aluno.class)) {
            var opcao = 0;

            do {
                opcao = menuAluno(teclado);

                switch (opcao) {
                    case 1:
                        var aluno = new Aluno(usuarioLogado.getMatricula(), usuarioLogado.getNome(),
                                usuarioLogado.getSenha());
                        this.listarDisciplinas();
                        System.out.println("\nDigite a o código da matéroa escolhida: ");

                        var materia = teclado.nextInt();
                        Disciplina disciplinaSelecionada = null;

                        for (int i = 0; i < this.disciplinas.size(); i++) {
                            var disciplina = this.disciplinas.get(i);
                            if (disciplina.getId() == materia) {
                                disciplinaSelecionada = disciplina;
                            }
                        }

                        if (disciplinaSelecionada.getTipo() == ClassificacaoDisciplinaEnum.OBRIGATORIA) {
                            aluno.cadastrarDisciplinasObrigatorias(disciplinaSelecionada);
                        } else {
                            aluno.cadastrarDisciplinasOpcionais(disciplinaSelecionada);
                        }

                        break;
                }

            } while (opcao != 0);
        }

    }
}
