import java.util.Date;

public class Semestre {
    public Date inicioSemestre;
    public Date fimSemestre;

    public Semestre (Date inicioSemestre, Date fimSemestre){

    }

    public void setInicioSemestre(Date inicioSemestre){
        this.inicioSemestre=inicioSemestre;
    }

    public void setFimSemestre(Date fimSemestre){
        this.fimSemestre=fimSemestre;
    }
    public Date getInicioSemestre(){
        return inicioSemestre;
    }

    public Date getFimSemestre(){
        return fimSemestre;
    }
}
