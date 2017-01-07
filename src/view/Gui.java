/*
 * Gui
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
package view;

import model.ChannelListModel;
import model.ProgramListModel;

import javax.swing.*;
import java.awt.*;

/**
 * Gui Class
 * This is the main UI class that contains
 * the JFrame as the basic container of the
 * whole application UI. The gui uses a simple
 * three panel design with a GridLayout manager.
 */
public class Gui {
    public JFrame frame;
    public MenuBar menuBar;
    public TablePanel tablePanel;
    public ProgramDescriptionPanel programDescriptionPanel;
    public ProgramLabelPanel programLabelPanel;

    /**
     * Gui
     * Constructor method that builds
     * the whole ui.
     * @param title String title shown in the UI window
     * @param channels ChanelListModel from here the channel menu
     *                 is populated
     * @param programs ProgramListModel from here the main program
     *                 table is updated
     */
    public Gui(String title, ChannelListModel channels, ProgramListModel programs){

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(0,3));

        /* construct the parts */
        frame = new JFrame(title);
        tablePanel = new TablePanel(programs);
        programDescriptionPanel = new ProgramDescriptionPanel();
        programLabelPanel = new ProgramLabelPanel();
        menuBar = new MenuBar(channels);

        /* assemble parts */
        container.add(tablePanel);
        container.add(programDescriptionPanel);
        container.add(programLabelPanel);

        frame.add(container);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
    }

    /**
     * show
     * method to visualize the gui after construction
     */
    public void show(){
        frame.setVisible(true);
    }

}
