package entity;

import java.util.ArrayList;

public class Login implements ILogin {

    private ArrayList<Usuario> usuarios;
    private Usuario usuarioLogado;

    public Login(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
        this.usuarioLogado = usuarios.get(0);
    }

    @Override
    public void fazerLogin(int matricula, String senha) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getSenha() == senha) {
                this.usuarioLogado = usuario;
                System.out.println("Usuário logado");
            } else {
                System.out.println("Login ou senha incorretos");
            }
        }
    }

    @Override
    public Usuario getUsuarioLogado() {
        return this.usuarioLogado;
    }

    @Override
    public void trocarSenha(int matricula) {

    }

}
