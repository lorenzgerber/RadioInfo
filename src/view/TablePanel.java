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
        /*
        setLayout( new BorderLayout() );

        // Add some buttons
        add( new JButton( "North" ), BorderLayout.NORTH );
        add( new JButton( "South" ), BorderLayout.SOUTH );
        add( new JButton( "East" ), BorderLayout.EAST );
        add( new JButton( "West" ), BorderLayout.WEST );
        add( new JButton( "Center" ), BorderLayout.CENTER );
        */

        JTable table = new JTable(new ProgramTableModel(programList));

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane);

    }

}
