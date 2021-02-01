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
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "gender")
    private String gender;
    @Column(name = "destination")
    private String destination;
    @Column(name = "age")
    private int age;
    @Column(name = "price")
    private double price;
    @Column(name = "date")
    private Date date;
    @Column(name = "departure")
    private Time departure;
    @Column(name = "arrival")
    private Time arrival;


    public BoardingPass(String name, String email, String phoneNumber, String gender, String destination, int age, Date date, Time departure) {
        Random rand = new Random();
        this.id = Math.abs(rand.nextInt()% 100000000);
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
