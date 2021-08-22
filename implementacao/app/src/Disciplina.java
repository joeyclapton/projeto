public class Disciplina {
  private static final int MIN_ALUNOS_INSCRITOS = 3;
  private static final int MAX_ALUNOS_INSCRITOS = 60;
  public int id;
  public int numeroAlunos;
  protected Curso curso;

  public Disciplina(int id) {
    this.id = id;
  }

  public boolean verificarAptidao() {

    return (this.getNumero_alunos() >= MIN_ALUNOS_INSCRITOS);
  }

  public void cancelarDisciplina() {
    if (!verificarAptidao()) {
      this.curso.removerDisciplina(this.getId());
    }
  }

  public void encerrarDisciplina() {
    if (verificarAptidao() && this.getNumero_alunos() == MAX_ALUNOS_INSCRITOS) {
      this.curso.cadastrarDisciplina(this.getId());
    }
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

}
