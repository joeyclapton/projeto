package entity;

public class Secretaria extends Usuario {
    Curso curso;
    Aluno aluno;
    Disciplina disciplina;
    Professor professor;

    public Secretaria(int matricula, String nome, String senha) {
        super();
        this.setMatricula(matricula);
        this.setNome(nome);
        this.setSenha(senha);

    }

    public void manterInformacoesAluno(Aluno aluno) {
        System.out.println("Matricula aluno : " + aluno.getMatricula() + "\n Nome : " + aluno.getNome() + "\n Curso:"
                + aluno.curso.getNome());
        aluno.exibirMatriculas();

    }

    public void manterInformacoesProfessor(Professor professor) {

        System.out.println("Nome:" + professor.getNome() + "\n Matrícula :" + professor.getMatricula());
        professor.mostraDisciplinasMinistradas();

    }

    public void manterInformacoesDisciplinas(Disciplina disciplina) {

        System.out.println("Disciplina do curso : " + disciplina.curso.getNome() + "\n Nome : " + disciplina.getNome()
                + "\n Créditos:" + disciplina.getNum_creditosDisciplina() + "\n Estado Disciplina : "
                + disciplina.estadoDisciplina() + "\n Professor : " + disciplina.professor.getNome());

        disciplina.alunosMatriculados();

    }

}
