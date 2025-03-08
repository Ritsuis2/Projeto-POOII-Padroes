package classes;

public class AlunoTurma {
    private Aluno aluno;
    private Nota nota;
    private EstadoAlunoTurma estado;

    public AlunoTurma(){}
    
    public AlunoTurma(Aluno aluno){
        this.aluno = aluno;
        this.nota = new Nota();
        this.estado = new EstadoAtivo();

    }
    
     public void setEstado(EstadoAlunoTurma estado) {
        this.estado = estado;
    }

    public Nota getNota(){
        return nota;
    }

    public void setNota(Nota nota){
        this.nota = nota;
    }

    public Aluno getAluno(){
        return aluno;
    }

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }
}
