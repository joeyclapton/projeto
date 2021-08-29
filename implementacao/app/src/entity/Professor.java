package entity;

import java.util.LinkedList;
import java.util.List;

public class Professor extends Usuario {

    List<Disciplina> disciplinasMinistradas = new LinkedList<>();
    Disciplina disciplina;

    public Professor(int matricula, String nome, String senha) {
        super(matricula, nome, senha);
    }

    public void listarAlunosMatriculados(Disciplina disciplina) {
        disciplina.toString();
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinasMinistradas.add(disciplina);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("Disciplinas ministradas:");

        for (Disciplina disciplina : disciplinasMinistradas) {
            str.append(disciplina.getNome());
        }

        return str.toString();
    }

}
