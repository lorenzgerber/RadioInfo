package view;

import controller.MainController;
import controller.ProgramSelectionListener;
import model.ProgramListModel;
import model.ProgramTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


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
        //model.addListSelectionListener(new ProgramSelectionListener(table));

        for(int i = 0; i < 3; i++){
            table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
        }



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
