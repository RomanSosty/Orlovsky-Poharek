package org.example.jat;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ApplicationForm implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nameOfClub;
    private String contact;
    private String ageCategory;
    private int numberOfDancerInGroup;
    private String meansOfTransport;
    private String message;
    @OneToOne
    @JoinColumn(name = "dance_Id")
    private Dance dance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfClub() {
        return nameOfClub;
    }

    public void setNameOfClub(String nameOfClub) {
        this.nameOfClub = nameOfClub;
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


    public int getNumberOfDancerInGroup() {
        return numberOfDancerInGroup;
    }

    public void setNumberOfDancerInGroup(int numberOfDancerInGroup) {
        this.numberOfDancerInGroup = numberOfDancerInGroup;
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
}
