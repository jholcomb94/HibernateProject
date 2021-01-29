//package com.company;
//
//import org.hibernate.*;
//import org.hibernate.cfg.Configuration;
//public class createBoardingPass {
//    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
//    Session session = factory.getCurrentSession();
//try{//Name, Email, Phone Number, Gender, Age Date, Destination, and Departure Time
//        Employee emp1 = new Employee("Ron", "boyceroneil@gmail.com", "9125963481", "Gender", 22, "1/29/2021", "Tokyo", "2:00PM");
//        Employee emp2 = new Employee("Just", "Holo", "Pyramid");
//        Employee emp3 = new Employee("Doto", "Doya", "Youtube");
//        Employee emp4 = new Employee("Rhyme", "Style", "Youtube");
//        Employee emp5 = new Employee("Kitty", "Cat", "Feline");
//        session.beginTransaction();
//        System.out.println("Beginning...");
//
//        session.save(emp1);
//        session.save(emp2);
//        session.save(emp3);
//        session.save(emp4);
//        session.save(emp5);
//        System.out.println("Now saving new employee");
//
//        session.getTransaction().commit();
//        System.out.println("Completed");
//
//    }finally{
//        factory.close();
//    }
//}
