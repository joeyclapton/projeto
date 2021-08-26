import java.util.LinkedList;
import java.util.List;

public class Disciplina {
  private static final int MIN_ALUNOS_INSCRITOS = 3;
  private static final int MAX_ALUNOS_INSCRITOS = 60;
  public int id;
  public int numeroAlunos;
  public boolean ativa;
  protected Curso curso;
  public String nome;
  public int num_creditos;
  public ClassificacaoDisciplina tipo;


  public Disciplina(String nome,int id, int num_creditos, ClassificacaoDisciplina tipo) {
    this.nome = nome;
    this.id = id;
    this.num_creditos= num_creditos;
    this.tipo = tipo;
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
  public void setNum_creditos(int num_creditos) {
    this.num_creditos = num_creditos;
  }

  public int getNum_creditosDisciplina() {
    return num_creditos;
  }

  public void setTipo(ClassificacaoDisciplina tipo) {
    this.tipo = tipo;
  }

  public ClassificacaoDisciplina getTipo() {
    return tipo;
  }
}

