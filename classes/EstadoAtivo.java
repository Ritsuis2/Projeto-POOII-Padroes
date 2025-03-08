package classes;

public class EstadoAtivo implements EstadoAlunoTurma {
    
    public void setNota(AlunoTurma alunoTurma, double nota) {
        alunoTurma.getNota().adicionarNota(nota);
        System.out.println("Nota adicionada normalmente.");
    }
}
