/*
 * ChannelMenu
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
import model.ChannelModel;
import model.IObserver;

import javax.swing.*;
import java.util.ArrayList;

/**
 * ChannelMenu Class
 * This UI class extends JMenu and implements the
 * IObserver interface. It is dynamically filled
 * with channels from a ChannelListModel object.
 * It can be updated automatically by registering
 * the instance to a ISubject implementing instance.
 */
public class ChannelMenu extends JMenu implements IObserver {

    public ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();
    public ChannelListModel channels;

    /**
     * ChannelMenu
     * Constructor method
     * @param channels ChannelListModel
     */
    public ChannelMenu(ChannelListModel channels){

        super("Channels");

        this.channels = channels;

        for(ChannelModel channel : channels){
            menuItems.add(new JMenuItem(channel.getName()));
        }

        for (JMenuItem item : menuItems){
            this.add(item);
        }

        channels.register(this);

    }

    /**
     * updateChannels
     * This method re-reads the ChannelListModel
     * object and updates as such it's menu items.
     */
    public void updateChannels(){
        for(ChannelModel channel : channels){
            menuItems.add(new JMenuItem(channel.getName()));
        }

        for (JMenuItem item : menuItems){
            this.add(item);
        }
    }

    /**
     * {@inheritDoc}
     * This method is called from the ISubject
     * implementing instance to provoke the
     * update of the channels.
     */
    @Override
    public void update() {
        updateChannels();
        this.repaint();
    }

}
