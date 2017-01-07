/*
 * MenuBar
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

import model.ChannelListModel;

import javax.swing.JMenuBar;

/**
 * ManuBar Class
 * This class extends JMenuBar and
 * contains currently two Menus, the File
 * and the Channel menu.
 */
public class MenuBar extends JMenuBar{

    public FileMenu fileMenu;
    public ChannelMenu channelMenu;

    /**
     * MenuBar
     * Constructor
     * @param channels ChannelListModel
     */
    public MenuBar(ChannelListModel channels){

        this.fileMenu = new FileMenu();
        this.channelMenu = new ChannelMenu(channels);

        this.add(fileMenu);
        this.add(channelMenu);
    }


}
