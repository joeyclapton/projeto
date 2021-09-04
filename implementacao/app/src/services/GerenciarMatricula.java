package services;

import java.util.ArrayList;

import entity.Matricula;
import entity.Aluno;

public class GerenciarMatricula {
    private ArrayList<Matricula> matriculas;
    private int codigo;

    public GerenciarMatricula() {
        this.init();
    }

    private void init() {
        this.matriculas = new ArrayList<>();
        this.codigo = 0;
    }

    private void gerarCodigo() {
        this.codigo = this.matriculas.size();
    }

    public void cadastrarMatriculas(Matricula matricula) {
        this.matriculas.add(matricula);
        this.gerarCodigo();
    }

    // public buscarMatriculas(Aluno aluno) {}

}
