package view;

import model.ChannelListModel;
import model.ProgramListModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by loge on 2016-12-21.
 */
public class Gui {
    public JFrame frame;
    public MenuBar menuBar;
    public TablePanel tablePanel;
    public ProgramDescriptionPanel programDescriptionPanel;
    public ProgramLabelPanel programLabelPanel;
    //public InfoPanel infoPanel;


    public Gui(String title, ChannelListModel channels, ProgramListModel programs){

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(0,3));

        frame = new JFrame(title);
        tablePanel = new TablePanel(programs);
        programDescriptionPanel = new ProgramDescriptionPanel();
        programLabelPanel = new ProgramLabelPanel();

        //infoPanel = new InfoPanel();

        container.add(tablePanel);
        container.add(programDescriptionPanel);
        container.add(programLabelPanel);
        //container.add(infoPanel);


        //frame = new SplitPane(title, tablePanel, infoPanel);
        frame.add(container);
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
