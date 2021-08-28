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
  Matricula matricula;
  List<Aluno> alunos = new LinkedList<>();
  Professor professor;


  public Disciplina(String nome,int id, int num_creditos, ClassificacaoDisciplina tipo,Curso curso , Professor professor) {
    this.nome = nome;
    this.id = id;
    this.num_creditos= num_creditos;
    this.tipo = tipo;
    this.curso =curso;
    this.professor = professor;
  }

  public boolean verificarMinimoAlunos() {
    return (this.alunos.size() >= MIN_ALUNOS_INSCRITOS);
  }
  public boolean verificaEncerrarDisciplina(){

    return (this.alunos.size()==MAX_ALUNOS_INSCRITOS) ;
  }

  public  boolean verificaAptidaoDisciplina(){
    return(verificarMinimoAlunos() && this.alunos.size()<=MAX_ALUNOS_INSCRITOS);
  }




  public void addAlunoDisciplina(Aluno aluno){
     if(!verificaEncerrarDisciplina()){
       alunos.add(aluno);

     }else {
        System.out.println("Aluno não pode ser matriculado ! Disciplina atingiu capacidade máxima");
     }


  }

  public void removeAlunoDisciplina(Aluno aluno){
    alunos.remove(aluno);
  }

  public boolean estadoDisciplina(){
        if(!verificarMinimoAlunos()){
          System.out.println("Disciplina com menos de 3 alunos!");
          this.ativa= false;
        }else{

          if(verificarMinimoAlunos() && verificaEncerrarDisciplina() || verificaAptidaoDisciplina()   ){
            this.ativa = true;
            System.out.println("Disciplina Ativa !");


          }

    }


        return  this.getAtiva();

  }




   public  void alunosMatriculados(){
      System.out.println("Alunos matriculados : ");
         for(Aluno aluno : alunos){
             System.out.println(aluno.getNome());
         }
   }


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
}

