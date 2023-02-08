package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;
    @Id
    @GeneratedValue
    private Long id;
    public AddressBook() {
        this.buddies = new ArrayList<BuddyInfo>();
    }
    public List<BuddyInfo> getBuddies(){
        return buddies;
    }
    public void setBuddies(List<BuddyInfo> buddies){this.buddies = buddies;}
    public void addBuddy(BuddyInfo buddyInfo) {
        this.buddies.add(buddyInfo);
    }
    public BuddyInfo getBuddy(int i) {
        return this.buddies.get(i);
    }
    public void removeBuddy(int i) {
        BuddyInfo b = this.buddies.remove(i);
    }

    @Override
    public String toString() {
        String s ="";
        for(BuddyInfo buddy:buddies) {
            s+= ", " + buddy.toString();
        }
        return s;
    }

    public Long getId() {return this.id;}
    public void setID(Long newId) {this.id = newId;}
}
