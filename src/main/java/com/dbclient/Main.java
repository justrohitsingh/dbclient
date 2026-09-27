package com.dbclient;

import com.dbclient.utils.ThemeManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        Label label = new Label("welcome");
        root.setCenter(label);

        Scene scene = new Scene(root, 1400, 900);
        ThemeManager.registerScene(scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}