package view;

import model.ProgramListModel;
import model.ProgramTableModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lgerber on 2017-01-01.
 */
public class TablePanel extends JPanel {

    public TablePanel(ProgramListModel programList){
        String[] columnNames = {"Program", "Start", "End"};

        JTable table = new JTable(new ProgramTableModel(programList));

        for(int i = 0; i < 3; i++){
            table.getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setViewportView(table);
        table.setFillsViewportHeight(true);
        add(scrollPane);

    }

}
