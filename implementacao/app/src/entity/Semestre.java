package entity;

import java.util.Date;

public class Semestre {
    public Date inicioSemestre;
    public Date fimSemestre;

    public Semestre(Date inicioSemestre, Date fimSemestre) {
        this.inicioSemestre = inicioSemestre;
        this.fimSemestre = fimSemestre;
    }

    public void setInicioSemestre(Date inicioSemestre) {
        this.inicioSemestre = inicioSemestre;
    }

    public void setFimSemestre(Date fimSemestre) {
        this.fimSemestre = fimSemestre;
    }

    public Date getInicioSemestre() {
        return inicioSemestre;
    }

    public Date getFimSemestre() {
        return fimSemestre;
    }
}