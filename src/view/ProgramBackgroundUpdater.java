package view;

import controller.MainController;
import data_io.XmlScheduleParser;
import model.ChannelModel;
import model.ProgramListModel;

import javax.swing.*;
import java.time.LocalDate;

/**
 * Created by loge on 2017-01-03.
 */
public class ProgramBackgroundUpdater extends SwingWorker<ProgramListModel, Object> {

    TablePanel tablePanel;
    ChannelModel channel;
    ProgramListModel programs;
    MainController main;


    public ProgramBackgroundUpdater(ChannelModel channel, ProgramListModel programs, TablePanel tablePanel, MainController main){
        this.tablePanel = tablePanel;
        this.channel = channel;
        this.programs = programs;
        this.main = main;

    }

    @Override
    public ProgramListModel doInBackground() {


        XmlScheduleParser parser = new XmlScheduleParser(channel.getId(), LocalDate.now());
        programs.load(parser.iterator());
        programs.prune12Hours();
        programs.sortTime();
        return programs;
    }

    @Override
    protected void done() {
        try {
            tablePanel.repaint();
        } catch (Exception ignore) {
        }

    }


}
