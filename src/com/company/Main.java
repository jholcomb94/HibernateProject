package com.company;
import java.util.Random;
import java.sql.Time;

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

public Time getArrivalTime(){
    final Random random = new Random();
    final int millisInDay = 24*60*60*1000;
    Time time = new Time((long)random.nextInt(millisInDay));
    return time;
}
    public double newPrice(int age, double price, String gender){
        double discounted;
        if(age<= 12){
            if(gender.equals("female")){
            discounted = price-(price*.75);
            return discounted;
            }
            else{
                discounted= price - (price*.5);
                return discounted;

            }

        }
        else if(age >=60){
            if(gender.equals("female")) {
                discounted = price - (price * .85);
                return discounted;
            }
                else{
                    discounted= price-(price*.6);
                    return discounted;
                }
            }
        else return price;

        }

}
