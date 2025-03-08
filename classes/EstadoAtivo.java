package classes;

public class EstadoAtivo implements EstadoAlunoTurma {
    
    public void addNota(AlunoTurma alunoTurma, double valor) {
        alunoTurma.getNota().adicionarNota(valor);
        System.out.println("Nota adicionada normalmente.");
    }
}
