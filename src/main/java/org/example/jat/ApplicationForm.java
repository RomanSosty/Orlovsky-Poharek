package org.example.jat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.sql.Time;

@Entity
public class ApplicationForm implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nameOfClub;
    private String contact;
    private String nameOfChoreografi;
    private String ageCategory;
    private String danceCategory;
    private String nameOfChoreografer;
    private int numberOfDancer;
    private String lenghtOfDance;
    private int numberOfDancerInGroup;
    private String meansOfTransport;
    private String message;

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

    public String getNameOfChoreografi() {
        return nameOfChoreografi;
    }

    public void setNameOfChoreografi(String nameOfChoreografi) {
        this.nameOfChoreografi = nameOfChoreografi;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getDanceCategory() {
        return danceCategory;
    }

    public void setDanceCategory(String danceCategory) {
        this.danceCategory = danceCategory;
    }

    public String getNameOfChoreografer() {
        return nameOfChoreografer;
    }

    public void setNameOfChoreografer(String nameOfChoreografer) {
        this.nameOfChoreografer = nameOfChoreografer;
    }

    public int getNumberOfDancer() {
        return numberOfDancer;
    }

    public void setNumberOfDancer(int numberOfDancer) {
        this.numberOfDancer = numberOfDancer;
    }

    public String getLenghtOfDance() {
        return lenghtOfDance;
    }

    public void setLenghtOfDance(String lenghtOfDance) {
        this.lenghtOfDance = lenghtOfDance;
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
}
