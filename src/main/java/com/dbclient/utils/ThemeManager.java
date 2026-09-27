package com.dbclient.utils;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;

import java.net.URL;

public class ThemeManager {

    private enum Theme {
        LIGHT("/css/light/app.css"),
        DARK("/css/dark/app.css");

        private final String resourcePath;

        Theme(String resourcePath) {
            this.resourcePath = resourcePath;
        }

        public String getResourcePath() {
            return resourcePath;
        }
    }

    private static final ObjectProperty<Theme> currentTheme = new SimpleObjectProperty<>(Theme.DARK);

    private static ObjectProperty<Theme> currentThemeProperty() {
        return currentTheme;
    }

    private static Theme getCurrentTheme() {
        return currentTheme.get();
    }

    private static void setTheme(Theme theme) {
        currentTheme.set(theme);
    }

    public static void toggleTheme() {
        setTheme(getCurrentTheme() == Theme.LIGHT ? Theme.DARK : Theme.LIGHT);
    }

    public static void registerScene(Scene scene) {
        if (scene == null) return;
        applyToScene(scene, getCurrentTheme());
        currentTheme.addListener((obs, oldTheme, newTheme) -> applyToScene(scene, newTheme));
    }

    private static void applyToScene(Scene scene, Theme theme) {
        URL cssResource = ThemeManager.class.getResource(theme.getResourcePath());
        if (cssResource == null) {
            throw new IllegalStateException("CSS file missing: " + theme.getResourcePath());
        }
        scene.getStylesheets().clear();
        scene.getStylesheets().add(cssResource.toExternalForm());
    }
}