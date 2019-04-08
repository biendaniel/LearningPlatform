package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
public class Course {

    //TODO - Póki co przy edycji trzeba podawać dotychczasową listę chapterów, by ich nie usunąć z rozdziału

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    private Subject subject;
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "courseID")
    private List<CourseChapter> chapters;
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "opinionID")
    private List<Opinion> opinions;

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

    public List<Opinion> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<Opinion> opinions) {
        this.opinions = opinions;
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