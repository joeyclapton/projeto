import java.util.LinkedList;
import java.util.List;

public class Aluno extends Usuario {

    private static final int MAX_OBRIGATORIAS = 4;
    private static final int MAX_OPCIONAIS = 2;
    protected List<Disciplina> disciplinasObrigatorias = new LinkedList<>();
    protected List<Disciplina> disciplinasOpcionais = new LinkedList<>();
    protected Curso curso;
    protected  Disciplina disciplina;
    Matricula matricula;

    public Aluno(String nome, String senha, int matricula) {
        this.setMatricula(matricula);
        this.setNome(nome);
        this.setSenha(senha);
    }

    public void cadastrarDisciplinas() {
        if(vericaLimiteDisciplinaObrigatoria()){


        }

    }

    public boolean vericaLimiteDisciplinaObrigatoria(){
        return (disciplinasObrigatorias.size()<MAX_OBRIGATORIAS);
    }
    public boolean vericaLimiteDisciplinaOpcional(){
        return (disciplinasObrigatorias.size()<MAX_OPCIONAIS);
    }

    public void emitirHistorico(){

    }




}
