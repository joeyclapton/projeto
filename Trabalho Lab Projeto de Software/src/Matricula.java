public class Matricula  implements  IDisciplina{
    protected int id;
    protected int num_creditos ;
    protected Curso curso;

    public Matricula(int id, int num_creditos){
         this.id = id;
         this.num_creditos =num_creditos;

    }

    public void cadastrarDisciplina( int id_disciplina){

    }

    public void removerDisciplina(int id_disciplina){

    }

    public void efetuarMatricula(int matricula){


    }

    public void setNum_creditos(int num_creditos){
         this.num_creditos=num_creditos;
    }
    public int getNum_creditos(){
        return num_creditos;
    }

    public void setCurso(Curso curso){
         this.curso = curso;
    }

    public Curso getCurso(){
         return  curso;
    }



}
