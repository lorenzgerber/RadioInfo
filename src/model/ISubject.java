/*
 * ISubject
 *
 * RadioInfo Project,
 * Coursework 5DV135 Application Development in Java
 * at Umea University, December, January 2016/2017
 *
 * Lorenz Gerber
 *
 * Version 0.1
 *
 * Licensed under GPLv3
 *
 */
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
