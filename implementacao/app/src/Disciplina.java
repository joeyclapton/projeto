import java.util.LinkedList;
import java.util.List;

public class Disciplina {
  private static final int MIN_ALUNOS_INSCRITOS = 3;
  private static final int MAX_ALUNOS_INSCRITOS = 60;
  public int id;
  public int numeroAlunos;
  public boolean ativa;
  protected Curso curso;
  public int tipo ;
  public String nome;

  public Disciplina(String nome,int id) {
    this.nome = nome;
    this.id = id;
  }

  public boolean verificarAptidao() {

    return (this.getNumero_alunos() >= MIN_ALUNOS_INSCRITOS);
  }

  /*public void cancelarDisciplina() {
    if (!verificarAptidao()) {
      this.curso.removerDisciplina(this.getId());
    }
  }

   */




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
}
