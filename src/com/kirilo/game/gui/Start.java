package com.kirilo.game.gui;

import static java.awt.EventQueue.invokeLater;

public class Start {
    public static void main(String[] args) {
        invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameMainMenu().setVisible(true);
            }
        });

/*        FrameMainMenu menu = new FrameMainMenu();
        menu.setVisible(true);*/
    }
}
