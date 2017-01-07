/*
 * RadioInfoMain
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
import controller.MainController;
import model.ChannelListModel;
import model.ProgramListModel;
import view.Gui;

import javax.swing.*;

/**
 * RadioInfoMain Class
 * This class contains the main class to
 * be run. It starts a new thread with the
 * gui and the MainController instance. The
 * main data containers channels and programs
 * are declerad and assigned.
 *
 */
public class RadioInfoMain {

    /**
     * main
     * method to be invoked for starting
     * the application.
     * @param args
     */
    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                ChannelListModel channels = new ChannelListModel();
                ProgramListModel programs = new ProgramListModel();

                Gui gui = new Gui("Radio Info", channels, programs);
                MainController main = new MainController(gui, channels, programs);
            }
        });
    }
}
