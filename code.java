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

