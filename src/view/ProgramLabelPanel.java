package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by loge on 2017-01-06.
 */
public class ProgramLabelPanel extends JPanel {

    JTextArea textArea;
    JLabel programLabel;
    String infoText;
    String programLabelUrl;

    public ProgramLabelPanel() {

        programLabel = new JLabel();
        add(programLabel);
    }


    public void setProgramLabel(String stringUrl){
        this.programLabelUrl = stringUrl;
        BufferedImage image = null;
        ImageIcon programLabel;

        if (stringUrl.length()== 0){
            programLabel = new ImageIcon();
        } else {
            try {
                URL url = new URL(programLabelUrl);
                image = ImageIO.read(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Image scaledImage = image.getScaledInstance(360, 360, java.awt.Image.SCALE_SMOOTH);
            programLabel = new ImageIcon(scaledImage);

        }


        this.programLabel.setIcon(programLabel);



    }


}
