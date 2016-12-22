package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by loge on 2016-12-22.
 */
public class FileMenuListener implements ActionListener {

    public FileMenuListener() {

    }

    @Override
    public void actionPerformed(final ActionEvent e){
        if(e.getActionCommand().equals("Quit")) {
            System.exit(0);
        }
    }

}
