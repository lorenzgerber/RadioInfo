package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lgerber on 2017-01-01.
 */
public class InfoPanel extends JPanel {

    public InfoPanel(){
        setLayout( new FlowLayout() );

        add( new JButton( "Button 1" ) );
        add( new JButton( "Button 2" ) );
        add( new JButton( "Button 3" ) );
    }

}
