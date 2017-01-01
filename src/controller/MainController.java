package controller;

import data_io.XmlChannelParser;
import data_io.XmlReader;
import data_io.XmlScheduleParser;
import model.ChannelListModel;
import model.ChannelModel;
import model.ProgramListModel;
import model.ProgramModel;
import view.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


/**
 * Created by loge on 2016-12-22.
 */
public class MainController {

    // Data
    ChannelListModel channels;

    // current Channel
    ChannelModel currentChannel;

    // current Programs
    ProgramListModel currentPrograms;


    // Gui
    Gui gui;

    // Listeners
    FileMenuListener fileMenuListener = new FileMenuListener();

    public MainController(Gui gui, ChannelListModel channels){

        this.gui = gui;
        this.channels = channels;

        this.currentPrograms = new ProgramListModel();


        // Populate Channels List
        XmlChannelParser channelGetter = new XmlChannelParser(100);
        this.channels.populateList(channelGetter.iterator());


        // todo have to move this in observer pattern
        // update view data
        this.currentChannel = channels.get(0);
        gui.menuBar.channelMenu.updateChannels();


        // Populate Programs List
        XmlScheduleParser parser = new XmlScheduleParser(164, LocalDate.now());
        currentPrograms.populateList(parser.iterator());
        currentPrograms.prune12Hours();
        currentPrograms.sortTime();


        // add listeners in file menu
        for(JMenuItem item : gui.menuBar.fileMenu.menuItems){
            item.addActionListener(fileMenuListener);
        }

        // add listeners in Channel menu
        for (int channel_no = 0; channel_no < channels.size(); channel_no++){
            ChannelMenuListener tempListener;
            tempListener = new ChannelMenuListener(channels.get(channel_no).getName());
            gui.menuBar.channelMenu.menuItems.get(channel_no).addActionListener(tempListener);
        }

        gui.show();

        //todo this is just a test how to update view. will move in observer pattern
        gui.menuBar.repaint();

    }




}
