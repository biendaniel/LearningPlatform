package model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class CourseChapter {

    //TODO - Tutaj stworzlem tylko pola - możliwe, że trzeba dodać jeszcze relacje
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String content;

    @OneToMany(fetch = FetchType.EAGER )
    @JoinColumn(name = "chapterID")
    private List<File> files;

    public CourseChapter(String name, String content, List<File> files) {
        this.name = name;
        this.content = content;
        this.files = files;
    }

    public CourseChapter() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "CourseChapter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", file=" + files +
                '}';
    }
}
