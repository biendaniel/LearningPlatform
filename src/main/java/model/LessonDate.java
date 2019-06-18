package model;

import javax.persistence.*;

@Entity
public class LessonDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hourFrom;
    private String hourTo;
    private String isFree;
    private String isConfirmed;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private LessonDay day;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User user;

       public LessonDate(String hourFrom, String hourTo, String isFree, String isConfirmed, LessonDay day, Lesson lesson, User user) {
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
        this.isFree = isFree;
        this.isConfirmed = isConfirmed;
        this.day = day;
        this.lesson = lesson;
        this.user = user;
    }

    public LessonDate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LessonDay getDay() {
        return day;
    }

    public void setDay(LessonDay day) { this.day = day; }

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

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public String getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(String isConfirmed) {
        this.isConfirmed = isConfirmed;
    }


    @Override
    public String toString() {
        return "LessonDate{" +
                "id=" + id +
                ", hourFrom='" + hourFrom + '\'' +
                ", hourTo='" + hourTo + '\'' +
                ", isFree='" + isFree + '\'' +
                ", isConfirmed='" + isConfirmed + '\'' +
                ", day=" + day +
                ", lesson=" + lesson +
                ", user=" + user +
                '}';
    }
}
