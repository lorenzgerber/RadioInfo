package view;

import model.ChannelListModel;
import model.ChannelModel;
import model.IObserver;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by loge on 2016-12-21.
 */
public class ChannelMenu extends JMenu implements IObserver {

    public ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();
    public ChannelListModel channels;

    public ChannelMenu(ChannelListModel channels){

        super("Channels");

        this.channels = channels;

        for(ChannelModel channel : channels){
            menuItems.add(new JMenuItem(channel.getName()));
        }

        for (JMenuItem item : menuItems){
            this.add(item);
        }

        channels.register(this);

    }

    public void updateChannels(){
        for(ChannelModel channel : channels){
            menuItems.add(new JMenuItem(channel.getName()));
        }

        for (JMenuItem item : menuItems){
            this.add(item);
        }

    }

    @Override
    public void update() {
        updateChannels();
        this.repaint();

    }

}
