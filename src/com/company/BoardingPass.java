package com.company;

import java.sql.Time;
import java.util.Date;
import java.util.Random;

public class BoardingPass {
    String name,email, phoneNumber, gender,destination;
    int age;
    double price;
    int id;
    Date date;
    Time departure,arrival;

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
