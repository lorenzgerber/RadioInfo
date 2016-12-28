package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by loge on 2016-12-22.
 */
public class ChannelListModel extends ArrayList<ChannelModel> {

    //int channelId;
    String BASE_QUERY_URL = "http://api.sr.se/api/v2/scheduledepisodes";

    public ChannelListModel() {
        //this.channelId = channelId;

    }

    public void loadChannelListEntries(){

        ArrayList<LocalDateTime> queryDates = new ArrayList<LocalDateTime>();
        LocalDateTime accessTime = LocalDateTime.now();
        queryDates.add( accessTime);

        if(accessTime.getDayOfMonth()!=accessTime.plusHours(12).getDayOfMonth()){
            queryDates.add(accessTime.plusHours(12));
        }

        if(accessTime.getDayOfMonth()!=accessTime.minusHours(12).getDayOfMonth()){
            queryDates.add(accessTime.minusHours(12));
        }

    }





}
