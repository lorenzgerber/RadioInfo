package view;

import model.ChannelListModel;
import model.ProgramListModel;

import javax.swing.*;

/**
 * Created by loge on 2016-12-21.
 */
public class Gui {
    public JFrame frame;
    //public SplitPane frame;
    public MenuBar menuBar;
    public TablePanel tablePanel;
    public InfoPanel infoPanel;


    public Gui(String title, ChannelListModel channels, ProgramListModel programs){

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

//panel1.set[Preferred/Maximum/Minimum]Size()





        frame = new JFrame(title);
        tablePanel = new TablePanel(programs);
        infoPanel = new InfoPanel();

        container.add(tablePanel);
        container.add(infoPanel);


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
