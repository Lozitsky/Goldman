package com.kirilo.game.gui;

import com.kirilo.game.enums.ActionResult;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.MovingDirection;
import com.kirilo.game.interfaces.maps.DrawableMap;
import com.kirilo.game.objects.Goldman;
import com.kirilo.game.utils.MessageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrameGame extends BaseFrame {

    //    private GameMap gameMap = new FSGameMap();
    private DrawableMap gameMap;

    public FrameGame() throws HeadlessException {
        initComponents();
//        gameMap.loadMap(getClass().getClassLoader().getResource("/game.map"));
    }

    public void setGameMap(DrawableMap gameMap) {
        this.gameMap = gameMap;
        gameMap.drawMap();

        labelTurnsLeft.setText(String.valueOf(gameMap.getGameMap().getTimeLimit()));
        panelMap.removeAll();
        panelMap.add(gameMap.getMap());
    }

    private void moveObject(MovingDirection direction, GameObjectType objectType) {
//        AbstractGameObject gameObject = gameMap.getGameMap().getGameCollection().getGameObjects(objectType).get(0);

/*        if (gameObject instanceof AbstractMovingObject) {
            ((AbstractMovingObject) gameObject).move(direction, this);
            gameMap.drawMap();
        }*/


        ActionResult actionResult = gameMap.getGameMap().move(direction, objectType);

        if (ActionResult.DIE == actionResult) {
            gameOver();
            return;
        }
//        gameMap.getGameMap().getGameCollection().moveObject(direction, objectType);

        gameMap.drawMap();

        if (GameObjectType.GOLDMAN == objectType) {
            Goldman goldman = (Goldman) gameMap.getGameMap().getGameCollection().getGameObjects(objectType).get(0);

            if (goldman.getTurnsNumber() >= gameMap.getGameMap().getTimeLimit()) {
                gameOver();
                return;
            }

            labelScore.setText(String.valueOf(goldman.getTotalScore()));
            labelTurnsLeft.setText(String.valueOf(gameMap.getGameMap().getTimeLimit() - goldman.getTurnsNumber()));
        }
    }

    private void gameOver() {
        MessageManager.showInformMessage(null, "Game Over!");
        closeFrame();
    }

    private void jbtnSaveActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jbtnExitActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jbtnUpActionPerformed(ActionEvent e) {
        moveObject(MovingDirection.UP, GameObjectType.GOLDMAN);
    }

    private void jbtnDownActionPerformed(ActionEvent e) {
        moveObject(MovingDirection.DOWN, GameObjectType.GOLDMAN);
    }

    private void jbtnLeftActionPerformed(ActionEvent e) {
        moveObject(MovingDirection.LEFT, GameObjectType.GOLDMAN);
    }

    private void jbtnRightActionPerformed(ActionEvent e) {
        moveObject(MovingDirection.RIGHT, GameObjectType.GOLDMAN);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        panel1 = new JPanel();
        panelMap = new JPanel();
        panel3 = new JPanel();
        jbtnUp = new JButton();
        jbtnDown = new JButton();
        jbtnLeft = new JButton();
        jbtnRight = new JButton();
        label1 = new JLabel();
        labelScore = new JLabel();
        label3 = new JLabel();
        labelTurnsLeft = new JLabel();
        jbtnSave = new JButton();
        jbtnExit = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(94, 38));
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("File");
                menu1.setMinimumSize(new Dimension(41, 21));
                menu1.setMaximumSize(new Dimension(41, 32767));
                menu1.setPreferredSize(new Dimension(41, 21));

                //---- menuItem1 ----
                menuItem1.setText("Save game");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("Exit game");
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Service");

                //---- menuItem3 ----
                menuItem3.setText("Statistics");
                menu2.add(menuItem3);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setPreferredSize(new Dimension(496, 322));
            panel1.setMinimumSize(new Dimension(496, 322));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
            0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
            .BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt.Color.
            red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
            beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}});

            //======== panelMap ========
            {
                panelMap.setLayout(new BorderLayout());
            }

            //======== panel3 ========
            {
                panel3.setPreferredSize(new Dimension(166, 312));

                //---- jbtnUp ----
                jbtnUp.setIcon(new ImageIcon(getClass().getResource("/com/kirilo/game/images/up.png")));
                jbtnUp.addActionListener(e -> jbtnUpActionPerformed(e));

                //---- jbtnDown ----
                jbtnDown.setIcon(new ImageIcon(getClass().getResource("/com/kirilo/game/images/down.png")));
                jbtnDown.addActionListener(e -> jbtnDownActionPerformed(e));

                //---- jbtnLeft ----
                jbtnLeft.setIcon(new ImageIcon(getClass().getResource("/com/kirilo/game/images/left.png")));
                jbtnLeft.addActionListener(e -> jbtnLeftActionPerformed(e));

                //---- jbtnRight ----
                jbtnRight.setIcon(new ImageIcon(getClass().getResource("/com/kirilo/game/images/right.png")));
                jbtnRight.addActionListener(e -> jbtnRightActionPerformed(e));

                //---- label1 ----
                label1.setText("Number of points:");

                //---- labelScore ----
                labelScore.setText("0");

                //---- label3 ----
                label3.setText("Steps left:");

                //---- labelTurnsLeft ----
                labelTurnsLeft.setText("0");

                //---- jbtnSave ----
                jbtnSave.setText("Save");
                jbtnSave.setPreferredSize(new Dimension(131, 24));
                jbtnSave.setMinimumSize(new Dimension(131, 24));
                jbtnSave.setMaximumSize(new Dimension(131, 24));
                jbtnSave.setIcon(new ImageIcon(getClass().getResource("/com/kirilo/game/images/save.png")));
                jbtnSave.setHorizontalAlignment(SwingConstants.LEFT);
                jbtnSave.setIconTextGap(10);
                jbtnSave.addActionListener(e -> jbtnSaveActionPerformed(e));

                //---- jbtnExit ----
                jbtnExit.setText("Exit from game");
                jbtnExit.setPreferredSize(new Dimension(131, 24));
                jbtnExit.setMinimumSize(new Dimension(131, 24));
                jbtnExit.setMaximumSize(new Dimension(131, 24));
                jbtnExit.setIcon(new ImageIcon(getClass().getResource("/com/kirilo/game/images/exit.png")));
                jbtnExit.setHorizontalAlignment(SwingConstants.LEFT);
                jbtnExit.setIconTextGap(10);
                jbtnExit.addActionListener(e -> jbtnExitActionPerformed(e));

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel3Layout.createParallelGroup()
                                .addComponent(labelScore, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(labelTurnsLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addComponent(jbtnSave, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtnExit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 12, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                            .addContainerGap(14, Short.MAX_VALUE)
                            .addComponent(jbtnLeft, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addComponent(jbtnDown, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtnUp, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                    .addGap(53, 53, 53))
                                .addComponent(jbtnRight, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addComponent(jbtnLeft, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtnRight, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addComponent(jbtnUp, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addGap(51, 51, 51)
                                    .addComponent(jbtnDown, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(labelScore))
                            .addGap(18, 18, 18)
                            .addGroup(panel3Layout.createParallelGroup()
                                .addComponent(labelTurnsLeft)
                                .addComponent(label3))
                            .addGap(18, 18, 18)
                            .addComponent(jbtnSave, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jbtnExit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panelMap, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(panelMap, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(panel3, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JPanel panel1;
    private JPanel panelMap;
    private JPanel panel3;
    private JButton jbtnUp;
    private JButton jbtnDown;
    private JButton jbtnLeft;
    private JButton jbtnRight;
    private JLabel label1;
    private JLabel labelScore;
    private JLabel label3;
    private JLabel labelTurnsLeft;
    private JButton jbtnSave;
    private JButton jbtnExit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
