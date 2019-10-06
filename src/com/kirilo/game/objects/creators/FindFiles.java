package com.kirilo.game.objects.creators;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FindFiles<T> {
    public List<String> findListOfFilesByURI(String name) throws URISyntaxException, MalformedURLException {
        URL resource = this.getClass().getClassLoader().getResource(name);
        List<String> list = new ArrayList<>();
        URI uri = null;
        if (resource != null) {
            uri = resource.toURI();
        }
        findNext(name, uri, list);
        return list;
    }

    private void findNext(String name, URI uri, List<String> list) throws URISyntaxException {
        File root = new File(uri);
        if (root.exists()) {
            for (File file : root.listFiles()) {
                if (file.exists()) {
                    list.add(file.getPath());
                    if (file.isDirectory()) {
                        findNext(name, file.toURI(), list);
                    }
                }
            }
        }
    }
}
