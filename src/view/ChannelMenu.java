package view;

import model.ChannelListModel;
import model.ChannelModel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by loge on 2016-12-21.
 */
public class ChannelMenu extends JMenu {

    public ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();

    public ChannelMenu(ChannelListModel channels){

        super("Channels");

        for(ChannelModel channel : channels){
            menuItems.add(new JMenuItem(channel.getName()));
        }

        for (JMenuItem item : menuItems){
            this.add(item);
        }

    }

}
