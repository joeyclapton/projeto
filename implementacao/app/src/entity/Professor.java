package entity;

import java.util.LinkedList;
import java.util.List;

public class Professor extends Usuario {

    List<Disciplina> disciplinasMinistradas = new LinkedList<>();
    Disciplina disciplina;

    public Professor(String nome, String senha, int matricula) {
        super();
        this.setNome(nome);
        this.setSenha(senha);
        this.setMatricula(matricula);

    }

    public void listarAlunosMatriculados(Disciplina disciplina) {

        disciplina.alunosMatriculados();
    }

    public void addDisciplinaProdessor(Disciplina disciplina) {
        disciplinasMinistradas.add(disciplina);
    }

    public void mostraDisciplinasMinistradas() {
        System.out.println("Disciplinas Ministradas : ");
        for (Disciplina disciplina : disciplinasMinistradas) {
            System.out.println(disciplina.getNome());
        }
    }

}
