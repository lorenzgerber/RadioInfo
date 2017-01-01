package model;

import controller.Observer;
import controller.Subject;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by loge on 2016-12-23.
 */
public class ProgramListModel extends ArrayList<ProgramModel> implements Subject{

    private ArrayList<Observer> observers;

    public ProgramListModel(){
        observers = new ArrayList<>();

    }

    public void load(Iterator<ProgramModel> iterator){

        this.clear();
        while(iterator.hasNext()){
            add(iterator.next());
        }
    }

    public void prune12Hours(){
        removeIf(x -> x.getStartTime().isBefore(LocalDateTime.now().minusHours(12)));
        removeIf(x -> x.getEndTime().isAfter(LocalDateTime.now().plusHours(12)));

    }

    public void sortTime(){
        Collections.sort(this, new Comparator<ProgramModel>(){
            public int compare(ProgramModel o1, ProgramModel o2){
                if(o1.getStartTime().equals(o2.getStartTime()))
                    return 0;
                return o1.getStartTime().isBefore(o2.getStartTime()) ? -1 : 1;
            }
        });
    }


    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        if(observers != null){
            for(Observer observer : observers){
                observer.update();
            }
        }
    }
}
