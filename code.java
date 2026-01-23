person.java
package com.hsbc.beans;
/*
Every class will have a constructor by default.
In the def cons of a subclass or explicit cons of a sub-class, first line
is call to the super class no-arg cons, which is a def cons.


A super class reference variable can refer to any of But it can only call 
superclass inherited methods, but not subclass own methods.

If the subclass overrides its superclass method, this reference calls that method, 

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

_______________________________________________________________
persondriver.java
package com.hsbc.app;

import com.hsbc.beans.Manager;
import com.hsbc.beans.Person;
import com.hsbc.beans.Supervisor;

public class PersonDriver {
    public static void main(String[] args) {
        Person p1 = new Person(101, "Sanjjaaaiii", "sanj@nothing.com");
        /*p1.setValues(101, "Sanjai", "msanjai@gmail.com");*/
        //p1.dispPerson();
        System.out.println("p1; "+ p1.toString());
        p1 = new Person(102, "thala", "thalapathy@gmail.com");
        /*p1.setValues(102, "hola", "olaolaoal@yahoo.com");*/
        System.out.println("p1; "+ p1.toString());

        Person p2 = new Person(107, "abcd", "efgh@g.com");
        System.out.println("p2; "+ p2.toString());

        Supervisor s1 = new Supervisor(102,"rkpk", "sample@gmail.com", 15);
        System.out.println("Calling display wuth p1: ");
        p1.display();

        System.out.println("Calling display s1");
        s1.display();

        Manager m1 = new Manager(108, "Rutu","rutu@gmail.com", 18);
        System.out.println("Calling manager:");
        m1.display();
    }
}

_______________________________________________________
manager.java
package com.hsbc.beans;

public class Manager extends Person{
    int qualification;
    public Manager(){
        super();
    }
    public Manager( int id, String name, String email, int qualification){
        super (id, name, email);
        this.qualification=qualification;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("qualification: "+qualification);
    }
}
______________________________________________________________
supervisor.java
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
