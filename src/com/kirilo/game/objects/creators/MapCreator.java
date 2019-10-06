package com.kirilo.game.objects.creators;

import com.kirilo.game.abstracts.AbstractGameMap;
import com.kirilo.game.abstracts.AbstractObjectCreator;
import com.kirilo.game.enums.LocationType;
import com.kirilo.game.objects.Coordinate;
import com.kirilo.game.objects.maps.FSGameMap;

public class MapCreator extends AbstractObjectCreator {
    @Override
    public AbstractGameMap createObject(Enum type, Coordinate... coordinates) {
        AbstractGameMap map = null;

        switch ((LocationType) type) {
            case FS:
                map = new FSGameMap();
            case DB:
                break;
            default:
                throw new IllegalArgumentException("Can't create map type: " + type);
        }

        return map;
    }

/*    public MapCreator getSingleton() {
        Singleton<MapCreator> instance = getInstance();
        return instance.getSingleton(getClass().getName());
    }*/

    @Override
    public MapCreator getSingleton() {
        return (MapCreator) super.getSingleton();
    }
}
