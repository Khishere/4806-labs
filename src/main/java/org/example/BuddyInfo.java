package org.example;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class BuddyInfo {
    private String name;
    private String phoneNum;
    @Id
        @GeneratedValue
        private Long id;

        //constructors
        //default constructor
    public BuddyInfo() {
    }
    //arg constructor
    public BuddyInfo(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }
    //setters and getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public Long getId() { return id;}
    public void setId(Long newId) {this.id = newId;}
    @Override
    public String toString() {
        return String.format(
                "Buddy[id=%d, name='%s', phone number='%s']",
                id, name, phoneNum);
    }
}
