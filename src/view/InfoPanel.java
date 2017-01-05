package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lgerber on 2017-01-01.
 */
public class InfoPanel extends JPanel {

    public InfoPanel(){
        this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS ));

        add(new TextArea("bla bla bla"));

    }

}
