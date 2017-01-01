package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by loge on 2016-12-23.
 */
public class ProgramListModel extends ArrayList<ProgramModel> {

    public ProgramListModel(){

    }

    public void populateList(Iterator<ProgramModel> iterator){
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


}
