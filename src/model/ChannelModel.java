package model;

/**
 * Created by loge on 2016-12-22.
 */
public class ChannelModel {

    int id;
    String name;
    String scheduleUrl;

    public ChannelModel(int id, String name, String scheduleUrl ){
        this.id = id;
        this.name = name;
        this.scheduleUrl = scheduleUrl;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getScheduleUrl(){
        return scheduleUrl;
    }

}
