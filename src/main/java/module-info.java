module edu.banki.todoapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.banki.todoapp to javafx.fxml;
    exports edu.banki.todoapp;
}