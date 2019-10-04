package com.kirilo.game.objects.maps;

import com.kirilo.game.abstracts.AbstractGameMap;
import com.kirilo.game.abstracts.AbstractGameObject;
import com.kirilo.game.enums.GameObjectType;
import com.kirilo.game.objects.Coordinate;
import com.kirilo.game.objects.creators.GameObjectCreator;

import java.io.*;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FSGameMap extends AbstractGameMap {

    @Override
    public boolean loadMap(Object source) {
        setExitExist(false);
        setGoldManExist(false);
        File file = Paths.get("resources/game.map").toFile();
        if (!file.exists()) {
            throw new IllegalArgumentException("File must not be empty! " + file.getPath());
        }

        setHeight(getLineCount(file));

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] firstString = reader.readLine().trim().split(",");
            setName(firstString[0]);
            setTimeLimit(Integer.parseInt(firstString[1]));
            setWidth(Integer.parseInt(firstString[2]));
            AtomicInteger y = new AtomicInteger();
            reader.lines().forEach(s -> {
                int x = 0;
                for (String type : s.split(",")) {
                    createGameObject(type, new Coordinate(x, y.get()));
                    x++;
                }
                y.getAndIncrement();
            });
            return true;
        } catch (FileNotFoundException e) {
            Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, "file not found", e);
        } catch (IOException e) {
            Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, e.getClass().getName(), e);
        }
        return false;
    }

    private void createGameObject(String type, Coordinate coordinate) {
        GameObjectType objectType = GameObjectType.valueOf(type.toUpperCase());
        AbstractGameObject gameObject = GameObjectCreator.getInstance().createObject(objectType, coordinate);
        addGameObject(gameObject);

        switch (gameObject.getType()) {
            case EXIT:
                setExitExist(true);
                break;
            case GOLDMAN:
                setGoldManExist(true);
                break;
        }
    }

    @Override
    public boolean saveMap(Object source) {
        return false;
    }

    @Override
    public boolean drawMap() {
        return false;
    }

    private long getLineCount(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().count() - 1;
        } catch (FileNotFoundException e) {
            Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, "file not found", e);
        } catch (IOException e) {
            Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, e.getClass().getName(), e);
        }
        return 0;
    }
}
