package controller;

import model.Registration;
import model.Student;
import util.CrudUtil;

import java.sql.SQLException;

public class RegisterCrudController {
    public boolean saveStudent(Student student) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Student VALUES(?,?,?,?,?,?)",
                student.getStudent_id(),student.getStudent_name(),student.getEmail(),student.getContact(),student.getAddress(),student.getNic());

    }

    public boolean saveRegisterDetails(Registration r) throws SQLException, ClassNotFoundException {

        boolean isDetailsSaved= CrudUtil.execute("INSERT INTO Registration VALUES(?,?,?,?)",
                r.getRegistration_id(),r.getReg_date(),r.getStudent_id(),r.getIntake_id());
        return isDetailsSaved;
    }
}
