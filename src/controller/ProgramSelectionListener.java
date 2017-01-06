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
 * ProgramSelectionListener Class
 * This class implements a ListSelectionListener
 * and is used to access the actual data container when
 * the user selects a row in the gui table refering to
 * a certain program.
 */
public class ProgramSelectionListener implements ListSelectionListener {

    JTable table;
    MainController main;

    /**
     * ProgramSelectionListener
     * Constructor method that takes the gui element JTable and
     * the main controller to get access to the data container,
     * ProgramListContainer.
     * @param table
     * @param main
     */
    public ProgramSelectionListener(JTable table, MainController main){
        this.table = table;
        this.main = main;
    }


    /**
     * {@inheritDoc}
     * on selecting a row in the gui table, the respective data
     * is obtained from the ProgramListContainer and updated in the
     * gui description and image panel.
     * @param e
     */
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
