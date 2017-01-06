/*
 * TablePanel
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
package view;

import controller.ProgramSelectionListener;
import model.ProgramListModel;
import model.ProgramTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.*;


/**
 * Created by lgerber on 2017-01-01.
 */
public class TablePanel extends JPanel {

    JTable table;
    JScrollPane scrollPane;
    ListSelectionModel model;
    public ProgramTableModel tableModel;

    public TablePanel(ProgramListModel programList){

        String[] columnNames = {"Program", "Start", "End"};

        tableModel = new ProgramTableModel(programList);
        table = new JTable(tableModel);
        this.model = table.getSelectionModel();


        /* set header title */
        for(int i = 0; i < 3; i++){
            table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
        }

        /* Set coloring of the table rows according to time */
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                                                           Object value,
                                                           boolean isSelected,
                                                           boolean hasFocus,
                                                           int row,
                                                           int col) {


                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                LocalDateTime startTime = (LocalDateTime) table.getModel().getValueAt(row, 1);
                if (startTime.isBefore(LocalDateTime.now())) {
                    setBackground(Color.BLACK);
                    setForeground(Color.WHITE);
                } else {
                    setBackground(table.getBackground());
                    setForeground(table.getForeground());
                }

                value = startTime.format(ISO_LOCAL_TIME);

                return this;
            }
        });

        scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        table.setFillsViewportHeight(true);
        add(scrollPane);

    }

    public void addSelectionListener(ProgramSelectionListener listener){
        model.addListSelectionListener(listener);
    }

    public JTable getTable(){
        return table;
    }



}
