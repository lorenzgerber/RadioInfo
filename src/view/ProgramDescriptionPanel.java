/*
 * ProgramDescriptionPanel
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


import javax.swing.*;

/**
 * ProgramDescriptionPanel Class
 * This class extends JPanel and constructs
 * the UI panel which contains the program
 * description text in a JTextArea
 */
public class ProgramDescriptionPanel extends JPanel {

    JTextArea textArea;
    String infoText;

    /**
     * ProgramDescriptionPanel
     * Constructor method
     */
    public ProgramDescriptionPanel() {

        textArea = new JTextArea(10,30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        add(textArea);
    }

    /**
     * setDescription
     * method to set the program description.
     * The text area is emptied before a new
     * text is set.
     * @param infoText
     */
    public void setDescription(String infoText){
        this.infoText = infoText;
        this.textArea.setText(null);
        if (this.infoText.length() == 0){
            this.infoText = "No Description available";
        }
        this.textArea.append(this.infoText);
    }

}
