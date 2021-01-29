package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class updateBoardingPass {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();
    Session session = factory.getCurrentSession();

        try{
        int employeeId = 2;
        //Get a new session and start a transaction
        session = factory.getCurrentSession();
        session.beginTransaction();

        //Retrieve student based on the id: primary key
        System.out.println("\nGetting student with id: " + employeeId);
        Employee emp1 = session.get(Employee.class, employeeId);

        //Updating the student first Name at primary key 1
        //use setter so you can change the values
        System.out.println("Updating Student...");
        emp1.setFirstName("Adam");

        //commit the transaction
        session.getTransaction().commit();

        session = factory.getCurrentSession();
        session.beginTransaction();

        //Update email for all students needs .execute update so it will change the database
        //make sure you are quering the class and it needs to match the class name
        System.out.println("Updating company for all the employee...");
        session.createQuery("update Employee set company='BurgerKing'").executeUpdate();
        //or you can use a where clause to be more precise
        session.createQuery("update Employee set company='planetaryExpress' where company='youtube'").executeUpdate();

        //commit the transaction
        session.getTransaction().commit();
        System.out.println("Done!");
    } finally {
        factory.close();
    }
}
