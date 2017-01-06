package view;


import javax.swing.*;

/**
 * Created by loge on 2017-01-06.
 */
public class ProgramDescriptionPanel extends JPanel {

    JTextArea textArea;
    String infoText;

    public ProgramDescriptionPanel() {

        textArea = new JTextArea(10,30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        add(textArea);
    }


    public void setDescription(String infoText){
        this.infoText = infoText;
        this.textArea.setText(null);
        if (this.infoText.length() == 0){
            this.infoText = "No Description available";
        }
        this.textArea.append(this.infoText);
    }


}
