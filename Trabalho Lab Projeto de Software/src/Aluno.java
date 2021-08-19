import java.util.LinkedList;
import java.util.List;

public abstract class Aluno implements IUsuario {

    private static final int MAX_OBRIGATORIAS = 4;
    private static final int MAX_OPCIONAIS =2;
    protected List<Disciplina> disciplinasObrigatorias = new LinkedList<>();
    protected List<Disciplina> disciplinasOpcionais = new LinkedList<>();

    public Aluno(){

    }

    public void cadastrarDisciplinas(){

    }
}
