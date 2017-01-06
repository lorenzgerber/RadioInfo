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
 * Created by lgerber on 2017-01-01.
 */
public interface IObserver {

    //method to update the observer, used by subject
    public void update();

}
