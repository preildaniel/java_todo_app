package edu.banki.todoapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TodoController {
    @FXML
    private ListView<String> todoListView;
    @FXML
    private TextField inputField;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private HBox inputRow;
    @FXML
    private VBox bottomPanel;

    private ObservableList<String> todoItems = FXCollections.observableArrayList();

    public VBox createLayout() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/banki/todoapp/todo-view.fxml"));
        bottomPanel = fxmlLoader.load();

        return bottomPanel;
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
}