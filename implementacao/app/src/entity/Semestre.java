package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Semestre {

    private LocalDateTime inicio;
    private LocalDateTime fim;
    private int periodo;

    public Semestre() {
    }

    public Semestre(int periodo, LocalDateTime inicio, LocalDateTime fim) {
        this.inicio = inicio;
        this.fim = fim;
        this.periodo = periodo;
    }

    public boolean podeMatricular() {
        LocalDateTime dataAtual = LocalDateTime.now();
        boolean matriculaAberta = false;

        if (dataAtual.isBefore(fim) && dataAtual.isAfter(inicio)) {
            matriculaAberta = true;
        }

        return matriculaAberta;
    }

}
