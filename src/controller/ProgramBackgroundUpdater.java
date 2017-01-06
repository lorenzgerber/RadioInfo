/*
 * ProgramBackgroundUpdater
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

import controller.MainController;
import data_io.XmlScheduleParser;
import model.ChannelModel;
import model.ProgramListModel;
import view.TablePanel;

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
            main.getGui().tablePanel.tableModel.fireTableDataChanged();
        } catch (Exception ignore) {
        }

    }


}
