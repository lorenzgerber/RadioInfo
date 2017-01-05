package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lgerber on 2017-01-01.
 */
public class InfoPanel extends JPanel {

    JTextArea textArea;

    public InfoPanel(){
        this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS ));
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        add(textArea);

    }

    public void setDescription(String description){
        this.textArea.setText(null);
        this.textArea.append(description);
    }

}
