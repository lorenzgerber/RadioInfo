package controller;

import data_io.XmlScheduleParser;
import model.ChannelModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Created by loge on 2016-12-22.
 */
public class FileMenuListener implements ActionListener {

    ChannelModel channel;
    MainController mainController;

    public FileMenuListener(ChannelModel channel, MainController mainController) {
        this.channel = channel;
        this.mainController = mainController;

    }

    @Override
    public void actionPerformed(final ActionEvent e){
        if(e.getActionCommand().equals("Quit")) {
            System.exit(0);
        }

        if(e.getActionCommand().equals("Reload")){
            mainController.currentPrograms.load(new XmlScheduleParser(channel.getId(), LocalDate.now()).iterator());
        }

    }


}
