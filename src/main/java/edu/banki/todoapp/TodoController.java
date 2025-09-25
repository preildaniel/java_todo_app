package edu.banki.todoapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Biztos, hogy ki akarod törölni ezeket a todokat:", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(null);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    todoItems.removeAll(itemsToDelete);
                }
            });
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        todoListView.setItems(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        addButton.setOnAction(e-> {
            addTodo();
        });
        deleteButton.setOnAction(e-> {
            deleteSelectedTodos();
        });
    }
}