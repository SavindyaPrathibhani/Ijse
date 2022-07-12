package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchFormController {

    public TextField txtID;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtNic;
    public TextField txtRegID;
    public TextField txtRegDate;
    public TextField txtIntakeId;
    public Button btnSearch;

    public void searchOnAction(ActionEvent actionEvent) {
        search();
    }
    public void search(){
        try {
            ResultSet result =  CrudUtil.execute("SELECT * FROM Student WHERE student_id=?",txtID.getText());
            if (result.next()) {
                txtID.setText(result.getString(1));
                txtName.setText(result.getString(2));
                txtEmail.setText(result.getString(3));
                txtContact.setText(result.getString(4));
                txtAddress.setText(result.getString(5));
                txtNic.setText(result.getString(6));

            } else {
                //   new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }

            ResultSet result2 =  CrudUtil.execute("SELECT * FROM Registration WHERE student_id=?",txtID.getText());
            if (result2.next()) {
                txtRegID.setText(result2.getString(1));
                txtRegDate.setText(result2.getString(2));
                txtIntakeId.setText(result2.getString(4));

            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
                clearTextFields();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
}

    private void clearTextFields() {

    }
    }
