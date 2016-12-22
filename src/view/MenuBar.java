package view;

import data_io.XmlChannelGetter;
import data_io.XmlReader;
import model.ChannelListModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

/**
 * Created by loge on 2016-12-21.
 */
public class MenuBar extends JMenuBar{

    public FileMenu fileMenu;
    public ChannelMenu channelMenu;

    public MenuBar(ChannelListModel channels){

        this.fileMenu = new FileMenu();
        this.channelMenu = new ChannelMenu(channels);

        this.add(fileMenu);
        this.add(channelMenu);
    }


}
