/*
 * ChannelMenuListener
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
 * ChannelMenuListener Class
 *
 * This class implements the ActionListener Class and is
 * catching events from the channel Menu. On selection of
 * a channel menu entry, it will initiate the update of
 * the ProgramList instance.
 *
 */
public class ChannelMenuListener implements ActionListener {
    MainController main;

    /**
     * ChannelMenuListener
     * Constructor takes a MainController instance as argument.
     * @param main
     */
    public ChannelMenuListener(MainController main){
        this.main = main;

    }

    @Override
    public void actionPerformed(final ActionEvent e){
        int channelIndex;
        for(channelIndex = 0; channelIndex < main.getChannels().size(); channelIndex++ ){
            if(main.getChannels().get(channelIndex).getName().equals(e.getActionCommand())){
                main.setCurrentChannel(main.getChannels().get(channelIndex));
            }
        }

        if(e.getActionCommand().equals(main.getCurrentChannel().getName())) {
            (new ProgramBackgroundUpdater(main.getCurrentChannel(),
                    main.getPrograms(),
                    main.getGui().tablePanel,
                    main)).execute();

        }
    }

}
