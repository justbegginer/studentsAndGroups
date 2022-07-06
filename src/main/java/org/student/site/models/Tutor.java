package org.student.site.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tutor")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String qualification;

    public Tutor(int id, String name, String surname, String qualification) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.qualification = qualification;
    }

    public Tutor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
