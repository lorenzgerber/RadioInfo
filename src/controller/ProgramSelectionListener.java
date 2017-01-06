/*
 * ProgramSelectionListener
 *
 * RadioInfo Project,
 * Coursework 5DV135 Application Development in Java
 * at Umea University, December, January 2016/2017
 *
 * Lorenz Gerber
 *
 * Version 0.1
 *
 * Licensed under GPLv3
 *
 */
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
            String description = null;
            String stringUrl = null;
            int selectedRow = table.getSelectedRow();
            description = main.getPrograms().get(selectedRow).getDescription();
            if (main.getPrograms().get(selectedRow).getImageUrl() == null){
                stringUrl = "";
            } else {
                stringUrl =  main.getPrograms().get(selectedRow).getImageUrl();
            }

            main.getGui().programDescriptionPanel.setDescription(description);
            main.getGui().programLabelPanel.setProgramLabel(stringUrl);
        }
    }
}
