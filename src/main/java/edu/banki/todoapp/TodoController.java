package edu.banki.todoapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TodoController implements Initializable {
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

    private final ObservableList<String> todoItems = FXCollections.observableArrayList();

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        todoListView.setItems(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        addButton.setOnAction(e-> {
            addTodo();
        });
    }
}