package controller;

import model.ChannelModel;
import view.ProgramBackgroundUpdater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            (new ProgramBackgroundUpdater(mainController.getCurrentChannel(),
                    mainController.getPrograms(),
                    mainController.getGui().tablePanel,
                    mainController)).execute();
        }

    }


}
