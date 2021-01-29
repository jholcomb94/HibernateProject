package com.company;
import java.util.Random;
import java.sql.Time;

public class Main {

    public static void main(String[] args) {
	// write your code here
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
