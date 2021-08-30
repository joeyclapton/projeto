package entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public static Usuario login(Scanner teclado, ArrayList<Usuario> usuarios) {
        System.out.println("Fazer login");
        System.out.println("--------------------------------");
        System.out.println("Digite sua matrícula: ");
        int matricula = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = teclado.nextLine();

        Usuario usuarioLogado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.fazerLogin(matricula, senha)) {
                usuarioLogado = usuario;
            }
        }

        return usuarioLogado;
    }

}
