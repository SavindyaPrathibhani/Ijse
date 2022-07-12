package model;

public class Registration {
    private String registration_id;
    private String reg_date;
    private String student_id;
    private String intake_id;

    public Registration(String registration_id, String reg_date, String student_id, String intake_id) {
        this.registration_id = registration_id;
        this.reg_date = reg_date;
        this.student_id = student_id;
        this.intake_id = intake_id;
    }

    public Registration() {
    }

    public String getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(String registration_id) {
        this.registration_id = registration_id;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getIntake_id() {
        return intake_id;
    }

    public void setIntake_id(String intake_id) {
        this.intake_id = intake_id;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registration_id='" + registration_id + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", student_id='" + student_id + '\'' +
                ", intake_id='" + intake_id + '\'' +
                '}';
    }
}
