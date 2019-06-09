package model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToOne
    private Subject subject;
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "courseID")
    private List<CourseChapter> chapters;
    @OneToMany()
    @JoinColumn(name = "courseID" +
            "")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CourseOpinion> opinions;


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

    public List<CourseOpinion> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<CourseOpinion> opinions) {
        this.opinions = opinions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                ", chapters=" + chapters +
                ", opinions=" + opinions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(name, course.name) &&
                Objects.equals(subject, course.subject) &&
                Objects.equals(chapters, course.chapters) &&
                Objects.equals(opinions, course.opinions) &&
                Objects.equals(description, course.description)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subject, chapters, opinions,description);
    }
}