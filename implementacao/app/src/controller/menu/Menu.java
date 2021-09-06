package controller.menu;

import java.util.ArrayList;
import java.util.Scanner;

import entity.*;
import utils.*;
import commons.*;
import controller.*;
import services.*;

public class Menu {

    Sistema sistema;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Curso> cursos;
    private Opcoes opcoes;

    public Menu() throws Exception {
        this.init();
    }

    private void init() throws Exception {
        this.sistema = new Sistema();
        this.opcoes = new Opcoes();
        this.disciplinas = this.sistema.getDisciplinas();
        this.usuarios = this.sistema.getUsuarios();
        this.cursos = new ArrayList<>();
        Serializacao.gravarArquivoBinario(this.usuarios, "universidade.bin");

        Usuario usuarioLogado = this.opcoes.menuLogin(this.usuarios);
        menuLogin(usuarioLogado);
    }

    private void divisor() {
        System.out.println("-----------------------------------------");
    }

    private void listarDisciplinas() {
        Teclado.limparTela();

        for (int i = 0; i < this.disciplinas.size(); i++) {
            var disciplina = this.disciplinas.get(i);

            this.divisor();

            System.out.println(disciplina.getId() + "- " + disciplina.getNome() + " - " + disciplina.getTipo());
        }
    }

    private void menuLogin(Usuario usuarioLogado) {
        Teclado.limparTela();
        System.out.println("Usuário logado:");

        Scanner teclado = new Scanner(System.in);
        if (usuarioLogado.getClass().equals(Secretaria.class)) {
            var opcao = 0;
            var secretaria = new Secretaria(usuarioLogado.getMatricula(), usuarioLogado.getNome(),
                    usuarioLogado.getSenha());
            do {
                opcao = opcoes.menuSecretaria(teclado);

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
                opcao = opcoes.menuAluno(teclado);

                var aluno = new Aluno(usuarioLogado.getMatricula(), usuarioLogado.getNome(), usuarioLogado.getSenha());
                switch (opcao) {
                    case 1:
                        this.listarDisciplinas();
                        System.out.println("\nDigite a o código da matéria escolhida: ");

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

                    case 2:
                        aluno.toString();
                        break;
                }

            } while (opcao != 0);
        } else {
            var opcao = 0;

            opcao = opcoes.menuProfessor(teclado);
            switch (opcao) {
                case 1:
                    var professor = new Professor(usuarioLogado.getMatricula(), usuarioLogado.getNome(),
                            usuarioLogado.getSenha());

                    System.out.println(professor.toString());
                    break;
            }
        }

    }
}
