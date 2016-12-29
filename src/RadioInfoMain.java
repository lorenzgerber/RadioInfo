import controller.MainController;
import data_io.XmlChannelParser;
import data_io.XmlReader;
import model.ChannelListModel;
import model.ChannelModel;
import view.Gui;

import javax.swing.*;

/**
 * Created by loge on 2016-12-21.
 */
public class RadioInfoMain {




    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                ChannelListModel channels = new ChannelListModel();
                XmlChannelParser channelGetter = new XmlChannelParser(100);
                for(ChannelModel channel : channelGetter){
                    channels.add(channel);
                }

                Gui gui = new Gui("Radio Info", channels);
                MainController main = new MainController(gui, channels);
            }
        });

    }

}
