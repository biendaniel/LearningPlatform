package model;

import javax.persistence.*;

@Entity
public class Opinion {

    //TODO - Tutaj stworzlem tylko pola - możliwe, że trzeba dodać jeszcze relacje
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Integer value;
    @OneToMany
    private User raterUser;
    @OneToMany
    private User evoaluatedUser;
    @ManyToMany
    private CourseChapter courseChapter;

    public Opinion(String content, Integer value, User raterUser, User evoaluatedUser, CourseChapter courseChapter) {
        this.content = content;
        this.value = value;
        this.raterUser = raterUser;
        this.evoaluatedUser = evoaluatedUser;
        this.courseChapter = courseChapter;
    }

    public Opinion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public User getRaterUser() {
        return raterUser;
    }

    public void setRaterUser(User raterUser) {
        this.raterUser = raterUser;
    }

    public User getEvoaluatedUser() {
        return evoaluatedUser;
    }

    public void setEvoaluatedUser(User evoaluatedUser) {
        this.evoaluatedUser = evoaluatedUser;
    }

    public CourseChapter getCourseChapter() {
        return courseChapter;
    }

    public void setCourseChapter(CourseChapter courseChapter) {
        this.courseChapter = courseChapter;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", value=" + value +
                ", raterUser=" + raterUser +
                ", evoaluatedUser=" + evoaluatedUser +
                ", courseChapter=" + courseChapter +
                '}';
    }
}

