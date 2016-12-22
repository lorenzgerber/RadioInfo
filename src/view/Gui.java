package view;

import model.ChannelListModel;

import javax.swing.*;

/**
 * Created by loge on 2016-12-21.
 */
public class Gui {
    public JFrame frame;
    public MenuBar menuBar;


    public Gui(String title, ChannelListModel channels){
         frame = new JFrame(title);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // construct the parts
         menuBar = new MenuBar(channels);

         // assemble parts
         frame.setJMenuBar(menuBar);
         frame.pack();
    }

    public void show(){
        frame.setVisible(true);
    }


}
