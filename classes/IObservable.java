package classes;

public interface IObservable {

    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers(Object arg);
}
