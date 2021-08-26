public class Matricula  {
     protected int id;
     protected Curso curso;
     protected  String situacao;

     public Matricula(int id) {
          this.id = id;

     }

     public void efetuarMatricula(int matricula) {

     }

     public void cancelarMatricula(int matricula) {

     }



     public void setCurso(Curso curso) {
          this.curso = curso;
     }

     public Curso getCurso() {
          return curso;
     }

}
