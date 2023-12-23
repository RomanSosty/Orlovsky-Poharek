package org.example.jat;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ApplicationForm implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String contact;
    private String ageCategory;
    private String meansOfTransport;
    private String message;
    @OneToOne
    @JoinColumn(name = "dance_Id")
    private Dance dance;
    @OneToOne
    @JoinColumn(name = "danceGroup_Id")
    private DanceGroup dancegroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getMeansOfTransport() {
        return meansOfTransport;
    }

    public void setMeansOfTransport(String meansOfTransport) {
        this.meansOfTransport = meansOfTransport;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Dance getDance() {
        return dance;
    }

    public void setDance(Dance dance) {
        this.dance = dance;
    }

    public DanceGroup getDancegroup() {
        return dancegroup;
    }

    public void setDancegroup(DanceGroup danceGroup) {
        this.dancegroup = danceGroup;
    }
}
