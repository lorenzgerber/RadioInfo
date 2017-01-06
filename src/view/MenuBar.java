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
 * Created by loge on 2016-12-21.
 */
public class MenuBar extends JMenuBar{

    public FileMenu fileMenu;
    public ChannelMenu channelMenu;

    public MenuBar(ChannelListModel channels){

        this.fileMenu = new FileMenu();
        this.channelMenu = new ChannelMenu(channels);

        this.add(fileMenu);
        this.add(channelMenu);
    }


}
