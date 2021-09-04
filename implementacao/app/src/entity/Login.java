package entity;

import java.util.ArrayList;

public class Login implements ILogin {

    private ArrayList<Usuario> usuarios;
    private Usuario usuarioLogado;

    public Login(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
        this.usuarioLogado = null;
    }

    // public Usuario login() {
    // System.out.println("Fazer login");
    // System.out.println("--------------------------------");
    // System.out.println("Digite sua matrícula: ");

    // var matricula = this.teclado.nextInt();
    // this.teclado.nextLine();

    // System.out.println("Digite sua senha: ");
    // var senha = this.teclado.nextLine();

    // }

    @Override
    public void fazerLogin(int matricula, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula() == matricula && usuario.getSenha() == senha) {
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
