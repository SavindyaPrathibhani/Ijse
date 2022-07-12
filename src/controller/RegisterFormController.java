package controller;

import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Registration;
import model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterFormController {
    public TextField txtID;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtNic;
    public TextField txtRegID;
    public TextField txtRegDate;
    public TextField txtIntakeId;
    public Button btnRegister;

    public void registerOnAction(ActionEvent actionEvent) throws SQLException {



        Student student = new Student(
                txtID.getText(),
                txtName.getText(),
                txtEmail.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtNic.getText()

        );

        ArrayList<Registration> reg_details = new ArrayList<>();

        Registration r = new Registration(
               txtRegID.getText(),
                txtRegDate.getText(),
                txtID.getText(),
                txtIntakeId.getText()
        );
        Connection connection= null;

        try {
            connection= DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean isStudentSaved = new RegisterCrudController().saveStudent(student);
            if (isStudentSaved) {
                boolean isRegisterDetailsSaved=new RegisterCrudController().saveRegisterDetails(r);
                if (isRegisterDetailsSaved){
                    connection.commit();
                    new Alert(Alert.AlertType.CONFIRMATION,"Saved!").show();
                }else{
                    connection.rollback();
                    new Alert(Alert.AlertType.ERROR,"Error!").show();
                }
            }else{
                connection.rollback();
                new Alert(Alert.AlertType.ERROR,"Error!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }finally {
            connection.setAutoCommit(true);
        }

        clearAllTextFields();
    }

    private void clearAllTextFields() {
    }
}
