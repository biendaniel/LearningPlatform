package model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer cost;
    private String city;
    private Integer amoutOfNote;
    private Integer note;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User ownerLesson;

    public Lesson(String name, Integer cost, List<LessonDate> lessonDate,User user) {
        this.name = name;
        this.cost = cost;
        this.ownerLesson = user;
    }

    public Lesson() {
    }

    public User getUser() { return ownerLesson; }

    public void setUser(User user) { this.ownerLesson = user; }

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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String address) {
        this.city = address;
    }

    public User getOwnerLesson() {
        return ownerLesson;
    }

    public void setOwnerLesson(User ownerLesson) {
        this.ownerLesson = ownerLesson;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAmoutOfNote() {
        return amoutOfNote;
    }

    public void setAmoutOfNote(Integer amoutOfNote) {
        this.amoutOfNote = amoutOfNote;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
