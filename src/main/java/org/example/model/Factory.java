package org.example.model;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Properties;

public class Factory {
    private final Properties properties;
    int x;
    int y;
    List<Integer> x_figure;
    List<Integer> y_figure;

    public Factory(int x, int y, List<Integer> x_figure, List<Integer> y_figure) {
        properties = new Properties();
        try {
            properties.load(new FileReader("/Users/sasha/IdeaProjects/" +
                    "ThirdLabJava/src/main/resources/shapes.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.x = x;
        this.y = y;
        this.x_figure = x_figure;
        this.y_figure = y_figure;
    }

    public Shape create(String name) throws Exception {
        var fullName = "org.example.model." + properties.getProperty(name);

        Class<?> targetClass;
        try {
            targetClass = Class.forName(fullName);
        } catch (ClassNotFoundException e) {
            throw new Exception("There is no such shape");
        }

        Shape instance;
        try {
            instance = (Shape) targetClass.getDeclaredConstructor(int.class, int.class, List.class, List.class).newInstance(x, y, x_figure, y_figure);
        } catch (InstantiationException | IllegalAccessException
                 | NoSuchMethodException | InvocationTargetException e) {
                throw new RuntimeException(e);
        }
        return instance;
    }
}
