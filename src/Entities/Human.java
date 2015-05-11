package Entities;

import java.util.Date;


public class Human extends Entity {
    private String name;
    private String surname;
    private String fatherName;
    private Date birthDate;
    private int lettersQuantity;

    public Human() {
        super();
    }

    public Human(int id) {
        super(id);
    }

    public Human(int id, String name, String surname, String fatherName, Date birthDate, int lettersQuantity) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.lettersQuantity = lettersQuantity;
    }

    public Human(String name, String surname, String fatherName, Date birthDate, int lettersQuantity) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.lettersQuantity = lettersQuantity;
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

    public int getLettersQuantity() {
        return lettersQuantity;
    }

    public void setLettersQuantity(int lettersQuantity) {
        this.lettersQuantity = lettersQuantity;
    }
}
