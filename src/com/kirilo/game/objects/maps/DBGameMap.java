package com.kirilo.game.objects.maps;

import com.kirilo.game.abstracts.AbstractGameMap;
import com.kirilo.game.interfaces.collections.GameCollection;

public class DBGameMap extends AbstractGameMap {
    public DBGameMap(GameCollection gameCollection) {
        super(gameCollection);
    }

    @Override
    public boolean loadMap(Object source) {
        throw new UnsupportedOperationException("Not supported yet!");
    }

    @Override
    public boolean saveMap(Object source) {
        throw new UnsupportedOperationException("Not supported yet!");
    }
}
