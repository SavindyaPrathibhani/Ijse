package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFormController {
    public Button btnRegister;
    public Button btnSearch;
    public Button btnUpdate;
    public Button btnDelete;
    public AnchorPane loader;

    public void registerStudentOnAction(ActionEvent actionEvent) throws IOException {
        loader.getChildren().clear();
        Parent load= FXMLLoader.load(getClass().getResource("/View/RegisterForm.fxml"));
        loader.getChildren().add(load);
    }

    public void searchOnAction(ActionEvent actionEvent) throws IOException {
        loader.getChildren().clear();
        Parent load= FXMLLoader.load(getClass().getResource("/View/SearchForm.fxml"));
        loader.getChildren().add(load);
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }
}
