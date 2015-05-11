package Entities;

import java.util.Date;

/**
 * Created by Anton on 5/11/2015.
 */
public class Human extends Entity {
    private String name;
    private String surname;
    private String fatherName;
    private Date birthDate;

    public Human() {
        super();
    }

    public Human(int id) {
        super(id);
    }

    public Human(int id, String name, String surname, String fatherName, Date birthDate) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, String fatherName, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
