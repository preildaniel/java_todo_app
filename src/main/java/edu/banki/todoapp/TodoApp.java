package edu.banki.todoapp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TodoApp extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Todo List");

        TodoController todoController = new TodoController();
        VBox root = todoController.createLayout();

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();

        //inputField.requestFocus();
    }

    

    public static void main(String[] args) {
        Application.launch(args);
    }

}

