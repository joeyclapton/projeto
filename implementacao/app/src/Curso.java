import java.util.*;

public class Curso {
  public String nome;
  public int numCreditos;
  protected List<Disciplina> disciplinas = new LinkedList<>() ;




  public Curso(String nome, int numCreditos) {
    this.nome = nome;
    this.numCreditos = numCreditos;
  }

  public void removerDisciplina(Disciplina disciplina) {
     disciplinas.remove(disciplina);
  }

  public void cadastrarDisciplina(Disciplina disciplina) {

    disciplinas.add(disciplina);
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setNumCreditos(int numCreditos) {
    this.numCreditos = numCreditos;
  }

  public String getNome() {
    return nome;
  }

  public int getNumCreditos() {
    return numCreditos;
  }

  public void setDisciplinas(List<Disciplina> disciplinas) {
    this.disciplinas = disciplinas;
  }

  public List<Disciplina> getDisciplinas() {
    return disciplinas;
  }
}
