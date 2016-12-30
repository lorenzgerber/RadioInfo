package controller;

import data_io.XmlReader;
import data_io.XmlScheduleParser;
import model.ChannelListModel;
import model.ChannelModel;
import model.ProgramListModel;
import model.ProgramModel;
import view.*;
import javax.swing.JMenuItem;
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
        this.currentChannel = channels.get(0);

        ProgramListModel tempPrograms = new ProgramListModel();
        ArrayList<LocalDate> dateRange = this.ThreeDateRange();
        for(LocalDate date : dateRange){
            XmlScheduleParser parser = new XmlScheduleParser(164, date);
            for(ProgramModel program : parser){
                tempPrograms.add(program);
            }
        }

        // Prune ProgramListModel currentPrograms to +/- 12h from now
        currentPrograms = tempPrograms.stream()
                .filter(x -> x.getStartTime().isAfter(LocalDateTime.now().minusHours(12)))
                .filter(x -> x.getEndTime().isBefore(LocalDateTime.now().plusHours(12)))
                .collect(Collectors.toCollection(ProgramListModel::new));

        // Sort ProgamListModel according Program start time
        Collections.sort(currentPrograms, new Comparator<ProgramModel>(){
            public int compare(ProgramModel o1, ProgramModel o2){
                if(o1.getStartTime().equals(o2.getStartTime()))
                    return 0;
                return o1.getStartTime().isBefore(o2.getStartTime()) ? -1 : 1;
            }
        });



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
    }

    public ArrayList<LocalDate> ThreeDateRange(){
        ArrayList<LocalDate> threeDateRange = new ArrayList<>();
        LocalDate dateToday = LocalDate.now();
        LocalDate dateTomorrow = dateToday.plusDays(1);
        LocalDate dateYesterday = dateToday.minusDays(1);
        threeDateRange.add(dateYesterday);
        threeDateRange.add(dateToday);
        threeDateRange.add(dateTomorrow);
        return threeDateRange;
    }


}
