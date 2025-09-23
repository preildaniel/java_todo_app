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

    private ListView<String> todoListView;
    private ObservableList<String> todoItems;
    private TextField inputField;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Todo List");

        todoItems = FXCollections.observableArrayList();
        todoListView = new ListView<>(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        inputField = new TextField();
        inputField.setPromptText("Írj be egy új teendőt");
        inputField.setOnAction(e -> addTodo());

        Button addButton = new Button("Hozzáadás");
        addButton.setOnAction(e -> addTodo());

        Button deleteButton = new Button("Kijelölt elem törlése");
        deleteButton.setOnAction(e -> deleteSelectedTodos());

        HBox inputRow = new HBox(10);
        inputRow.getChildren().addAll(inputField, addButton);

        VBox bottomPanel = new VBox(5);
        bottomPanel.setPadding(new Insets(10));
        bottomPanel.getChildren().addAll(inputRow, deleteButton);

        BorderPane root = new BorderPane();
        root.setCenter(todoListView);
        root.setBottom(bottomPanel);

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();

        inputField.requestFocus();
    }

    private void addTodo() {
        String todoText = inputField.getText().trim();
        if (!todoText.isEmpty()) {
            todoItems.add(todoText);
            inputField.clear();
            inputField.requestFocus();
        }
    }

    private void deleteSelectedTodos() {
        ObservableList<String> selectedItems = todoListView.getSelectionModel().getSelectedItems();
        if (!selectedItems.isEmpty()) {
            ObservableList<String> itemsToDelete = FXCollections.observableArrayList(selectedItems);
            todoItems.removeAll(itemsToDelete);
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

