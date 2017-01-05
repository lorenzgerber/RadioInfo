package view;

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
    public ProgramTableModel tableModel;

    public TablePanel(ProgramListModel programList){
        String[] columnNames = {"Program", "Start", "End"};

        tableModel = new ProgramTableModel(programList);
        table = new JTable(tableModel);

        table.setRowSelectionAllowed(true);
        ListSelectionModel model = table.getSelectionModel();

        model.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String selectedData = null;

                int[] selectedRow = table.getSelectedRows();
                int[] selectedColumns = table.getSelectedColumns();

                for (int i = 0; i < selectedRow.length; i++) {
                    for (int j = 0; j < selectedColumns.length; j++) {
                        selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
                    }
                }
                System.out.println("Selected: " + selectedData);
            }

        });




        for(int i = 0; i < 3; i++){
            table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
        }



        scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        table.setFillsViewportHeight(true);
        add(scrollPane);

    }



}
