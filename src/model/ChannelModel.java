/*
 * ChannelModel
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
