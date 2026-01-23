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
______________________________________________________
person

package com.hsbc.beans;
/*
Every class will have a constructor by default.
In the def cons of a subclass or explicit cons of a sub-class, first line
is call to the super class no-arg cons, which is a def cons.
 */
public class Person {
    int id;
    String name;
    String email;

    public Person() {
    }

    public void dispPerson(){
        System.out.println("ID: "+ id + ", Name: " + name + ", Email: " + email);
    }

    public void setValues(int i, String n, String e){
        id = i;
        name = n;
        email = e;
    }

    public Person(int i, String n, String e){
        if (i>0 && i<106){
            this.id = i;
        }
        System.out.println("person object created");

        this.name = n;
        this.email = e;
    }



    //Setter and Getter
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void display(){
        System.out.println("id: "+id+", name: "+name+", email: "+email);
    }
}



/*
byte
short
int
long

float
double

char
boolean
 */