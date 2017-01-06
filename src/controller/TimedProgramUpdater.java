/*
 * TimedProgramUpdater
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


import model.ChannelModel;
import model.ProgramListModel;
import view.TablePanel;

import javax.swing.*;


/**
 * TimedProgramUpdater
 *
 * This class extends SwingWorker and is used as timer for
 * hourly automatic update processes. Timing is obtained by
 * thread.sleep. After the waiting time, ProgramBackgroundUpater
 * is called for the actual update. Finally a new TimedProgramUpdater
 * instance is started.
 */
public class TimedProgramUpdater extends SwingWorker<Void, Object>{


        TablePanel tablePanel;
        ChannelModel channel;
        ProgramListModel programs;
        MainController main;

        int BACKGROUND_WAIT_SECONDS = 3600;


    /**
     * TimeProgramUpdater
     * Constructor method that sets up the instance.
     * A new swing worker thread is started by calling
     * the execute method.
     * @param main MainController, gives access to all needed instances
     */
        public TimedProgramUpdater(MainController main){
            this.main = main;

        }


        @Override
        public Void doInBackground() {
            int counter = 0;
            while(!isCancelled()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Background Updater interrupted");
                }
                counter++;
                if(counter == BACKGROUND_WAIT_SECONDS) {
                    break;
                }

            }

            return null;
        }

        @Override
        protected void done() {
            try {
                (new ProgramBackgroundUpdater(main.getCurrentChannel(), programs, tablePanel, main)).execute();
                main.timedUpdater.cancel(true);
                main.timedUpdater = new TimedProgramUpdater(main);
                main.timedUpdater.execute();
            } catch (Exception ignore) {

            }
        }

}