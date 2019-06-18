package model;


import javax.persistence.*;

@Entity
public class LessonDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public LessonDay(String name) {
        this.name = name;
    }

    public LessonDay() {
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

    @Override
    public String toString() {
        return "LessonDay{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
