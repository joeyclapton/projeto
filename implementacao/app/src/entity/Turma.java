package entity;

public class Turma {

    public int codigo;
    public int capacidade;

    public Turma(int codigo, int capacidade) {
        this.setCodigo(codigo);
        this.setCapacidade(capacidade);
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
