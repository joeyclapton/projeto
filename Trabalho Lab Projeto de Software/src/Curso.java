import java.util.LinkedList;
import java.util.List;

public class Curso implements IDisciplina {
  public String nome;
  public int numCreditos;
  protected List<Disciplina> disciplinas = new LinkedList<>();

  public Curso(String nome, int numCreditos) {
    this.nome = nome;
    this.numCreditos = numCreditos;
  }

  public void removerDisciplina(int id_disciplina) {
    disciplinas.remove(id_disciplina);
  }

  public void cadastrarDisciplina(int id_disciplina) {
    disciplinas.remove(id_disciplina);
  }
}
