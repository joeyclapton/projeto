package entity;

import java.util.ArrayList;
import java.util.List;

import commons.ClassificacaoDisciplinaEnum;

public class Aluno extends Usuario {
    private static final int MAX_OBRIGATORIAS = 2;
    private static final int MAX_OPCIONAIS = 3;

    protected List<Disciplina> disciplinasObrigatorias = new ArrayList<>();
    protected List<Disciplina> disciplinasOpcionais = new ArrayList<>();
    protected Curso curso;

    public Aluno(int matricula, String nome, String senha, Curso curso) {
        super(matricula, nome, senha);
        this.setCurso(curso);
    }

    // #region Getters and Setters
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }
    // #endregion

    public void cadastrarDisciplinasObrigatorias(Disciplina disciplina) {
        boolean podeCadastrar = vericaLimiteDisciplinaObrigatoria() && verificaLimiteGeralDisciplina();

        if (podeCadastrar && disciplina != null) {
            this.disciplinasObrigatorias.add(disciplina);
        }
    }

    public void cadastrarDisciplinasOpcionais(Disciplina disciplina) {
        boolean podeCadastrar = vericaLimiteDisciplinaOpcional() && verificaLimiteGeralDisciplina();

        if (podeCadastrar && disciplina != null) {
            this.disciplinasOpcionais.add(disciplina);
        }
    }

    public void cancelarDisciplinaObrigatoria(Disciplina disciplinaCancelar) {

        if (disciplinaCancelar != null) {
            for (Disciplina disciplina : disciplinasObrigatorias) {
                if (disciplina == disciplinaCancelar) {
                    disciplinasObrigatorias.remove(disciplina);
                    System.out.println("A disciplina obrigatória: " + disciplina.getNome() + " foi removida.");
                }
            }
        }

    }

    public void cancelarDisciplinaOptativa(Disciplina disciplinaCancelar) {

        if (disciplinaCancelar != null) {
            for (Disciplina disciplina : disciplinasOpcionais) {
                if (disciplina == disciplinaCancelar) {
                    disciplinasOpcionais.remove(disciplina);
                    System.out.println("A disciplina optativa: " + disciplina.getNome() + " foi removida.");
                }
            }
        }

    }

    public boolean verificaLimiteGeralDisciplina() {
        return ((disciplinasObrigatorias.size() + disciplinasOpcionais.size()) <= 4);
    }

    public boolean vericaLimiteDisciplinaObrigatoria() {
        return (disciplinasObrigatorias.size() < MAX_OBRIGATORIAS);
    }

    public boolean vericaLimiteDisciplinaOpcional() {
        return (disciplinasObrigatorias.size() > 0 && disciplinasOpcionais.size() < MAX_OPCIONAIS);
    }

    public void exibirMatriculas() {

        System.out.println("Disciplinas matriculadas :");

        for (Disciplina disciplina : disciplinasObrigatorias) {
            System.out.println(disciplina.getId() + " " + disciplina.getNome() + " "
                    + disciplina.getNum_creditosDisciplina() + " " + disciplina.getTipo());
        }

        for (Disciplina disciplina : disciplinasOpcionais) {
            System.out.println(disciplina.getId() + " " + disciplina.getNome() + " "
                    + disciplina.getNum_creditosDisciplina() + " " + disciplina.getTipo());
        }

    }

}
