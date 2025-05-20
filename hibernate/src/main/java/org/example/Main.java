package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {

//        Laptop l1 = new Laptop();
//        l1.setLid(1);
//        l1.setModel("Macbook");
//        l1.setCpu("M4");
//        l1.setRam(16);
//
//        Laptop l2 = new Laptop();
//        l2.setLid(2);
//        l2.setModel("Sony");
//        l2.setCpu("i7");
//        l2.setRam(8);
//
//        Laptop l3 = new Laptop();
//        l3.setLid(4);
//        l3.setModel("Hp");
//        l3.setCpu("i9");
//        l3.setRam(32);

//        employee e1 = new employee();
//        e1.setEid(101);
//        e1.setEname("Ginger");
//        e1.setStack("Python");
//        e1.setLaptops(List.of(l1,l2));
//
//        employee e2 = new employee();
//        e2.setEid(102);
//        e2.setEname("Ram");
//        e2.setStack("Java");
//        e2.setLaptops(List.of(l3));





        //Hibernate start from here
        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.employee.class);
        config.addAnnotatedClass(org.example.Laptop.class);

        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();

        Session ses = factory.openSession();




        Transaction transaction = ses.beginTransaction();   /* this is only needed when insert, delete,updating,saving */


        transaction.commit();  /* this is only needed when insert, delete,updating,saving */
        ses.close();
        factory.close();
    }


}



/*Session is a light weigth object
but SessionFactory is heavy object

session can be open and closed
but sessionfactory is should be one

and it is closed by using try but you don't won't to use try catch then close buy ses.close and factory.close

we can also write line no 19,20,21 like this
SessionFactory factory = new Configuration()
                         .addAnnotatedClass(org.example.employee.class)
                         .configure("hibernate.cfg.xml")
                         .buildSessionFactory();



*/

//ses.merge(e1);/* this updates the value */
//
//        employee e1 = ses.get(employee.class,102);   this is deprecated and this is also eager
//
//        employee e1 = ses.byId(employee.class).load(102);
//
//        employee e1 = ses.byId(employee.class).getReference(102); this is used for Lazy fetching
//
//        employee e1 = ses.get(employee.class,101);  /* this is eager fetching */
//        ses.remove(e1);/* this deletes the value but for working this needs the above line  */
//
//            Laptop l1 = ses.find(Laptop.class,4);
//            ses.remove(l1);


//        Student s1=new Student();
//
//        s1.setsid(101);
//        s1.setSname("Sam");
//
//        Alien a2 = new Alien();
//        a2.setSid(102);
//        a2.setSname("Jam");


//        employee e2 =ses.find(employee.class,101);
//        System.out.println(e1);
//
//      employee e1 = ses.get(employee.class,101);
//      Laptop l1 = ses.get(Laptop.class,1);
//      Laptop l2 = ses.get(Laptop.class,2);


        /*  Hql example for fetching

        Query query = ses.createQuery("from Laptop where ram=16");
        List<Laptop> laptops = query.getResultList();
        List<employee> employees = query.getResultList();
        System.out.println(employees);
        System.out.println(laptops);

         */

        /* Hql example for external value

        String model = "Hp";

        Query query = ses.createQuery("from Laptop where model like ?1");
        query.setParameter(1,model);
        List<Laptop> laptops = query.getResultList();
        System.out.println(laptops);

         */

        /* Hql for specific value

        Query query = ses.createQuery("select model from Laptop where model like ?1");
        query.setParameter(1,model);
        List<Laptop> laptops = query.getResultList();
        System.out.println(laptops);

         */

        /* Hql for multiple values this example has string values

        String model = "Hp";

        Query query = ses.createQuery("select model,cpu from Laptop where model like ?1");      but the value should of same type
        query.setParameter(1,model);

        List<Object[]> laptops = query.getResultList();

        for (Object[] data : laptops){
        int i = 1;
            System.out.println((String)data[0]+" "+ (String)data[1]);
        }
        System.out.println(laptops);

         */


        /* Hql for multiple value this example has int value
        String model = "Hp";

        Query query = ses.createQuery("select lid,ram from Laptop where model like ?1");
        query.setParameter(1,model);

        List<Object[]> laptops = query.getResultList();

        for (Object[] data : laptops){
        int i = 1;
            System.out.println(data[0]+" "+ data[1]);
        }
                System.out.println(laptops);

         */