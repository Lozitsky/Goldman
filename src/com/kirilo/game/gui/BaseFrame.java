package com.kirilo.game.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class BaseFrame extends JFrame {
    public BaseFrame() throws HeadlessException {
        setCloseOperation();
    }

    private JFrame parentFrame;

    public JFrame getParentFrame() {
        return parentFrame;
    }

    protected void showFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        parentFrame.setVisible(false);
        setVisible(true);
    }

    protected void closeFrame() {
        if (parentFrame == null) {
            throw new IllegalArgumentException("parent frame must not be null");
        }
        setVisible(false);
        parentFrame.setVisible(true);
    }

    protected void setCloseOperation() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }
        });
    }

}
