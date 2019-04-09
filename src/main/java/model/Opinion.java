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
    @ManyToOne
    private User raterUser; // oceniający

    public Opinion(String content, Integer value, User raterUser) {
        this.content = content;
        this.value = value;
        this.raterUser = raterUser;
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

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", value=" + value +
                ", raterUser=" + raterUser +
                '}';
    }
}

