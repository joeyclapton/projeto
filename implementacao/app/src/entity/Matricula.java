package entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Matricula {
     private int matricula;
     Disciplina disciplina;
     public Curso curso;
     // private LocalDateTime dataInicial;
     // private LocalDateTime dataFinal;
     // private LocalDateTime dataAtual;
     // private String statusAtual;
     public Aluno aluno;

     public Matricula(Aluno aluno, Disciplina disciplina) {
          this.matricula = matricula;
          // this.curso = curso;
          // this.dataInicial = dataInicial;
          // this.dataFinal = dataFinal;
          // this.dataAtual = LocalDateTime.now();
          // this.statusAtual = Status.NAO_MATRICULADO.name();
          this.disciplina = disciplina;
          this.aluno = aluno;
          this.curso = curso;
     }

     public void efetuarMatricula() {
          // if (this.dataAtual.isBefore(dataInicial) &&
          // this.dataAtual.isAfter(dataFinal)) {
          // this.statusAtual = Status.MATRICULADO.name();
          this.disciplina.addAlunoDisciplina(this.aluno);
          System.out.println("Aluno cadastrado disciplina !" + this.aluno.getNome());
          // }
          // this.statusAtual = Status.NAO_MATRICULADO.name();
     }

     public void cancelarMatricula() {

          this.disciplina.removeAlunoDisciplina(this.aluno);
          // this.statusAtual = Status.CANCELADA.name();
     }

     public void trancarCurso() {

          // this.statusAtual = Status.TRANCADA.name();
     }

     /*
      * public void setCurso(Curso curso) { this.curso = curso; }
      * 
      * // public void setStatusAtual(String statusAtual) {this.statusAtual =
      * statusAtual; }
      * 
      * public String getStatusAtual() { return this.statusAtual; }
      * 
      * public Curso getCurso() { return curso; }
      * 
      * 
      */

}
