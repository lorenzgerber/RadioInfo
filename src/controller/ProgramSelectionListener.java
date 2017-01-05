package controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by loge on 2017-01-05.
 */
public class ProgramSelectionListener implements ListSelectionListener {

    JTable table;
    MainController main;

    public ProgramSelectionListener(JTable table, MainController main){
        this.table = table;
        this.main = main;
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (! e.getValueIsAdjusting() ){
            String selectedData = null;
            int selectedRow = table.getSelectedRow();
            selectedData = main.getPrograms().get(selectedRow).getDescription();
            main.getGui().infoPanel.setDescription(selectedData);
            //main.getPrograms().get(selectedRow).getDescription();

            //System.out.println("Selected: " + selectedData);

        }
    }
}
