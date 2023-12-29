package org.example.jat;

import org.example.jat.entity.Member;

import java.util.List;

public class FormResponse {
    private String groupName;
    private String contact;
    private String choreografiName;
    private String ageCategory;
    private String danceCategory;
    private String nameOfChoreografer;
    private int numOfDancer;
    private String lenghtOfDance;
    private int numOfDancerInGroup;
    private String meansOfTransport;
    private String message;
    private List<Member> members;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getChoreografiName() {
        return choreografiName;
    }

    public void setChoreografiName(String choreografiName) {
        this.choreografiName = choreografiName;
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

    public int getNumOfDancer() {
        return numOfDancer;
    }

    public void setNumOfDancer(int numOfDancer) {
        this.numOfDancer = numOfDancer;
    }

    public String getLenghtOfDance() {
        return lenghtOfDance;
    }

    public void setLenghtOfDance(String lenghtOfDance) {
        this.lenghtOfDance = lenghtOfDance;
    }

    public int getNumOfDancerInGroup() {
        return numOfDancerInGroup;
    }

    public void setNumOfDancerInGroup(int numOfDancerInGroup) {
        this.numOfDancerInGroup = numOfDancerInGroup;
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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
