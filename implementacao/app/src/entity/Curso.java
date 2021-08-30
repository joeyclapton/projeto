package entity;

import java.util.ArrayList;

public class Curso {
  Matricula matricula;

  private String nome;
  private int numCreditos;
  private int id;
  private ArrayList<Disciplina> disciplinas = new ArrayList<>();

  public Curso(int id, String nome, int numCreditos) {
    this.setNome(nome);
    this.setNumCreditos(numCreditos);
    this.setId(id);
  }

  // #region Getters and Setters
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

  public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
    this.disciplinas = disciplinas;
  }

  public ArrayList<Disciplina> getDisciplinas() {
    return disciplinas;
  }

  public void setMatricula(Matricula matricula) {
    this.matricula = matricula;
  }

  public Matricula getMatricula() {
    return matricula;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }
  // #endregion

  public void cadastrarDisciplina(Disciplina disciplina) {
    if (disciplina != null && verificalimiteCreditoDisciplinaCurso()) {
      disciplinas.add(disciplina);
      System.out.println("Disciplina cadastrada!");
    }
  }

  public void removerDisciplina(Disciplina disciplina) {
    if (disciplina != null) {
      disciplinas.remove(disciplina);
      System.out.println("Disciplina removida!");
    }
  }

  public boolean verificalimiteCreditoDisciplinaCurso() {
    int somaCreditos = 0;

    for (Disciplina disciplina : disciplinas) {
      somaCreditos += disciplina.getNum_creditosDisciplina();
    }

    return (somaCreditos < this.numCreditos);
  }

  @Override
  public String toString() {
    StringBuilder disciplinasStr = new StringBuilder();

    for (Disciplina disciplina : this.disciplinas) {
      disciplinasStr.append(disciplina.getId());
      disciplinasStr.append(disciplina.getNome());
      disciplinasStr.append(disciplina.getNum_creditosDisciplina());
      disciplinasStr.append(disciplina.getTipo());
    }

    return disciplinasStr.toString();
  }
}
