package org.student.site.models;

import jakarta.persistence.*;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int tutorId;

    public Group(int id, int tutorId) {
        this.id = id;
        this.tutorId = tutorId;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }
}
