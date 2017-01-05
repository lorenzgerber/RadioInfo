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
 * Created by loge on 2016-12-22.
 */
public class MainController {

    private ChannelListModel channels;
    private ChannelModel currentChannel;
    private ProgramListModel currentPrograms;
    private FileMenuListener fileMenuListener;
    public TimedProgramUpdater updater;
    private Gui gui;

    public MainController(Gui gui, ChannelListModel channels, ProgramListModel programs){

        this.gui = gui;
        this.channels = channels;
        this.currentPrograms = programs;



        // (re)load Channels List
        XmlChannelParser channelGetter = new XmlChannelParser(100);
        this.channels.loadList(channelGetter.iterator());

        // initially set current channel
        this.currentChannel = channels.get(0);
        fileMenuListener = new FileMenuListener(this.currentChannel, this);



        // (re)load Programs List
        XmlScheduleParser parser = new XmlScheduleParser(this.currentChannel.getId(), LocalDate.now());
        currentPrograms.load(parser.iterator());
        currentPrograms.prune12Hours();
        currentPrograms.sortTime();


        // add listeners in file menu
        for(JMenuItem item : gui.menuBar.fileMenu.menuItems){
            item.addActionListener(fileMenuListener);
        }

        // add listeners in Channel menu
        for (int channel_no = 0; channel_no < channels.size(); channel_no++){
            ChannelMenuListener tempListener;
            tempListener = new ChannelMenuListener(channels.get(channel_no), this);
            gui.menuBar.channelMenu.menuItems.get(channel_no).addActionListener(tempListener);
        }

        gui.show();

        updater = new TimedProgramUpdater(currentChannel, currentPrograms, gui.tablePanel, this);
        updater.execute();

    }

    public ChannelModel getCurrentChannel(){
        return currentChannel;
    }

    public void setCurrentChannel(ChannelModel currentChannel){
        this.currentChannel = currentChannel;
    }

    public ChannelListModel getChannels(){
        return channels;
    }

    public ProgramListModel getCurrentPrograms(){
        return currentPrograms;
    }

    public Gui getGui(){
        return gui;
    }

}
