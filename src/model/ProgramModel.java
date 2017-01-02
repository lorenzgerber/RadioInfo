package model;

import java.time.LocalDateTime;

/**
 * Created by loge on 2016-12-23.
 */
public class ProgramModel {

    private int episodeId;
    private int programId;
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String imageUrl;


    public ProgramModel(int programId, String name){
        this.programId = programId;
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime){
        this.endTime = endTime;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getName(){
        return this.name;
    }

    public LocalDateTime getStartTime(){
        return this.startTime;
    }

    public LocalDateTime getEndTime(){
        return this.endTime;
    }





}
