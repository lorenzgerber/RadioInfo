package view;


import model.ChannelModel;
import model.ProgramListModel;

import javax.swing.*;


/**
 * Created by loge on 2017-01-03.
 */
public class TimedProgramUpdater extends SwingWorker<Void, Object>{


        TablePanel tablePanel;
        ChannelModel channel;
        ProgramListModel programs;


        public TimedProgramUpdater(ChannelModel channel, ProgramListModel programs, TablePanel tablePanel){
            this.tablePanel = tablePanel;
            this.channel = channel;
            this.programs = programs;

        }

        @Override
        public Void doInBackground() {
            int counter = 0;
            while(!isCancelled()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Background interrupted");
                }
                System.out.println("Background running");
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
                (new ProgramBackgroundUpdater(channel, programs, tablePanel)).execute();
            } catch (Exception ignore) {
            }
        }

}
