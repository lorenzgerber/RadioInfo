/*
 * FileMenu
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

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.util.ArrayList;

/**
 * FileMenu
 * Constructing a file menu and adding
 * menu items to it.
 */
public class FileMenu extends JMenu {

    public ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();


    public FileMenu(){
        super("File");
        menuItems.add(new JMenuItem("Reload"));
        menuItems.add(new JMenuItem("Quit"));

        for (JMenuItem item : menuItems){
            this.add(item);
        }

    }


}
