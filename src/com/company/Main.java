package com.company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Random;
import java.sql.Time;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

import java.util.*;
public class Main {
    //Hibernate project by  Justin Holcomb and Roneil Boyce
    public static void main(String[] args) {
        String name,email, phoneNumber, gender,destination;
        int age;
        Date date;
        Time lt;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		date = new Date(System.currentTimeMillis());
        Scanner kb = new Scanner(System.in);
	    System.out.println("welcome to the boarding pass ticket gennerator");
	    System.out.println("first we will need your name");
	    name = kb.nextLine();
	    System.out.println("email?");
	    email = kb.nextLine();
	    System.out.println("phone?");
	    phoneNumber = kb.nextLine();
	    System.out.println("age?");
	    age = kb.nextInt();
	    kb.nextLine();
	    System.out.println("gender?");
	    gender = kb.nextLine();
	    System.out.println("destination?");
	    destination = kb.nextLine();
	    while(true) {
	    	try {
				System.out.println("finally, what time would you like to depart? (enter the time in the format hh:mm:ss)");
				String t = kb.nextLine();
				lt = Time.valueOf(t);
				break;
			}
	    	catch(DateTimeParseException e)
			{
				System.out.println(e.toString());
				System.out.println("try again!");
			}
		}
	    System.out.println("name: " + name + " email: " + email + " phone: " + phoneNumber + " age: " + age + " gender: " + gender + " destination: " + destination + " departure time: " + lt.toString());
	    BoardingPass bp = new BoardingPass(name,email,phoneNumber,gender,destination,age,date,lt);

	    addToDB(bp);


        try {
        	String jo ="date " + bp.getDate().toString() + "name: " + bp.getName() + " email: " + bp.getEmail() + " phone: " + bp.getPhoneNumber() + " age: " + bp.getAge() +
					" gender: " + bp.getGender() + " destination: " + bp.getDestination() + " departure time: " + bp.getDeparture().toString() +" price: " +
					bp.getPrice() + " arrival time " + bp.getArrival().toString() +"\n";
           // File myObj = new File("practice.txt");
			//Files.writeString()
			Files.write(Paths.get("practice.txt"), jo.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE,StandardOpenOption.APPEND);

				//Files.createFile(Paths.get("test2.txt"));
                //System.out.println("File already exists.");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

	}




    public static void addToDB(BoardingPass bp)
    {
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BoardingPass.class).buildSessionFactory();
            Session session = factory.getCurrentSession();
            try{//Name, Email, Phone Number, Gender, Age Date, Destination, and Departure Time

                session.beginTransaction();
                System.out.println("Beginning...");
                session.save(bp);
                System.out.println("Now saving new boarding pass");
                session.getTransaction().commit();
                System.out.println("Completed");

            }finally{
                factory.close();
            }
    }


}
