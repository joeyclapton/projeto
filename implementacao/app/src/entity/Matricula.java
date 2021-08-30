package entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Matricula {
     private int matricula;
     Disciplina disciplina;
     public Curso curso;
     public Aluno aluno;

     public Matricula(Aluno aluno, Disciplina disciplina) {
          this.matricula = matricula;
          this.disciplina = disciplina;
          this.aluno = aluno;
          this.curso = curso;
     }

     public void efetuarMatricula() {
          this.disciplina.addAlunoDisciplina(this.aluno);
          System.out.println("Aluno cadastrado disciplina !" + this.aluno.getNome());
     }

     public void cancelarMatricula() {
          this.disciplina.removerAlunoDisciplina(this.aluno);
     }

     public void trancarCurso() {
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
