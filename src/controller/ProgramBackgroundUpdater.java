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

import data_io.XmlScheduleParser;
import model.ChannelModel;
import model.ProgramListModel;
import view.TablePanel;

import javax.swing.*;
import java.time.LocalDate;

/**
 * ProgramBackgroundUpdater Class
 * This class extends SwingWorker class and is used
 * to update the ProgramListModel. A reference to the
 * ProgramListModel is expected to be stored in the main
 * controller.
 */
public class ProgramBackgroundUpdater extends SwingWorker<ProgramListModel, Object> {

    TablePanel tablePanel;
    ChannelModel channel;
    ProgramListModel programs;
    MainController main;


    /**
     * ProgramBackgroundUpdater
     * Constructor method that assigns all arguments.
     * @param channel
     * @param programs
     * @param tablePanel
     * @param main
     */
    public ProgramBackgroundUpdater(ChannelModel channel, ProgramListModel programs, TablePanel tablePanel, MainController main){
        this.tablePanel = tablePanel;
        this.channel = channel;
        this.programs = programs;
        this.main = main;

    }

    /**
     * {@inheritDoc}
     * The doInBackground method contains the work
     * to be done in a separate thread. This includes
     * here to obtain the programs for the current data
     * using an XML parser and some data prep.
     * @return ProgramListModel
     */
    @Override
    public ProgramListModel doInBackground() {

        XmlScheduleParser parser = new XmlScheduleParser(channel.getId(), LocalDate.now());
        programs.load(parser.iterator());
        programs.prune12Hours();
        programs.sortTime();
        return programs;
    }

    /**
     * {@inheritDoc}
     * Method executed after the background job is finshed.
     * Here a TableDataChanged event is fired
     */
    @Override
    protected void done() {
        try {
            main.getGui().tablePanel.tableModel.fireTableDataChanged();
        } catch (Exception ignore) {
        }

    }


}
