package entity;

import entity.Aluno;;

public class Secretaria extends Usuario {
    Curso curso;
    Aluno aluno;
    Disciplina disciplina;
    Professor professor;

    public Secretaria(int matricula, String nome, String senha) {
        super(matricula, nome, senha);
    }

    public void manterInformacoesAluno(Aluno aluno) {
        System.out.println("Matricula aluno : " + aluno.getMatricula() + "\n Nome : " + aluno.getNome() + "\n Curso:"
                + aluno.curso.getNome());
        aluno.exibirMatriculas();

    }

    public void manterInformacoesProfessor(Professor professor) {

        System.out.println("Nome:" + professor.getNome() + "\n Matrícula :" + professor.getMatricula());
        professor.toString();

    }

    public Aluno adicionarAluno(int matricula, String nome, String senha) {
        var aluno = new Aluno(matricula, nome, senha, null);

        return aluno;
    }

    // public void manterInformacoesDisciplinas(Disciplina disciplina) {

    // System.out.println("Disciplina do curso : " + disciplina.curso.getNome() +
    // "\n Nome : " + disciplina.getNome()
    // + "\n Créditos:" + disciplina.getNum_creditosDisciplina() + "\n Estado
    // Disciplina : "
    // + disciplina.estadoDisciplina() + "\n Professor : " +
    // disciplina.professor.getNome());

    // disciplina.alunosMatriculados();

    // }

}
