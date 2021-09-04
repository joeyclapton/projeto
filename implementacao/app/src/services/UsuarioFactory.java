package services;

import entity.Usuario;
import entity.Aluno;
import entity.Professor;
import entity.Secretaria;

public class UsuarioFactory {
    public static Usuario create(int matricula, String nome, String senha, String tipo) {

        Usuario usuario = null;

        if (tipo == "secretaria") {
            usuario = new Secretaria(matricula, nome, senha);
        } else if (tipo == "aluno") {
            usuario = new Aluno(matricula, nome, senha);
        } else {
            usuario = new Professor(matricula, nome, senha);
        }

        return usuario;
    }
}
