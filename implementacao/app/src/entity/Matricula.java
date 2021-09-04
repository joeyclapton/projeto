package entity;

import java.time.LocalDateTime;

public class Matricula {
     private int id;
     Disciplina disciplina;
     private Curso curso;
     private Aluno aluno;
     private Semestre semestre;

     public Matricula(Aluno aluno, Disciplina disciplina, Curso curso) {
          this.disciplina = disciplina;
          this.aluno = aluno;
          this.curso = curso;

          this.init();
     }

     private void init() {
          var dataInicio = LocalDateTime.of(2014, 9, 10, 6, 40, 45);
          var dataFim = LocalDateTime.of(2022, 9, 10, 6, 40, 45);

          this.semestre = new Semestre(1, dataInicio, dataFim);
     }

     private boolean podeMatricular() {
          return this.semestre.podeMatricular();
     }

     public void efetuarMatricula() {
          if (this.podeMatricular()) {
               this.disciplina.addAlunoDisciplina(this.aluno);
               System.out.println("Aluno cadastrado disciplina !" + this.aluno.getNome());
          } else {
               System.out.println("Fora do período de matrícula!");
          }
     }

     public void cancelarMatricula() {
          if (this.podeMatricular()) {
               this.disciplina.removerAlunoDisciplina(this.aluno);
          } else {
               System.out.println("Fora do período de matrícula!");
          }
     }
}
