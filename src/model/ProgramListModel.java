/*
 * ProgramListModel
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

import java.time.LocalDateTime;
import java.util.*;

/**
 * ProgramListModel Class
 * This class provides the container for
 * ProgramModel objects. it contains some helper
 * methods to obtain a 12h +/- collection of
 * ProgramModel objects from the XmlParser.
 * The class implements the ISubject Interface
 */
public class ProgramListModel extends ArrayList<ProgramModel> implements ISubject {

    private ArrayList<IObserver> observers;

    /**
     * ProgramListModel
     * Constructor method initialized the
     * arraylist for the observers
     */
    public ProgramListModel(){
        observers = new ArrayList<>();
    }

    /**
     * load
     * This method is used with an iterator
     * to fill the list with ProgramModel objects
     * @param iterator for ProgramModel objects, usually obtained
     *                 from XmlScheduleParser
     */
    public void load(Iterator<ProgramModel> iterator){
        this.clear();
        while(iterator.hasNext()){
            add(iterator.next());
        }
    }

    /**
     * prune12Hours
     * This method is used to remove ProgramListModel objects that
     * are outside of a +/- 12 hour range from current local time
     */
    public void prune12Hours(){
        removeIf(x -> x.getStartTime().isBefore(LocalDateTime.now().minusHours(12)));
        removeIf(x -> x.getEndTime().isAfter(LocalDateTime.now().plusHours(12)));

    }

    /**
     * sortTime
     * This method sorts the ProrgramModel objects according to
     * their start time.
     */
    public void sortTime(){
        Collections.sort(this, new Comparator<ProgramModel>(){
            public int compare(ProgramModel o1, ProgramModel o2){
                if(o1.getStartTime().equals(o2.getStartTime()))
                    return 0;
                return o1.getStartTime().isBefore(o2.getStartTime()) ? -1 : 1;
            }
        });
    }


    /**
     * {@inheritDoc}
     * This method is used to register an observer on
     * the current ProgramListModel object
     * @param obj
     */
    @Override
    public void register(IObserver obj) {
        observers.add(obj);
    }

    /**
     * {@inheritDoc}
     * This method is used to unregister an observer from
     * the current ProgramListModel object
     * @param obj
     */
    @Override
    public void unregister(IObserver obj) {
        observers.remove(obj);
    }

    /**
     * {@inheritDoc}
     * This method is used to notify the registerd
     * observers. It calls the update method of the
     * each registered observer.
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
