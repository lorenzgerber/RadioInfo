/*
 * ProgramLabelPanel
 *
 * RadioInfo Project,
 * Coursework 5DV135 Application Development in Java
 * at Umea University, December, January 2016/2017
 *
 * Lorenz Gerber
 *
 * Version 0.1
 *
 * Licensed under GPLv3
 *
 */
package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ProgramLablePanel Class
 * This UI class extends JPanel and constructs
 * a panel to visualize an image from the
 * radio program. The image is loaded dynamically
 * from the web.
 */
public class ProgramLabelPanel extends JPanel {

    JLabel programLabel;
    String programLabelUrl;

    /**
     * ProgramLabelPanel
     * Constructor
     */
    public ProgramLabelPanel() {
        programLabel = new JLabel();
        add(programLabel);
    }

    /**
     * setProgramLabel
     * Method to set the image. The image
     * is provided through a string that
     * contains the url to the image.
     * @param stringUrl String
     */
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
                System.out.println("Image could not be loaded: Malformed URL");
            } catch (IOException e) {
                System.out.println("Image could not be loaded: IOException");
            }

            Image scaledImage = image.getScaledInstance(360, 360, java.awt.Image.SCALE_SMOOTH);
            programLabel = new ImageIcon(scaledImage);
        }

        this.programLabel.setIcon(programLabel);
    }
}
