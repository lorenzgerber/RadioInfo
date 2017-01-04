package controller;

import data_io.XmlScheduleParser;
import model.ChannelModel;
import view.ProgramBackgroundUpdater;
import view.TimedProgramUpdater;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Created by loge on 2016-12-22.
 */
public class ChannelMenuListener implements ActionListener {
    MainController mainController;

    public ChannelMenuListener(ChannelModel channel, MainController mainController){
        this.mainController = mainController;

    }

    @Override
    public void actionPerformed(final ActionEvent e){
        int channelIndex;
        for(channelIndex = 0; channelIndex < mainController.channels.size(); channelIndex++ ){
            if(mainController.channels.get(channelIndex).getName().equals(e.getActionCommand())){
                mainController.currentChannel = mainController.channels.get(channelIndex);
            }
        }

        if(e.getActionCommand().equals(mainController.currentChannel.getName())) {
            (new ProgramBackgroundUpdater(mainController.currentChannel,
                    mainController.currentPrograms,
                    mainController.gui.tablePanel,
                    mainController)).execute();

        }
    }

}
