import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        Curso curso1 = new Curso("Engenharia de Software",8);
         /* Menu srcretária , cadastra curso ,  cadastra disciplinas em curso , adiciona disciplina ao curso */

        System.out.println(curso1.getNome());
        System.out.println(curso1.getNumCreditos());



        Disciplina desenvolvimentoSoftware = new Disciplina("DS",89);
        Disciplina modular = new Disciplina("Modular",45);
        System.out.println(desenvolvimentoSoftware.getNome());
        System.out.println(desenvolvimentoSoftware.getId());
        System.out.println(modular.getNome());
        System.out.println(modular.getId());

        curso1.cadastrarDisciplina(desenvolvimentoSoftware);
        curso1.cadastrarDisciplina(modular);

       System.out.println(curso1.getDisciplinas());
       curso1.removerDisciplina(modular);
       System.out.println(curso1.getDisciplinas());


















    }
}
