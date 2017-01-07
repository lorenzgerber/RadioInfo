/*
 * FileMenuListener
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
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * FileMenuListener Class
 * This class implements the ActionListener class and is
 * catching events from the FileMenu. Currently, it reacts
 * on "quit" and "reload".
 */
public class FileMenuListener implements ActionListener {

    MainController main;

    /**
     * FileMenuListener
     * Constructor method takes a MainController instance as arguemnt
     * @param main
     */
    public FileMenuListener(MainController main) {
        this.main = main;

    }

    /**
     * {@inheritDoc}
     * This method will start a ProgramBackgroundUpdater. It uses
     * for this a synchronized statement.
     * @param e
     */
    @Override
    public void actionPerformed(final ActionEvent e){
        if(e.getActionCommand().equals("Quit")) {

            /* graceful exit of the background swing worker thread for updates */
            main.getTimedUpdater().cancel(true);
            System.exit(0);
        }

        if(e.getActionCommand().equals("Reload")){
            main.setProgramBackgroundUpdater(new ProgramBackgroundUpdater(main.getCurrentChannel(),
                    main.getPrograms(),
                    main.getGui().tablePanel,
                    main));
            main.getProgramBackgroundUpdater().execute();
        }

    }


}
