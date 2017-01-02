package view;

import model.ChannelListModel;
import model.ProgramListModel;

import javax.swing.*;

/**
 * Created by loge on 2016-12-21.
 */
public class Gui {
    //public JFrame frame;
    public SplitPane frame;
    public MenuBar menuBar;
    public TablePanel tablePanel;
    public InfoPanel infoPanel;


    public Gui(String title, ChannelListModel channels, ProgramListModel programs){
         //frame = new JFrame(title);
        tablePanel = new TablePanel(programs);
        infoPanel = new InfoPanel();

        frame = new SplitPane(title, tablePanel, infoPanel);
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
