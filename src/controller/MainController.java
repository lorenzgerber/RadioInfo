package controller;

import model.ChannelListModel;
import model.ChannelModel;
import view.*;
import javax.swing.JMenuItem;


/**
 * Created by loge on 2016-12-22.
 */
public class MainController {

    // Data
    ChannelListModel channels;

    // current Channel
    ChannelModel currentChannel;

    // Gui
    Gui gui;

    // Listeners
    FileMenuListener fileMenuListener = new FileMenuListener();

    public MainController(Gui gui, ChannelListModel channels){

        this.gui = gui;
        this.channels = channels;
        this.currentChannel = channels.get(0);

        // add listeners in file menu
        for(JMenuItem item : gui.menuBar.fileMenu.menuItems){
            item.addActionListener(fileMenuListener);
        }

        // add listeners in Channel menu
        for (int channel_no = 0; channel_no < channels.size(); channel_no++){
            ChannelMenuListener tempListener;
            tempListener = new ChannelMenuListener(channels.get(channel_no).getName());
            gui.menuBar.channelMenu.menuItems.get(channel_no).addActionListener(tempListener);
        }

        gui.show();
    }

}
