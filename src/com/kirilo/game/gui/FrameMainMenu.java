package com.kirilo.game.gui;

import com.kirilo.game.enums.LocationType;
import com.kirilo.game.gui.maps.JTableGameMap;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrameMainMenu extends JFrame {
    private FrameGame frameGame;
    private BaseFrame frameStatus = new FrameStatus();
    private BaseFrame frameSavedGames = new FrameSavedGames();
    private JTableGameMap gameMap = new JTableGameMap(LocationType.FS, "game.map");

    public FrameMainMenu() throws HeadlessException {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void jbtnNewGameActionPerformed(ActionEvent e) {
        if (frameGame == null) {
            frameGame = new FrameGame();
        }
        frameGame.setGameMap(gameMap);
        frameGame.showFrame(this);
    }

    private void jbtnLoadGameActionPerformed(ActionEvent e) {
        frameSavedGames.showFrame(this);
    }

    private void jbtnStatisticsActionPerformed(ActionEvent e) {
        frameStatus.showFrame(this);
    }

    private void jbtnExitActionPerformed(ActionEvent e) {
        quit();
    }

    private void quit() {
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        jpanelMainMenu = new JPanel();
        jbtnExit = new JButton();
        jbtnStatistics = new JButton();
        jbtnLoadGame = new JButton();
        jbtnNewGame = new JButton();

        //======== this ========
        setTitle("Game");
        Container contentPane = getContentPane();

        //======== jpanelMainMenu ========
        {
            jpanelMainMenu.setBorder(BorderFactory.createEmptyBorder());
            jpanelMainMenu.setPreferredSize(new Dimension(230, 246));
            jpanelMainMenu.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
                    border.EmptyBorder(0, 0, 0, 0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax.swing.border.TitledBorder.CENTER
                    , javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialo\u0067", java.awt.Font
                    .BOLD, 12), java.awt.Color.red), jpanelMainMenu.getBorder()));
            jpanelMainMenu.addPropertyChangeListener(
                    new java.beans.PropertyChangeListener() {
                        @Override
                        public void propertyChange(java.beans.PropertyChangeEvent e) {
                            if ("borde\u0072"
                                    .equals(e.getPropertyName())) throw new RuntimeException();
                        }
                    });

            //---- jbtnExit ----
            jbtnExit.setText("Exit");
            jbtnExit.setIcon(new ImageIcon(getClass().getResource("/com/kirilo/game/images/exit.png")));
            jbtnExit.setHorizontalAlignment(SwingConstants.LEFT);
            jbtnExit.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            jbtnExit.setPreferredSize(new Dimension(198, 34));
            jbtnExit.setMinimumSize(new Dimension(198, 34));
            jbtnExit.setMaximumSize(new Dimension(198, 34));
            jbtnExit.setBorder(new LineBorder(Color.black, 1, true));
            jbtnExit.setIconTextGap(10);
            jbtnExit.addActionListener(e -> jbtnExitActionPerformed(e));

            //---- jbtnStatistics ----
            jbtnStatistics.setText("Statistics");
            jbtnStatistics.setIcon(new ImageIcon(getClass().getResource("/com/kirilo/game/images/stat.png")));
            jbtnStatistics.setHorizontalAlignment(SwingConstants.LEFT);
            jbtnStatistics.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            jbtnStatistics.setBorder(new LineBorder(Color.black, 1, true));
            jbtnStatistics.setMinimumSize(new Dimension(198, 34));
            jbtnStatistics.setMaximumSize(new Dimension(198, 34));
            jbtnStatistics.setIconTextGap(10);
            jbtnStatistics.setPreferredSize(new Dimension(198, 34));
            jbtnStatistics.addActionListener(e -> jbtnStatisticsActionPerformed(e));

            //---- jbtnLoadGame ----
            jbtnLoadGame.setText("Download game");
            jbtnLoadGame.setIcon(new ImageIcon(getClass().getResource("/com/kirilo/game/images/load.png")));
            jbtnLoadGame.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            jbtnLoadGame.setHorizontalAlignment(SwingConstants.LEFT);
            jbtnLoadGame.setBorder(new LineBorder(Color.black, 1, true));
            jbtnLoadGame.setIconTextGap(10);
            jbtnLoadGame.setMaximumSize(new Dimension(198, 34));
            jbtnLoadGame.setMinimumSize(new Dimension(198, 34));
            jbtnLoadGame.setPreferredSize(new Dimension(198, 34));
            jbtnLoadGame.addActionListener(e -> jbtnLoadGameActionPerformed(e));

            //---- jbtnNewGame ----
            jbtnNewGame.setText("New game");
            jbtnNewGame.setIcon(new ImageIcon(getClass().getResource("/com/kirilo/game/images/new.png")));
            jbtnNewGame.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            jbtnNewGame.setBorder(LineBorder.createBlackLineBorder());
            jbtnNewGame.setPreferredSize(new Dimension(198, 34));
            jbtnNewGame.setMaximumSize(new Dimension(198, 34));
            jbtnNewGame.setMinimumSize(new Dimension(198, 34));
            jbtnNewGame.setIconTextGap(10);
            jbtnNewGame.setHorizontalAlignment(SwingConstants.LEFT);
            jbtnNewGame.addActionListener(e -> jbtnNewGameActionPerformed(e));

            GroupLayout jpanelMainMenuLayout = new GroupLayout(jpanelMainMenu);
            jpanelMainMenu.setLayout(jpanelMainMenuLayout);
            jpanelMainMenuLayout.setHorizontalGroup(
                    jpanelMainMenuLayout.createParallelGroup()
                            .addGroup(jpanelMainMenuLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jpanelMainMenuLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jbtnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtnLoadGame, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtnNewGame, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtnStatistics, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap(19, Short.MAX_VALUE))
            );
            jpanelMainMenuLayout.setVerticalGroup(
                    jpanelMainMenuLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, jpanelMainMenuLayout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtnNewGame, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtnLoadGame, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtnStatistics, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtnExit, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jpanelMainMenu, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jpanelMainMenu, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel jpanelMainMenu;
    private JButton jbtnExit;
    private JButton jbtnStatistics;
    private JButton jbtnLoadGame;
    private JButton jbtnNewGame;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
