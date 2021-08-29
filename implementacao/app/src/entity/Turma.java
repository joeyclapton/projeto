package entity;

public class Turma {

    public int codigo;
    public int capacidade;
    Semestre semestre;

    public Turma(Semestre semestre, int codigo, int capacidade) {
        this.setSemestre(semestre);
        this.setCodigo(codigo);
        this.setCapacidade(capacidade);
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
