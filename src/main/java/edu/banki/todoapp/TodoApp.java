package edu.banki.todoapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TodoApp extends Application {



    @Override
    public void start(Stage stage) {
        stage.setTitle("Todo List");

        ToDoController todoController = new ToDoController();
        BorderPane root = todoController.createLayout();

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();

        //inputField.requestFocus();
    }

    

    public static void main(String[] args) {
        Application.launch(args);
    }

}

