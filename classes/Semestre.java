package classes;

import java.util.ArrayList;

public class Semestre {

    private String nome;
    private boolean ativo;
    private ArrayList<IObserver> observadores;

    public Semestre(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
        this.observadores = new ArrayList<>();
    }

    public static Semestre fromString(String nome, boolean ativo) {
        return new Semestre(nome, ativo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
        notifyObserver();
    }

    public void addObservador(IObserver observer) {
        observadores.add(observer);
    }

    public void removeObservador(IObserver observer) {
        observadores.remove(observer);
    }

    public void notifyObserver() {
        for (int i = 0; i < observadores.size(); i++) {
            observadores.get(i).update(ativo);
        }
    }

}
