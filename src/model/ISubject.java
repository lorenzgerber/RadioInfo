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
 * ISubject interface
 * This interface is used to implement
 * the observer-observable pattern.
 * It is implemented by the observable.
 */
public interface ISubject {

    /**
     * register
     * Method used to register observers
     * on the observable.
     */
    public void register(IObserver obj);

    /**
     * unregister
     * Method used to unregister obervers
     * from the observable.
     * @param obj
     */
    public void unregister(IObserver obj);

    /**
     * notify
     * method to notify the observers
     */
    public void notifyObservers();

}
