package controller;

import model.ChannelModel;
import view.ProgramBackgroundUpdater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        for(channelIndex = 0; channelIndex < mainController.getChannels().size(); channelIndex++ ){
            if(mainController.getChannels().get(channelIndex).getName().equals(e.getActionCommand())){
                mainController.setCurrentChannel(mainController.getChannels().get(channelIndex));
            }
        }

        if(e.getActionCommand().equals(mainController.getCurrentChannel().getName())) {
            (new ProgramBackgroundUpdater(mainController.getCurrentChannel(),
                    mainController.getPrograms(),
                    mainController.getGui().tablePanel,
                    mainController)).execute();

        }
    }

}
