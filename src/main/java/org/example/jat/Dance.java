package org.example.jat;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class Dance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String choreographer;
    private String category;
    private int numOfDancer;
    private String lenght;
    @OneToOne(mappedBy = "dance",cascade = CascadeType.ALL)
    private ApplicationForm applicationForm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChoreographer() {
        return choreographer;
    }

    public void setChoreographer(String choreographer) {
        this.choreographer = choreographer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumOfDancer() {
        return numOfDancer;
    }

    public void setNumOfDancer(int numOfDancer) {
        this.numOfDancer = numOfDancer;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public ApplicationForm getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(ApplicationForm applicationForm) {
        this.applicationForm = applicationForm;
    }
}
