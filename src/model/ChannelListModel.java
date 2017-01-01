package model;

import controller.Observer;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by loge on 2016-12-22.
 */
public class ChannelListModel extends ArrayList<ChannelModel> implements controller.Subject {

    private ArrayList<Observer> observers;

    //int channelId;
    String BASE_QUERY_URL = "http://api.sr.se/api/v2/scheduledepisodes";

    public ChannelListModel() {
        observers = new ArrayList<>();
    }

    public void loadList(Iterator<ChannelModel> iterator){
        this.clear();
        while(iterator.hasNext()){
            add(iterator.next());
        }
        notifyObservers();
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
