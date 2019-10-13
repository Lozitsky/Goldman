package com.kirilo.game.abstracts;

import com.kirilo.game.interfaces.creators.Creator;
import com.kirilo.game.objects.creators.FindFiles;
import com.kirilo.game.interfaces.Singleton;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractObjectCreator<T> implements Creator {

    private static Singleton<Object> INSTANCE = new Singleton<Object>() {
        @Override
        public Object getSingleton(String clazz) {
            String resource = "";
            try {
                List<String> filesByURI = new FindFiles().findListOfFilesByURI(resource);
                for (String s : filesByURI) {
                    System.out.println(s);
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            Logger logger = Logger.getLogger(this.getClass().getName());
            try {
                logger.log(Level.INFO, clazz);
                return getClass().getClassLoader().loadClass(clazz).newInstance();
            } catch (IllegalAccessException e) {
                logger.log(Level.SEVERE, this.getClass().getName(), e);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    @SuppressWarnings("unchecked")
    private static <T> Singleton<T> getInstance() {
        return (Singleton<T>) INSTANCE;
    }

    public T getSingleton() {
        Singleton<T> instance = getInstance();
        return instance.getSingleton(getClass().getName());
    }
}
