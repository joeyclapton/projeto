package entity;

public class Secretaria extends Usuario {
    public Secretaria(int matricula, String nome, String senha) {
        super(matricula, nome, senha);
    }

    public Aluno adicionarAluno(int matricula, String nome, String senha) {
        var aluno = new Aluno(matricula, nome, senha);

        return aluno;
    }

    public Professor adicionarProfessor(int matricula, String nome, String senha) {
        var professor = new Professor(matricula, nome, senha);

        return professor;
    }

    public Curso adicionarCurso(int id, String nome, int numCreditos) {
        var curso = new Curso(id, nome, numCreditos);

        return curso;
    }

}
