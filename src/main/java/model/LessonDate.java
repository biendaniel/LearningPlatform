package model;

import javax.persistence.*;
import java.text.DateFormat;

@Entity
public class LessonDate {

    //TODO - Tutaj stworzlem tylko pola - możliwe, że trzeba dodać jeszcze relacje
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private DateFormat date;
    @ManyToOne
    private User teacher;
    @ManyToOne
    private User student;

    public LessonDate(DateFormat date, User teacher, User student) {
        this.date = date;
        this.teacher = teacher;
        this.student = student;
    }

    public LessonDate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DateFormat getDate() {
        return date;
    }

    public void setDate(DateFormat date) {
        this.date = date;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "LessonDate{" +
                "id=" + id +
                ", date=" + date +
                ", teacher=" + teacher +
                ", student=" + student +
                '}';
    }
}
