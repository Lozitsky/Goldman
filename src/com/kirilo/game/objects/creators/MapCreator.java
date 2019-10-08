package com.kirilo.game.objects.creators;

import com.kirilo.game.abstracts.AbstractGameMap;
import com.kirilo.game.abstracts.AbstractObjectCreator;
import com.kirilo.game.enums.LocationType;
import com.kirilo.game.interfaces.collections.GameCollection;
import com.kirilo.game.objects.maps.FSGameMap;

public class MapCreator extends AbstractObjectCreator {
    @Override
    public AbstractGameMap createObject(Enum type, Object... objects) {
        AbstractGameMap map = null;

        switch ((LocationType) type) {
            case FS:
                map = new FSGameMap((GameCollection) objects[0]);
            case DB:
                break;
            default:
                throw new IllegalArgumentException("Can't create map type: " + type);
        }

        return map;
    }

    public AbstractGameMap createObject(Enum type, GameCollection gameCollection) {
        return this.createObject(type, (Object) gameCollection);
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
