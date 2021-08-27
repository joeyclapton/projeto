import java.time.LocalDateTime;
import java.util.Date;

public class Matricula {
     private int id;
     private int num_creditos;
     private Curso curso;
     private LocalDateTime dataInicial;
     private LocalDateTime dataFinal;
     private LocalDateTime dataAtual;
     private String statusAtual;

     public Matricula(int id, int num_creditos, LocalDateTime dataInicial, LocalDateTime dataFinal, Curso curso) {
          this.id = id;
          this.num_creditos = num_creditos;
          this.curso = curso;
          this.dataInicial = dataInicial;
          this.dataFinal = dataFinal;
          this.dataAtual = LocalDateTime.now();
          this.statusAtual = Status.NAO_MATRICULADO.name();
     }

     public void efetuarMatricula() {
          if (this.dataAtual.isBefore(dataInicial) && this.dataAtual.isAfter(dataFinal)) {
               this.statusAtual = Status.MATRICULADO.name();
          }

          this.statusAtual = Status.NAO_MATRICULADO.name();
     }

     public void cancelarMatricula() {
          this.statusAtual = Status.CANCELADA.name();
     }

     public void trancarCurso() {
          this.statusAtual = Status.TRANCADA.name();
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

     public void setStatusAtual(String statusAtual) {
          this.statusAtual = statusAtual;
     }

     public String getStatusAtual() {
          return this.statusAtual;
     }

     public Curso getCurso() {
          return curso;
     }

}
