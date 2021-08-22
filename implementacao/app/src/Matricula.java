public class Matricula {
     private int id;
     private int num_creditos;
     private Curso curso;

     public Matricula(int id, int num_creditos, Curso curso) {
          this.id = id;
          this.num_creditos = num_creditos;
          this.curso = curso;
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
