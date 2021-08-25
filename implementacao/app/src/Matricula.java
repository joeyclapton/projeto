public class Matricula  {
     protected int id;
     protected int num_creditos;
     protected Curso curso;
     protected  String situacao;

     public Matricula(int id, int num_creditos) {
          this.id = id;
          this.num_creditos = num_creditos;

     }

     public void efetuarMatricula(int matricula) {

     }

     public void cancelarMatricula(int matricula) {

     }

     public void setNum_creditos(int num_creditos) {
          this.num_creditos = num_creditos;
     }

     public int getNum_creditos() {
          return num_creditos;
     }

     public void setCurso(Curso curso) {
          this.curso = curso;
     }

     public Curso getCurso() {
          return curso;
     }

}
