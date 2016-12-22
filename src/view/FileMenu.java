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
