package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    //Hibernate project by  Justin Holcomb and Roneil Boyce
    public static void main(String[] args) {
        String name,email, phoneNumber, gender,destination;
        int age;
        Date date;
        LocalTime lt;
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
				String time = kb.nextLine();
				lt = LocalTime.parse(time);
				break;
			}
	    	catch(DateTimeParseException e)
			{
				System.out.println(e.toString());
				System.out.println("try again!");
			}
		}
	    System.out.println("name: " + name + " email: " + email + " phone: " + phoneNumber + " age: " + age + " gender: " + gender + " destination: " + destination + " departure time: " + lt.toString());
	    



    }
}
