import controller.MainController;
import data_io.XmlChannelParser;
import data_io.XmlReader;
import model.ChannelListModel;
import model.ChannelModel;
import model.ProgramListModel;
import model.ProgramModel;
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
                ProgramListModel programs = new ProgramListModel();

                Gui gui = new Gui("Radio Info", channels, programs);
                MainController main = new MainController(gui, channels, programs);
            }
        });

    }

}
