package controller;

import data_io.XmlScheduleParser;
import model.ChannelModel;
import view.ProgramBackgroundUpdater;
import view.TimedProgramUpdater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Created by loge on 2016-12-22.
 */
public class FileMenuListener implements ActionListener {

    MainController mainController;

    public FileMenuListener(ChannelModel channel, MainController mainController) {
        this.mainController = mainController;

    }

    @Override
    public void actionPerformed(final ActionEvent e){
        if(e.getActionCommand().equals("Quit")) {
            mainController.updater.cancel(true);
            System.exit(0);
        }

        if(e.getActionCommand().equals("Reload")){

            (new ProgramBackgroundUpdater(mainController.currentChannel,
                    mainController.currentPrograms,
                    mainController.gui.tablePanel,
                    mainController)).execute();
        }

    }


}
