package model;

import javax.persistence.*;
import java.text.DateFormat;

@Entity
public class LessonDate {

    //TODO - Tutaj stworzlem tylko pola - możliwe, że trzeba dodać jeszcze relacje
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String day;
    private String hourFrom;
    private String hourTo;
    private Boolean isFree;
    private Boolean isConfirmed;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User user;



    public LessonDate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHourFrom() {
        return hourFrom;
    }

    public void setHourFrom(String hourFrom) {
        this.hourFrom = hourFrom;
    }

    public String getHourTo() {
        return hourTo;
    }

    public void setHourTo(String hourTo) {
        this.hourTo = hourTo;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Boolean getConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        isConfirmed = confirmed;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LessonDate{" +
                "id=" + id +
                ", day='" + day + '\'' +
                ", hourFrom='" + hourFrom + '\'' +
                ", hourTo='" + hourTo + '\'' +
                ", isFree=" + isFree +
                ", isConfirmed=" + isConfirmed +
                ", lesson=" + lesson +
                '}';
    }
}
