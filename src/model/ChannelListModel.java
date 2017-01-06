/*
 * ChannelListModel
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

import java.util.ArrayList;
import java.util.Iterator;


/**
 * ChannelListModel Class
 * This class provides the Data container for the
 * ChannelModel objects. It extends the ArrayList and
 * implements the ISubject interface to function
 * as observable.
 */
public class ChannelListModel extends ArrayList<ChannelModel> implements ISubject {

    private ArrayList<IObserver> observers;

    /**
     * ChannelListModel
     * Constructor method
     */
    public ChannelListModel() {
        observers = new ArrayList<>();
    }

    /**
     * loadList
     * Method to fill the ChannelListModel
     * with ChannelModels obtained by an iterator
     * from the XmlChannelParser
     * @param iterator
     */
    public void loadList(Iterator<ChannelModel> iterator){
        this.clear();
        while(iterator.hasNext()){
            add(iterator.next());
        }
        notifyObservers();
    }

    /**
     * register
     * method to register Observers
     * of the current instance
     * @param obj
     */
    @Override
    public void register(IObserver obj) {
        observers.add(obj);
    }

    /**
     * unregister
     * method to unregister Observers
     * from the current instance
     * @param obj
     */
    @Override
    public void unregister(IObserver obj) {
        observers.remove(obj);
    }

    /**
     * notifyObservers
     * notification method that notifies
     * the registered observers.
     */
    @Override
    public void notifyObservers() {

        if(observers != null){
            for(IObserver observer : observers){
                observer.update();
            }
        }
    }

}
