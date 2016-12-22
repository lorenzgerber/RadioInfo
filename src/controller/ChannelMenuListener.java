package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by loge on 2016-12-22.
 */
public class ChannelMenuListener implements ActionListener {
    String channelName;

    public ChannelMenuListener(String channelName){
        this.channelName = channelName;

    }

    @Override
    public void actionPerformed(final ActionEvent e){
        if(e.getActionCommand().equals(channelName)) {
            System.exit(0);
        }
    }

}
