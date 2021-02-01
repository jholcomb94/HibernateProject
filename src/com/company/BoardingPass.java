package com.company;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Random;
@Entity
@Table(name = "boardingpass")
public class BoardingPass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE NUMBER")
    private String phoneNumber;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "DESTINATION")
    private String destination;
    @Column(name = "AGE")
    private int age;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "DEPARTURE")
    private Time departure;
    @Column(name = "ARRIVAL")
    private Time arrival;


    public BoardingPass(String name, String email, String phoneNumber, String gender, String destination, int age, Date date, Time departure) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.destination = destination;
        this.age = age;
        this.date = date;
        this.departure = departure;
        this.arrival = getArrivalTime();
        this.price = newPrice(age,100,gender);
    }


    private static Time getArrivalTime(){
        final Random random = new Random();
        final int millisInDay = 24*60*60*1000;
        Time time = new Time((long)random.nextInt(millisInDay));
        return time;
    }

    private static double newPrice(int age, double price, String gender){
        double discounted;
        if(age<= 12){
            if(gender.equals("f")){
                discounted = price-(price*.75);
                return discounted;
            }
            discounted= price - (price*.5);
            return discounted;

        }
        else if(age >=60){
            if(gender.equals("f")) {
                discounted = price - (price * .85);
                return discounted;
            }
            discounted= price-(price*.6);
            return discounted;
        }
        return price;

    }
}
