package controller;

import data_io.XmlChannelParser;
import data_io.XmlScheduleParser;
import model.ChannelListModel;
import model.ChannelModel;
import model.ProgramListModel;
import model.ProgramModel;
import view.*;

import javax.swing.*;
import java.time.LocalDate;



/**
 * Created by loge on 2016-12-22.
 */
public class MainController {

    private ChannelListModel channels;
    private ChannelModel currentChannel;
    private ProgramListModel programs;
    private ProgramModel currentProgram;
    private FileMenuListener fileMenuListener;
    public TimedProgramUpdater updater;
    private Gui gui;

    public MainController(Gui gui, ChannelListModel channels, ProgramListModel programs){

        this.gui = gui;
        this.channels = channels;
        this.programs = programs;

        // (re)load Channels List
        XmlChannelParser channelGetter = new XmlChannelParser(100);
        this.channels.loadList(channelGetter.iterator());

        // initially set current channel
        this.currentChannel = channels.get(0);
        fileMenuListener = new FileMenuListener(this.currentChannel, this);


        // (re)load Programs List
        XmlScheduleParser parser = new XmlScheduleParser(this.currentChannel.getId(), LocalDate.now());
        this.programs.load(parser.iterator());
        this.programs.prune12Hours();
        this.programs.sortTime();


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

        // add click listener in Table
        ProgramSelectionListener programListener;
        programListener = new ProgramSelectionListener(gui.tablePanel.getTable(), this);
        gui.tablePanel.addSelectionListener(programListener);

        gui.show();

        updater = new TimedProgramUpdater(currentChannel, this.programs, gui.tablePanel, this);
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

    public ProgramListModel getPrograms(){
        return programs;
    }

    public Gui getGui(){
        return gui;
    }

}
