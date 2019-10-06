package com.kirilo.game.gui.maps;

import com.kirilo.game.abstracts.AbstractGameMap;
import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.enums.LocationType;
import com.kirilo.game.interfaces.maps.DrawableMap;
import com.kirilo.game.objects.Coordinate;
import com.kirilo.game.objects.Nothing;
import com.kirilo.game.objects.Wall;
import com.kirilo.game.objects.creators.MapCreator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Arrays;

public class JTableGameMap implements DrawableMap {
    private JTable table = new JTable();
    private AbstractGameMap gameMap;
    private String[] columnNames;
    private AbstractGameObject[][] gameObjects;

    public JTableGameMap(LocationType type, Object source) {
        table.setEnabled(false);
        table.setSize(new Dimension(300, 300));
        table.setRowHeight(26);
        table.setRowSelectionAllowed(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setTableHeader(null);
        table.setUpdateSelectionOnSort(false);
        table.setVerifyInputWhenFocusTarget(false);

        gameMap = new MapCreator().getSingleton().createObject(type);

        this.gameMap.loadMap(source);

        updateObjectsArray();
    }

    private void fillEmptyMap(int width, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                gameObjects[y][x] = new Nothing(new Coordinate(x, y));
            }
        }
    }

    private void updateObjectsArray() {
        gameObjects = new AbstractGameObject[gameMap.getHeight()][gameMap.getWidth()];
        fillEmptyMap(gameMap.getWidth(), gameMap.getHeight());
        gameMap.getAllGameObjects().forEach(gameObject -> {
            if (!gameObject.getType().equals(GameObjectType.NOTHING)) {
                int x = gameObject.getCoordinate().getX();
                int y = gameObject.getCoordinate().getY();
                AbstractGameObject object = gameObjects[y][x];
                if (!(object instanceof Nothing) & !(object instanceof Wall)) {
                    gameObjects[y][x] = gameMap.getPriorityObject(object, gameObject);
                } else {
                    gameObjects[y][x] = gameObject;
                }
            }
        });
    }

    @Override
    public Component getMap() {
        return table;
    }

    @Override
    public boolean drawMap() {
        try {
            columnNames = new String[gameMap.getWidth()];
            Arrays.fill(columnNames, "");
            table.setModel(new DefaultTableModel(gameObjects, columnNames));
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
                TableColumn column = table.getColumnModel().getColumn(i);
                column.setPreferredWidth(26);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
