import controller.MainController;
import data_io.XmlChannelGetter;
import data_io.XmlReader;
import model.ChannelListModel;
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
                XmlReader xmlReader;
                xmlReader = new XmlReader("http://api.sr.se/api/v2/channels/");
                XmlChannelGetter channelGetter = new XmlChannelGetter(xmlReader);
                ChannelListModel channels = new ChannelListModel();
                channels = channelGetter.getChannelList();

                Gui gui = new Gui("Radio Info", channels);
                MainController main = new MainController(gui, channels);
            }
        });

    }

}
