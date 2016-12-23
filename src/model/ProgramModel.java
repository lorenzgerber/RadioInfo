package model;

import java.time.LocalDateTime;

/**
 * Created by loge on 2016-12-23.
 */
public class ProgramModel {

    int episodeId;
    int programId;
    String name;
    String description;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String imageUrl;


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




}
