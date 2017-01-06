/*
 * IObserver
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
 * IObserver interface
 * This interface is used for the
 * Observer-observable pattern.
 */
public interface IObserver {

    /**
     * update
     * method to initiate update on the
     * observer.
     */
    public void update();

}
