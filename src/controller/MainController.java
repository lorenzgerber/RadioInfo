/*
 * MainController
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
package controller;

import data_io.XmlChannelParser;
import data_io.XmlScheduleParser;
import model.ChannelListModel;
import model.ChannelModel;
import model.ProgramListModel;
import view.*;

import javax.swing.*;
import java.time.LocalDate;



/**
 * MainController Class
 * According to it's name, this class
 * holds together the application, hosting the
 * main data containers such as the channel list
 * and the program list. The MainController is
 * also in charge of setting up auxiliary
 * services such as menu listeners, initial loading
 * of data etc. Last, it starts the timed background
 * updater routine.
 */
public class MainController {

    private ChannelListModel channels;
    private ChannelModel currentChannel;
    private ProgramListModel programs;
    private FileMenuListener fileMenuListener;
    private TimedProgramUpdater timedUpdater;
    private volatile ProgramBackgroundUpdater programBackgroundUpdater;
    private Gui gui;


    /**
     * MainController
     * Constructor method for MainController.
     * @param gui Gui stores a reference to the gui object
     * @param channels ChannelListModel stores a reference to the channel list
     * @param programs ProgramListModel stores a reference to the program list
     */
    public MainController(Gui gui, ChannelListModel channels, ProgramListModel programs){

        this.gui = gui;
        this.channels = channels;
        this.programs = programs;

        /* (re)load Channels List */
        XmlChannelParser channelGetter = new XmlChannelParser(100);
        this.channels.loadList(channelGetter.iterator());

        /* initially set current channel */
        this.currentChannel = channels.get(0);
        fileMenuListener = new FileMenuListener(this);


        /* (re)load Programs List */
        XmlScheduleParser parser = new XmlScheduleParser(this.currentChannel.getId(), LocalDate.now());
        this.programs.load(parser.iterator());
        this.programs.prune12Hours();
        this.programs.sortTime();


        /* add listeners in file menu */
        for(JMenuItem item : gui.menuBar.fileMenu.menuItems){
            item.addActionListener(fileMenuListener);
        }

        /* add listeners in Channel menu */
        for (int channel_no = 0; channel_no < channels.size(); channel_no++){
            ChannelMenuListener tempListener;
            tempListener = new ChannelMenuListener(this);
            gui.menuBar.channelMenu.menuItems.get(channel_no).addActionListener(tempListener);
        }

        /* add click listener in Table */

        ProgramSelectionListener programListener;
        programListener = new ProgramSelectionListener(gui.tablePanel.getTable(), this);
        gui.tablePanel.addSelectionListener(programListener);


        gui.show();

        timedUpdater = new TimedProgramUpdater(this);
        timedUpdater.execute();

    }

    /**
     * getCurrentChannel
     * property accessor
     * @return ChanneModel a reference to the currently selected channel
     */
    public synchronized ChannelModel getCurrentChannel(){
        return currentChannel;
    }

    /**
     * setCurrentChannel
     * property setter
     * @param currentChannel ChannelModel sets the currently selected channel
     */
    public synchronized void setCurrentChannel(ChannelModel currentChannel){
        this.currentChannel = currentChannel;
    }

    /**
     * getChannels
     * property accessor
     * @return ChannelListModel reference to the channel list
     */
    public synchronized ChannelListModel getChannels(){
        return channels;
    }

    /**
     * getPrograms
     * property accessor
     * @return ProgramListModel reference to the program list
     */
    public synchronized ProgramListModel getPrograms(){
        return programs;
    }

    /**
     * getGui
     * property accessor
     * @return Gui reference to the gui instance
     */
    public Gui getGui(){
        return gui;
    }

    /**
     * getProgramBackgroundUpdater
     *
     */
    public synchronized ProgramBackgroundUpdater getProgramBackgroundUpdater(){
        return this.programBackgroundUpdater;
    }

    /**
     * setProgramBackgroundUpdater
     *
     */
    public synchronized void setProgramBackgroundUpdater(ProgramBackgroundUpdater updater){
        this.programBackgroundUpdater = updater;
    }

    /**
     * get
     */
    public synchronized TimedProgramUpdater getTimedUpdater(){
        return this.timedUpdater;
    }

    /**
     * set TimedProgramUpdater
     */
    public synchronized void setTimedUpdater(TimedProgramUpdater updater){
        this.timedUpdater = updater;
    }

}
