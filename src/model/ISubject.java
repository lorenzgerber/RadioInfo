package model;

/**
 * Created by lgerber on 2017-01-01.
 */
public interface ISubject {

    //methods to register and unregister observers
    public void register(IObserver obj);

    public void unregister(IObserver obj);

    //method to notify observers of change
    public void notifyObservers();

}
