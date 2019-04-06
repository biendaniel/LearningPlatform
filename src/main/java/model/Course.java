package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    //TODO - Tutaj stworzlem tylko pola - możliwe, że trzeba dodać jeszcze relacje
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    private Subject subject;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "courseID")
    private List<CourseChapter> chapters;

    public Course() {

    }

    public List<CourseChapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<CourseChapter> chapters) {
        this.chapters = chapters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }



    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }
}