package edu.banki.todoapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ToDoController {

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
    @FXML
    private BorderPane root;
    private ObservableList<String> todoItems = FXCollections.observableArrayList();

    public BorderPane createLayout() {
        todoListView = new ListView<>(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        inputField = new TextField();
        inputField.setPromptText("Írj be egy új teendőt");
        inputField.setOnAction(e -> addTodo());
        addButton = new Button("Hozzáadás");
        addButton.setOnAction(e -> addTodo());
        deleteButton = new Button("Kijelölt elem törlése");
        deleteButton.setOnAction(e -> deleteSelectedTodos());
        inputRow = new HBox(10);
        inputRow.getChildren().addAll(inputField, addButton);
        bottomPanel = new VBox(5);
        bottomPanel.setPadding(new Insets(10));
        bottomPanel.getChildren().addAll(inputRow, deleteButton);
        root = new BorderPane();
        root.setCenter(todoListView);
        root.setBottom(bottomPanel);
        return root;
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
