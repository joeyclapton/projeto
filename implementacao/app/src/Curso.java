import java.util.*;

public class Curso {
  public String nome;
  public int numCreditos;
  Matricula matricula;
  protected List<Disciplina> disciplinas = new LinkedList<>() ;



  public Curso(String nome, int numCreditos) {
    this.nome = nome;
    this.numCreditos = numCreditos;
  }

  public void removerDisciplina(Disciplina disciplina) {
    disciplinas.remove(disciplina);

    System.out.println("Disciplina removida");
  }

  public boolean verificalimiteCreditoDisciplinaCurso(){
    int somaCreditos = 0;
    for(Disciplina disciplina : disciplinas ){
      somaCreditos+=disciplina.getNum_creditosDisciplina();
    }
    return (somaCreditos<this.numCreditos);
  }

  public void cadastrarDisciplina(Disciplina disciplina) {

    if(verificalimiteCreditoDisciplinaCurso()){
        disciplinas.add(disciplina);
        System.out.println("Disciplina Cadastrada !");

    }else{

        System.out.println("Disciplina não cadastra !"); /* Aqui é necessário criar exeception e não texto */
    }



  }


  public void disciplinasCurso(){
     for(Disciplina disciplina : disciplinas){
       System.out.println(disciplina.getId()+" "+disciplina.getNome()+" "+disciplina.getNum_creditosDisciplina()+" "+disciplina.getTipo());
     }
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

  public void setMatricula(Matricula matricula) {
    this.matricula = matricula;
  }

  public Matricula getMatricula() {
    return matricula;
  }
}
