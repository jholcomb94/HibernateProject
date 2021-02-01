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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getDeparture() {
        return departure;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;
    }

    public Time getArrival() {
        return arrival;
    }

    public void setArrival(Time arrival) {
        this.arrival = arrival;
    }

    @Column(name = "arrival")
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
