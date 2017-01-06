package controller;


import model.ChannelModel;
import model.ProgramListModel;
import view.TablePanel;

import javax.swing.*;


/**
 * Created by loge on 2017-01-03.
 */
public class TimedProgramUpdater extends SwingWorker<Void, Object>{


        TablePanel tablePanel;
        ChannelModel channel;
        ProgramListModel programs;
        MainController main;


        public TimedProgramUpdater(ChannelModel channel, ProgramListModel programs, TablePanel tablePanel, MainController main){
            this.tablePanel = tablePanel;
            this.channel = channel;
            this.programs = programs;
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
                if(counter == 3600) {
                    break;
                }

            }

            return null;
        }

        @Override
        protected void done() {
            try {
                (new ProgramBackgroundUpdater(main.getCurrentChannel(), programs, tablePanel, main)).execute();
                main.updater.cancel(true);
                main.updater = new TimedProgramUpdater(channel, programs, tablePanel, main);
                main.updater.execute();
            } catch (Exception ignore) {

            }
        }

}
