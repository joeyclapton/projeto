import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {

    private static final int MAX_OBRIGATORIAS = 4;
    private static final int MAX_OPCIONAIS = 2;
    protected List<Disciplina> disciplinasObrigatorias = new ArrayList<>();
    protected List<Disciplina> disciplinasOpcionais = new ArrayList<>();
    protected Curso curso;
    protected Disciplina disciplina;
    Matricula matricula;

    public Aluno(String nome, String senha, int matricula) {
        this.setMatricula(matricula);
        this.setNome(nome);
        this.setSenha(senha);
        this.matricula.efetuarMatricula();
    }

    public void cadastrarDisciplinasObrigatorias(Disciplina disciplina) throws Exception {
        try {
            if (vericaLimiteDisciplinaObrigatoria() && this.matricula.getStatusAtual() == "MATRICULADO") {
                this.disciplinasObrigatorias.add(disciplina);
            }
        } catch (Exception e) {
            throw new Exception("Limite de disciplinas alcançado");
        }
    }

    public void cadastrarDisciplinasOpcionais(Disciplina disciplina) throws Exception {
        try {
            if (vericaLimiteDisciplinaObrigatoria() && this.matricula.getStatusAtual() == "MATRICULADO") {
                this.disciplinasOpcionais.add(disciplina);
            }
        } catch (Exception e) {
            throw new Exception("É necessária ter matrícula em uma disciplina obrigatória!");
        }
    }

    public boolean vericaLimiteDisciplinaObrigatoria() {
        return (disciplinasObrigatorias.size() < MAX_OBRIGATORIAS);
    }

    public boolean vericaLimiteDisciplinaOpcional() {
        return (disciplinasObrigatorias.size() > 0 && disciplinasOpcionais.size() < MAX_OPCIONAIS);
    }

    public void emitirHistorico() {

    }

}
