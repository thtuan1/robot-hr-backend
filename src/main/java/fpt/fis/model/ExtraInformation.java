package fpt.fis.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExtraInformation {
    @Id
    private int id;
    private String department;
    private String soHDLD;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSoHDLD() {
        return soHDLD;
    }

    public void setSoHDLD(String soHDLD) {
        this.soHDLD = soHDLD;
    }
}
