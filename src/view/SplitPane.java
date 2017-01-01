package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lgerber on 2017-01-01.
 */
class SplitPane extends JFrame {

    private     JSplitPane  splitPaneH;
    private     JPanel      leftPanel;
    private     JPanel      rightPanel;


    public SplitPane(String title, JPanel leftPanel, JPanel rightPanel){
        setTitle( title );
        setBackground( Color.gray );
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;

        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        // Create a splitter pane
        splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        topPanel.add( splitPaneH, BorderLayout.CENTER );

        //splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneH.setLeftComponent( this.leftPanel );
        splitPaneH.setRightComponent( this.rightPanel );

    }



}
