package entity;

import java.util.LinkedList;
import java.util.List;

import commons.ClassificacaoDisciplinaEnum;

public class Disciplina {
  private static final int MAX_ALUNOS_INSCRITOS = 60;
  private static final int MIN_ALUNOS_INSCRITOS = 3;

  private int id;
  private int numeroAlunos;
  private boolean ativa;
  private int num_creditos;

  private Curso curso;
  private String nome;
  private ClassificacaoDisciplinaEnum tipo;

  Matricula matricula;
  List<Aluno> alunos = new LinkedList<>();
  Professor professor;

  public Disciplina(int id, String nome, int num_creditos, ClassificacaoDisciplinaEnum tipo, Curso curso,
      Professor professor) {
    this.nome = nome;
    this.num_creditos = num_creditos;
    this.tipo = tipo;
    this.curso = curso;
    this.professor = professor;
    this.id = id;
  }

  // #region Getters and Setters
  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setNumeroAlunos(int numeroAlunos) {
    this.numeroAlunos = numeroAlunos;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public int getNumero_alunos() {
    return numeroAlunos;
  }

  public String getNome() {
    return nome;
  }

  public void setNum_creditos(int num_creditos) {
    this.num_creditos = num_creditos;
  }

  public int getNum_creditosDisciplina() {
    return num_creditos;
  }

  public void setTipo(ClassificacaoDisciplinaEnum tipo) {
    this.tipo = tipo;
  }

  public ClassificacaoDisciplinaEnum getTipo() {
    return tipo;
  }

  public void setMatricula(Matricula matricula) {
    this.matricula = matricula;
  }

  public Matricula getMatricula() {
    return matricula;
  }

  public void setAtiva(boolean ativa) {
    this.ativa = ativa;
  }

  public boolean getAtiva() {
    return ativa;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public Curso getCurso() {
    return curso;
  }

  public List<Aluno> getAlunos() {
    return alunos;
  }
  // #endregion

  public boolean verificarMinimoAlunos() {
    return (this.alunos.size() >= MIN_ALUNOS_INSCRITOS);
  }

  public boolean verificaEncerrarDisciplina() {

    return (this.alunos.size() == MAX_ALUNOS_INSCRITOS);
  }

  public boolean verificaAptidaoDisciplina() {
    return (verificarMinimoAlunos() && this.alunos.size() <= MAX_ALUNOS_INSCRITOS);
  }

  public void addAlunoDisciplina(Aluno aluno) {
    if (aluno != null && !verificaEncerrarDisciplina()) {
      alunos.add(aluno);
    } else {
      System.out.println("Aluno não pode ser matriculado ! Disciplina atingiu capacidade máxima");
    }
  }

  public void removerAlunoDisciplina(Aluno aluno) {
    if (aluno != null) {
      alunos.remove(aluno);
    }
  }

  public boolean estadoDisciplina() {
    boolean disciplinaApta = verificarMinimoAlunos() && verificaEncerrarDisciplina() || verificaAptidaoDisciplina();

    if (!verificarMinimoAlunos()) {
      System.out.println("Disciplina com menos de 3 alunos!");
      this.ativa = false;
    }
    if (disciplinaApta) {
      this.ativa = true;
      System.out.println("Disciplina Ativa !");
    }

    return this.getAtiva();
  }

  @Override
  public String toString() {
    StringBuilder alunosMatriculados = new StringBuilder();

    alunosMatriculados.append("Alunos matriculados: ");

    for (Aluno aluno : alunos) {
      alunosMatriculados.append(aluno.getNome());
    }

    return alunosMatriculados.toString();
  }

}
