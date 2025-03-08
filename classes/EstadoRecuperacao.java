package classes;

public class EstadoRecuperacao implements EstadoAlunoTurma {
    public void setNota(AlunoTurma alunoTurma, double nota) {
        alunoTurma.getNota().setNotaRecuperacao(nota);
        System.out.println("Nota adicionada na recuperação.");
    }
}
