package com.hsbc.beans;

public class Supervisor extends Person{
    int experience;

    public Supervisor(){
        super();
        System.out.println("abcd");
    }
    public Supervisor(int id, String name, String email, int experience){
        super (id, name, email);
        this.experience=experience;
    }
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void display(){
        System.out.println("experience: "+experience);
    }
}
